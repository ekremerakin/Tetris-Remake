import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * This class responsible for taking input 
 * and decide what to do in order to that.
 */
public class KeyListener extends KeyAdapter {

	/*
	 * Connecting the KeyListener to TetrisControl class 
	 * to control the tetris pieces.
	 */
	private TetrisControl tetrisControl;
	
	/*
	 * This variable was created to solve a bug. When the
	 * user first time pressing the up button, its not 
	 * rotating the object. But with this variable, now 
	 * player able to move the piece whenever he/she wants.
	 */
	private static boolean rotateFirstTime;
	
	/*
	 * Constructor for the KeyListener class.
	 */
	protected KeyListener(TetrisControl tetrisControl) {
		this.tetrisControl = tetrisControl;
	}
	
	/*
	 * KeyPressed method was override.
	 */
	@Override
	public void keyPressed(KeyEvent e) {	
		
		switch(e.getKeyCode()){
			case KeyEvent.VK_W:
			case KeyEvent.VK_UP:
				if(tetrisControl.getIsNewGame() 
						&& !tetrisControl.getIsPause()
						&& CollisionHandler.checkAllThePiecesInsideTheGameScreen()){
					if(rotateFirstTime){
						tetrisControl.currentPiece.rotate();
						rotateFirstTime = false;
					}
					tetrisControl.currentPiece.rotate();
				}
				break;
				
			case KeyEvent.VK_S:
			case KeyEvent.VK_DOWN:
				if(tetrisControl.getIsNewGame() 
						&& !tetrisControl.getIsPause()
						&& CollisionHandler.checkAllThePiecesInsideTheGameScreen()) 
					tetrisControl.currentPiece.gravity();
				break;
				
			case KeyEvent.VK_A:
			case KeyEvent.VK_LEFT:
				if(tetrisControl.getIsNewGame() 
						&& !tetrisControl.getIsPause()
						&& CollisionHandler.checkAllThePiecesInsideTheGameScreen()
						&& CollisionHandler.getIsLeft()) 
				tetrisControl.currentPiece.moveLeft();
				break;
				
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
				if(tetrisControl.getIsNewGame() 
						&& !tetrisControl.getIsPause()
						&& CollisionHandler.checkAllThePiecesInsideTheGameScreen()
						&& CollisionHandler.getIsRight()) 
					tetrisControl.currentPiece.moveRight();
				break;
				
			case KeyEvent.VK_ENTER:
				if(tetrisControl.getIsNewGame() == false) {
					tetrisControl.setIsNewGame(true);
				}
				break;
				
			case KeyEvent.VK_P:
				if(tetrisControl.getIsPause() == false) {
					tetrisControl.setIsPause(true);	
				}
				else {
					tetrisControl.setIsPause(false);
				}
				break;
		}	
		
	}
	
	/*
	 * Encapsulation for rotateFirstTime.
	 */
	public static void setTrueRotateFirstTime() {
		rotateFirstTime = true;
	}
}
