import java.awt.Color;

/*
 * This method was written to control the collision handling.
 * It defines the game screen as various of numbers.
 */
public class CollisionHandler {
	
	/*
	 * This variable counts the score.
	 */
	private static int scoreCounter;
	
	/*
	 * Following 2 variables responsible to control is 
	 * the piece can go left or right.
	 */
	private static boolean isLeft = true;
	private static boolean isRight =true;
	
	/*
	 * - Empty block was numbered by 0.
	 * - If the tetris piece is not moving,
	 * that blocks were numbered by 1.
	 * - If the tetris piece is moving,
	 * that blocks were numbered by 2.
	 * 
	 * Empty block has the default value.
	 */
	private static int[][] collisionPoints = new int[][] {
	//   1  2  3  4  5  6  7  8  9 10
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //1
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //2
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //3
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //4
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //5
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //6
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //7
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //8
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //9
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //10
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //11
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //12
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //13
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //14
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //15
 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}  //16
	};
	
	/*
	 * It displays the collisionPoints array to the console
	 * for debugging.
	 */
	protected static void showCollisionPoints() {
		for(int i=0;i<16;i++){
			for(int j=0;j<10;j++){
				System.out.print(collisionPoints[i][j]);
			}
			System.out.println("");
		}
		System.out.println("----------" );
	}
	
	/*
	 * This method created to calculate how many points are 
	 * in to the first 3th row of the collisionPoints array while 
	 * checking each point of there with the number 2.
	 * 
	 * if there is just 3 or less points on the collisionPoints array, 
	 * then player cannot move the piece since 4 points has to 
	 * placed in the collisionPoints array. If this method not created,
	 * then player can move the pieces even the piece is not in the
	 * game screen. That can cause the problem to crash. Because of
	 * that, this method was written.
	 */
	protected static boolean checkAllThePiecesInsideTheGameScreen() {
		int count = 0;
		for(int i=0;i<16;i++){
			for(int j=0;j<10;j++){
				if(collisionPoints[i][j] == 2) 
					count++;
			}
		}
		if(count==4)
			return true;
		return false;
	}

	/*
	 * After the piece collide, this method changes all the 
	 * points that current piece have to the number of 1. This
	 * helps to make the collision process much more easier.
	 */
	protected static void collide() {
		for(int i=0;i<16;i++){
			for(int j=0;j<10;j++){
				if(collisionPoints[i][j] == 2) 
					collisionPoints[i][j] = 1;
			}
		}
	}	
	
	/*
	 * This method checking every line of the tetris display.
	 * If it finds all the values in that line is 1, it
	 * start clearing that line and placing all the other 
	 * pieces to their new location.
	 */
	protected static int checkScore() {
		scoreCounter=0;
		int total=0;
		for(int i=1;i<16;i++){
			scoreCounter=0;
			for(int j=0;j<10;j++){
				if(collisionPoints[i][j] == 1) {
					scoreCounter++;
				}else {
					break;
				}
			}
			if(scoreCounter==10) {
				for(int m=i;m>0;m--) {
					for(int n=0;n<10;n++) {
						Color color = TetrisPieces.getGameScreen().getData().get(m-1).get(n).getColor();
						TetrisPieces.getGameScreen().getData().get(m).get(n).lightClose();
						collisionPoints[m][n] = collisionPoints[m-1][n];
						TetrisPieces.getGameScreen().getData().get(m).get(n).lightUp(color);
						TetrisPieces.getGameScreen().getData().get(m-1).get(n).lightClose();
					}
				}
				total+=100;
			}
			for(int x=0;x<10;x++) {
				collisionPoints[0][x] = 0;
			}
				scoreCounter=0;
			}
			scoreCounter=0;
		return total;
	}
	
	/*
	 * Checking the end game situation.
	 */
	protected static boolean checkEndGame() {
		for(int i=3;i<6;i++) {
			if(collisionPoints[1][i] == 1) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * If game is finished, set all the points on the array to 0.
	 */
	protected static void setAllPoints0() {
		collisionPoints = new int[][] {
			//   1  2  3  4  5  6  7  8  9 10
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //1
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //2
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //3
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //4
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //5
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //6
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //7
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //8
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //9
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //10
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //11
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //12
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //13
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //14
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //15
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}  //16
			};
	}
	
	/*
	 * Encapsulated variables.
	 */
	protected static int[][] getCollisionPoint() {
		return collisionPoints;
	}
	
	protected static void setCollisionPoint(int x, int y, int i) {
		collisionPoints[y][x] = i;
	}
	
	protected static boolean getIsLeft() {
		return isLeft;
	}
	
	protected static boolean getIsRight() {
		return isRight;
	}
	
	protected static void setIsLeft(boolean change) {
		isLeft = change;
	}
	
	protected static void setIsRight(boolean change) {
		isRight = change;
	}
}
