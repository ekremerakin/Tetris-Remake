import java.awt.Color;

/*
 * This class was written to control the each individual
 * part of the tetris pieces.
 */
public class TetrisIndividualPieces {
	
	/*
	 * Connecting the TetrisPieces to GameScreen class.
	 */
	private GameScreen gameScreen;
	
	/*
	 * Holds the color for each piece.
	 */
	private Color color;

	/*
	 * Controls the piece is dead or not.
	 */
	private static boolean isAlive;
	
	/*
	 * rotateCount defined because of some of the piece's
	 * parts move 2 block instead of 1 block at the 
	 * beginning of dropping process. To solve that problem,
	 * rotateCount variable declared and used in several methods.
	 */
	private static int rotateCount;
	
	/*
	 * Following 2 variables created to enable any pieces
	 * to move in any direction. Without this 2 variables, 
	 * piece cannot move properly when it's rotated.
	 */
	private boolean isMovedX;
	private boolean isMovedY;
	
	/*
	 * Returns is the part of the piece can move or not.
	 */
	private boolean isPivot;
	
	/*
	 * Some methods are calling 4 times for the same pieces. So, 
	 * some pieces is moving at the beginning and others shouldn't 
	 * move when they are moving. Every particle can move just 1 time in 
	 * 4 times periods.
	 */
	private int roundCount=1;
	
	/*
	 * Holding the x variable for 2D ArrayList.
	 */
	private int x;
	
	/*
	 * Holding the y variable for 2D ArrayList.
	 */
	private int y;
	
	/*
	 * Holds the old x and y values.
	 */
	private int oldX;
	private int oldY;
	
	/*
	 * Holds the new x and y values.
	 */
	private int newX;
	private int newY;
	
	/*
	 * Constructor for TetrisPieces class to create 
	 * TetrisPiece's objects.
	 */
	protected TetrisIndividualPieces(int x, int y, GameScreen gameScreen, Color color) {
		this.x = x;
		this.y = y;
		this.gameScreen = gameScreen;
		this.color = color;
		isAlive = true;
		isPivot = false;
		isMovedX = false;
		isMovedY = true;
		rotateCount = 1;
	}
	
	/*
	 * This method responsible for gravitation. If the player
	 * wants to move the piece downward or game automatically
	 * moves it, all the time this method is calling.
	 */
	protected void gravity() {
		if(isAlive && isMovedY) {
			if(y < -1 && rotateCount==1) {
				y++;
				roundCount--;
			}else if(y == -1 && CollisionHandler.getCollisionPoint()[y+1][x] != 2 && roundCount==1){
				y++;
				gameScreen.getData().get(y).get(x).lightUp(color);
				CollisionHandler.setCollisionPoint(x, y, 2);
				isMovedY = false;
				roundCount--;
			}else if(y >= 0 && CollisionHandler.getCollisionPoint()[y+1][x] != 2 && roundCount==1){
				gameScreen.getData().get(y).get(x).lightClose();
				CollisionHandler.setCollisionPoint(x, y, 0);
				y++;
				gameScreen.getData().get(y).get(x).lightUp(color);
				CollisionHandler.setCollisionPoint(x, y, 2);
				isMovedY = false;
				roundCount--;
			}
		}
	}
	
	/*
	 * This method checking the collision for Y axis. Reason
	 * of creating different functions for checking the X and Y
	 * axis collision methods is if the player hit something
	 * in Y axis, player's piece would stop working and new 
	 * piece will be dropped. But, when the time player hit 
	 * something in X axis, player cannot go to that side until
	 * he/she moves other side. So that, collision for X and Y axis 
	 * methods were written different because of that.
	 */
	protected void collisionCheckY() {
		int[][] collisionPoints = CollisionHandler.getCollisionPoint();
		if(y==15) {
			isAlive = false;
			CollisionHandler.collide();
		}
		if(y>=0 && y<15 && x>=0 && x<10) {
			if(collisionPoints[y+1][x] == 1) {
				isAlive = false;
				CollisionHandler.collide();
			}
			isMovedY = true;
			
		}
		
	}
	
	/*
	 * This function takes and int parameter as an input to
	 * decide where to go.
	 * if i=-1 
	 * 	piece goes left
	 * if i=1
	 * 	piece goes right
	 */
	protected void moveLeftOrRight(int i) {
		if(isAlive 
				&& CollisionHandler.getIsLeft() 
				&& CollisionHandler.getIsRight()
				&& isMovedX) {
			
			if(x>=0 && x<10){
				
				if(!(CollisionHandler.getCollisionPoint()[y][x+i] == 2) ) {

				gameScreen.getData().get(y).get(x).lightClose();
				CollisionHandler.setCollisionPoint(x, y, 0);
				
				x+=i;
				
				gameScreen.getData().get(y).get(x).lightUp(color);
				CollisionHandler.setCollisionPoint(x, y, 2);
				
				isMovedX = false;
				}
			}
		}
		
	}
	
	/*
	 * This method checking the collision for X axis. Reason
	 * of creating different functions for checking the X and Y
	 * axis collision methods is if the player hit something
	 * in Y axis, player's piece would stop working and new 
	 * piece will be dropped. But, when the time player hit 
	 * something in X axis, player cannot go to that side until
	 * he/she moves other side. So that, collision for X and Y axis 
	 * methods were written different because of that.
	 */
	protected void collisionCheckX(int leftOrRigth) {
		int[][] collisionPoints = CollisionHandler.getCollisionPoint();
		if(leftOrRigth==1 && x>=9) {
			CollisionHandler.setIsRight(false);
			CollisionHandler.setIsLeft(true);
		}else if(leftOrRigth==1 && collisionPoints[y][x+1] == 0) {
			CollisionHandler.setIsLeft(true);
		}else if(leftOrRigth==1 && collisionPoints[y][x+1] == 1) {
			CollisionHandler.setIsRight(false);
			CollisionHandler.setIsLeft(true);
		}else if(leftOrRigth==1 && collisionPoints[y][x+1] == 2) {
			CollisionHandler.setIsLeft(true);
		}

		if(leftOrRigth==-1 && x==0) {
			CollisionHandler.setIsLeft(false);
			CollisionHandler.setIsRight(true);
		}else if(leftOrRigth==-1 && collisionPoints[y][x-1] == 0) {
			CollisionHandler.setIsRight(true);
		}else if(leftOrRigth==-1 && collisionPoints[y][x-1] == 1) {
			CollisionHandler.setIsLeft(false);
			CollisionHandler.setIsRight(true);
		}else if(leftOrRigth==-1 && collisionPoints[y][x-1] == 2) {
			CollisionHandler.setIsRight(true);
		}
		
		isMovedX = true;
	}
	
	/*
	 * This method calculates the new rotation points.
	 */
	protected void rotate(int pivotX, int pivotY, int angle) {
		int sin = (int) Math.sin(Math.toRadians(angle));
		int cos = (int) Math.cos(Math.toRadians(angle));
		
		oldX = x;
		oldY = y;

		oldX -= pivotX;
		oldY -= pivotY;

		newX = (oldX*cos - oldY*sin);
		newY = (oldX*sin + oldY*cos);
		
		newX += pivotX;
		newY += pivotY;
		
		if(newX>=0 && newX<10 && newY>0 && newY<16 && CollisionHandler.getCollisionPoint()[newY][newX] != 1) {
			rotateCount++;
		}
		
	}
	
	/*
	 * This method displays the rotation.
	 */
	protected void rotateDisplay() {
		if(isAlive && rotateCount==3) {
			if(x>=0 && x<10){
				gameScreen.getData().get(y).get(x).lightClose();
				CollisionHandler.setCollisionPoint(x, y, 0);
				x = newX;
				y = newY;
				gameScreen.getData().get(y).get(x).lightUp(color);
				CollisionHandler.setCollisionPoint(x, y, 2);
			}
		}
	}
	
	/* 
	 * Variables were encapsulated.
	 */
	protected  GameScreen getGameScreen() {
		return gameScreen;
	}
	
	protected int getX() {
		return x;
	}
	
	protected int getY() {
		return y;
	}
	
	protected void addX(int i) {
		x+=i;
	}
	
	protected void addY(int i) {
		x+=i;
	}

	protected Color getColor() {
		return color;
	}
	
	protected boolean getIsAlive() {
		return isAlive;
	}
	
	protected boolean getPivot() {
		return isPivot;
	}
	
	protected void setPivot(boolean pivotValue) {
		isPivot = pivotValue;
	}
	
	protected static void setRotateCount(int rotateCount) {
		TetrisIndividualPieces.rotateCount = rotateCount;
	}
	
	public void addOneToRoundCount() {
		roundCount += 1;
	}
}
