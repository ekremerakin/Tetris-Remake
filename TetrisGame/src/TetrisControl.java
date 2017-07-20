/*
 * This class written as a thread to control all the 
 * game activities. It also has the run method which
 * include the game loop.
 */
public class TetrisControl extends Thread {
	
	/*
	 * TetrisGame class' object created.
	 */
	private TetrisGame tetrisGame;
	
	/*
	 * Connecting the GameScreen class to TetrisControl class.
	 */
	private GameScreen gameScreen;	
	
	/*
	 * It's for displaying the current piece.
	 */
	protected TetrisPieces currentPiece;	
	
	/*
	 * It's for displaying the next piece.
	 */
	protected TetrisPieces nextPiece;
	
	/*
	 * Boolean value for starting the game.
	 */
	private boolean isNewGame = false;
	
	/*
	 * Boolean value for pausing the game.
	 */
	private boolean isPause = false;
	
	/*
	 * Boolean value for finishing the game.
	 */
	private boolean isGameOver = false;
	
	/*
	 * Constructor of this class. It declared required variables to run
	 * the program.
	 */
	protected TetrisControl(GameScreen gameScreen, TetrisGame tetrisGame) {
		this.gameScreen = gameScreen;
		currentPiece = new TetrisPieces(gameScreen);
		KeyListener.setTrueRotateFirstTime();
		nextPiece = new TetrisPieces(gameScreen);
		this.tetrisGame = tetrisGame;
		tetrisGame.getSidePanel().settingNextPiece(nextPiece.getRandomPiece());
	}

	/*
	 * Game loop.
	 */
	@Override
	public void run() {
		while(true) {
			sleepMethod(5);
			while(isNewGame) {
				sleepMethod(5);
				while(getIsPause() == false) {
					currentPiece.gravity();
					SidePanel.addScore(CollisionHandler.checkScore());
					if(!(currentPiece.isAlive())) {
						if(CollisionHandler.checkEndGame()) {
							tetrisGame.setGameScreen(new GameScreen());
							CollisionHandler.setAllPoints0();
							isGameOver = true;
							tetrisGame.getSidePanel().clearNextPieceArea();
						} else {
						SidePanel.addScore(10);
						currentPiece = nextPiece;
						KeyListener.setTrueRotateFirstTime();
						CollisionHandler.setIsLeft(true);
						CollisionHandler.setIsRight(true);
						nextPiece = new TetrisPieces(gameScreen);
						tetrisGame.getSidePanel().settingNextPiece(nextPiece.getRandomPiece());
						}
					}
					if(isGameOver == true) {
						isGameOver = false;
						isNewGame = false;
						
						break;
					}
					//For Debug
					//CollisionHandler.showCollisionPoints();.
					sleepMethod(500);
				}
			}	
		}
	}
	
	
	
	/*
	 * Thread class' sleep method defined in here.
	 */
	protected void sleepMethod(int miliSec) {
		try {
			sleep(miliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Encapsulation for isNewGame. 
	 */
	protected boolean getIsNewGame() {
		return isNewGame;
	}
	
	protected void setIsNewGame(boolean isNewGame) {
		this.isNewGame = isNewGame;
	}
	
	/*
	 * Encapsulation for isPause. 
	 */
	protected boolean getIsPause() {
		return isPause;
	}
	
	protected void setIsPause(boolean isPause) {
		this.isPause = isPause;
	}
	
}
