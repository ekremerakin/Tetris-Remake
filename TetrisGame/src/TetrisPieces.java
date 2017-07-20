import java.awt.Color;
import java.util.Random;

/*
 * TetrisPieces class is responsible for creating a
 * random piece and control its individual parts. Also,
 * this class is controlling by the TetrisControl class.
 */
public class TetrisPieces {
	
	/*
	 * Connecting the TetrisPieces to GameScreen class.
	 */
	private static GameScreen gameScreen;
	
	/*
	 * Following four variables holds information 
	 * for each individual part of a piece.
	 */
	private TetrisIndividualPieces piece1;
	private TetrisIndividualPieces piece2;
	private TetrisIndividualPieces piece3;
	private TetrisIndividualPieces piece4;
	
	/*
	 * For creating random pieces.
	 */
	private Random random;
	
	/*
	 * randomPiece variable which is holding the
	 * random integer value.
	 */
	private int randomPiece;
	
	/*
	 * Constructor for TetrisControl to create
	 * TetrisPiece's objects. 
	 */
	protected TetrisPieces(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		random = new Random();
		selectPiece();
	}
	
	/*
	 * This method stores the piece information.
	 */
	private void selectPiece() {

		randomPiece = random.nextInt(7)+1;

		//For Debug
		//System.out.println("New piece created: " + randomPiece);
		
		switch(randomPiece) {
		
			/*  ------------
			 *  | 4  |	3  |
			 *  ------------
			 *  | 1  |	2  |
			 *  ------------
			 */
			case 1: 
				piece1 = new TetrisIndividualPieces(4, -1, gameScreen, Color.BLUE);
				piece2 = new TetrisIndividualPieces(5, -1, gameScreen, Color.BLUE);
				piece3 = new TetrisIndividualPieces(5, -2, gameScreen, Color.BLUE);
				piece4 = new TetrisIndividualPieces(4, -2, gameScreen, Color.BLUE);
				break;
				
			/*  ------------
			 *  | 4  |	3  |
			 *  ------------------
			 *  	 |  2  |  1  |
			 *  	 -------------
			 */
			case 2:
				piece1 = new TetrisIndividualPieces(5, -1, gameScreen, Color.PINK);
				piece2 = new TetrisIndividualPieces(4, -1, gameScreen, Color.PINK);
				piece3 = new TetrisIndividualPieces(4, -2, gameScreen, Color.PINK);
				piece4 = new TetrisIndividualPieces(3, -2, gameScreen, Color.PINK);
				break;
				
			/*  	  -------------
			 *  	  |  3  |  4  |
			 *  -------------------
			 *  |  1  |  2  |
			 *  -------------
			 */
			case 3:
				piece1 = new TetrisIndividualPieces(3, -1, gameScreen, Color.ORANGE);
				piece2 = new TetrisIndividualPieces(4, -1, gameScreen, Color.ORANGE);
				piece3 = new TetrisIndividualPieces(4, -2, gameScreen, Color.ORANGE);
				piece4 = new TetrisIndividualPieces(5, -2, gameScreen, Color.ORANGE);
				break;
				
			/*  ------
			 *  | 4  |
			 *  ------------
			 *  | 3  |	2  |
			 *  ------------
			 *  | 1  |
			 *  ------
			 */
			case 4:
				piece1 = new TetrisIndividualPieces(4, -1, gameScreen, Color.YELLOW);
				piece2 = new TetrisIndividualPieces(5, -2, gameScreen, Color.YELLOW);
				piece3 = new TetrisIndividualPieces(4, -2, gameScreen, Color.YELLOW);
				piece4 = new TetrisIndividualPieces(4, -3, gameScreen, Color.YELLOW);
				break;
				
			/*  ------
			 *  | 4  |
			 *  ------
			 *  | 3  |	  
			 *  ------------
			 *  | 1  |  2  |
			 *  ------------
			 */
			case 5:
				piece1 = new TetrisIndividualPieces(4, -1, gameScreen, Color.RED);
				piece2 = new TetrisIndividualPieces(5, -1, gameScreen, Color.RED);
				piece3 = new TetrisIndividualPieces(4, -2, gameScreen, Color.RED);
				piece4 = new TetrisIndividualPieces(4, -3, gameScreen, Color.RED);
				break;
				
			/*        -------
			 *        |  4  |
			 *        -------
			 *        |  3  |	  
			 *  ------------
			 *  |  1  |  2  |
			 *  -------------
			 */
			case 6:
				piece1 = new TetrisIndividualPieces(4, -1, gameScreen, Color.CYAN);
				piece2 = new TetrisIndividualPieces(5, -1, gameScreen, Color.CYAN);
				piece3 = new TetrisIndividualPieces(5, -2, gameScreen, Color.CYAN);
				piece4 = new TetrisIndividualPieces(5, -3, gameScreen, Color.CYAN);
				break;
				
			/*  -------
			 *  |  4  |
			 *  -------
			 *  |  3  |	  
			 *  -------
			 *  |  2  |
			 *  -------
			 *  |  1  |
			 *  -------
			 */
			case 7:
				piece1 = new TetrisIndividualPieces(5, -1, gameScreen, Color.GREEN);
				piece2 = new TetrisIndividualPieces(5, -2, gameScreen, Color.GREEN);
				piece3 = new TetrisIndividualPieces(5, -3, gameScreen, Color.GREEN);
				piece4 = new TetrisIndividualPieces(5, -4, gameScreen, Color.GREEN);
				break;
		}
		
	}
	
	/*
	 * Gravity moves the each part of the piece one
	 * block down after checking the collision. Inside
	 * the for loop, gravity method calling 
	 * each piece for 4 times. But, for each piece,
	 * gravity method works just one time. That situation
	 * explained better in the TetrrisIndividualPieces class.
	 */
	protected void gravity() {
		
		piece1.collisionCheckY();
		piece2.collisionCheckY();
		piece3.collisionCheckY();
		piece4.collisionCheckY();

		for(int i=0;i<4;i++) {
			piece1.gravity();
			piece2.gravity();
			piece3.gravity();
			piece4.gravity();
		}
		
		piece1.addOneToRoundCount();
		piece2.addOneToRoundCount();
		piece3.addOneToRoundCount();
		piece4.addOneToRoundCount();
	}
	
	/*
	 * This method moves the each part of the piece
	 * one left block after checking the collision.Inside
	 * the for loop, moveLeftOrRight method calling 
	 * each piece for 4 times. But, for each piece,
	 * moveLeftOrRight method works just one time. That situation
	 * explained better in the TetrrisIndividualPieces class.
	 */
	protected void moveLeft() {
		
		piece1.collisionCheckX(-1);
		piece2.collisionCheckX(-1);
		piece3.collisionCheckX(-1);
		piece4.collisionCheckX(-1);
		
		for(int i=0;i<4;i++) {
			piece1.moveLeftOrRight(-1);
			piece2.moveLeftOrRight(-1);
			piece3.moveLeftOrRight(-1);
			piece4.moveLeftOrRight(-1);
		}
		
	}

	/*
	 * This method moves the each part of the piece
	 * one right block after checking the collision.Inside
	 * the for loop, moveLeftOrRight method calling 
	 * each piece for 4 times. But, for each piece,
	 * moveLeftOrRight method works just one time. That situation
	 * explained better in the TetrrisIndividualPieces class.
	 */
	protected void moveRight() {
		
		piece1.collisionCheckX(1);
		piece2.collisionCheckX(1);
		piece3.collisionCheckX(1);
		piece4.collisionCheckX(1);
		
		for(int i=0;i<4;i++) {
			piece1.moveLeftOrRight(1);
			piece2.moveLeftOrRight(1);
			piece3.moveLeftOrRight(1);
			piece4.moveLeftOrRight(1);
		}
	
	}
	
	/*
	 * This method rotates the each part of the piece
	 * 90 degree right after checking the collision.Inside
	 * the for loop, rotateDisplay method calling 
	 * each piece, except the piece,for 3 times. But, for each piece,
	 * rotateDisplay method executing just one time. That situation
	 * explained better in the TetrrisIndividualPieces class.
	 */
	protected void rotate() {
		
		piece1.rotate(piece3.getX(), piece3.getY(), 90);
		piece2.rotate(piece3.getX(), piece3.getY(), 90);
		piece4.rotate(piece3.getX(), piece3.getY(), 90);

		for(int i=0;i<4;i++) {
			piece1.rotateDisplay();
			piece2.rotateDisplay();
			piece4.rotateDisplay();
		}
		TetrisIndividualPieces.setRotateCount(0);
		
	}
	
	/*
	 * Encapsulated variable(s).
	 */
	protected static GameScreen getGameScreen() {
		return gameScreen;
	}
	
	protected Color getColor() {
		return piece1.getColor();
	}
	
	protected boolean isAlive() {
		return piece1.getIsAlive();
	}

	protected int getRandomPiece() {
		return randomPiece;
	}

}
