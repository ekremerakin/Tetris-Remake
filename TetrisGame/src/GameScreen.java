import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/*
 * This class created the layout for game screen, creates
 * the game thread and starts it. 
 */
public class GameScreen extends JPanel {
	
	/*
	 * Serial version UID 
	 */
	private static final long serialVersionUID = -5942294093173461966L;	
	
	/*
	 * To run the game(gameLoop), TetrisControl variable 
	 * created.
	 */
	private TetrisControl tetrisControl; 

	/*
	 * Data variable holds the information for each block
	 * while using a 2D ArrayList.
	 */
	private ArrayList<ArrayList<DataOfSquare>> data;
	
	/*
	 * Declaring a row constant.
	 */
	private final int ROWS = 16;
	
	/*
	 * Declaring a col constant.
	 */
	private final int COLS = 10;
	
	/*
	 * Default constructor.
	 */
	public GameScreen() {
		cleanScreen();
	}
	
	/*
	 * Constructor for GameScreen class.
	 * -it's responsible for defining the screenWidth
	 * and screenHeigth and also, it defines the
	 * panel's information.
	 */
	public GameScreen(int screenWidth, int screenHeight, TetrisGame tetrisGame) {
		
		setBackground(Color.WHITE);
		setLayout(new GridLayout(16, 10, 3, 3));
		setBounds(0, 0, screenWidth, screenHeight);
		setVisible(true);
		
		cleanScreen();
		tetrisControl = tetrisGame.getTetrisControl();
	}
	
	/*
	 * Cleans the screen while replacing the old JPanels 
	 * with new DataOfSquare JPanels.
	 */
	protected void cleanScreen() {
		data = new ArrayList<ArrayList<DataOfSquare>>();
		/*
		 * Declaring variables to each section of the 
		 * 2D ArrayList.
		 */
		for ( int i=0 ; i<ROWS ; i++) {
			ArrayList<DataOfSquare> rowData = new ArrayList<>();
			for ( int j=0; j<COLS ; j++) {
				rowData.add(new DataOfSquare());
			}
			data.add(rowData);
		}
		
		/*
		 * Setting the gameScreen with the 2D ArrayList elements.
		 */
		for ( int i=0 ; i<ROWS ; i++) {
			for ( int j=0; j<COLS ; j++) {
				this.add(data.get(i).get(j));
			}
		}
	}
	
	/*
	 * Encapsulation to help TetrisGame to take the 
	 * tetrisController object.
	 */
	protected TetrisControl getTetrisControl() {
		return tetrisControl;
	}
	
	/*
	 * Encapsulation for data 2D ArrayList.
	 */
	protected ArrayList<ArrayList<DataOfSquare>> getData() {
		return data;
	}
	
}
