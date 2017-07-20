import java.awt.Color;
import javax.swing.JFrame;

/*
 * This game was created by Ekrem ERAKIN and for more 
 * information, feel free to visit my blog  
 * www.ekremerakin.wordpress.com
 *
 * This class is the main class. It creates the main frame
 * and also, it creates some JPanels and all that JPanels 
 * do the job that they responsible for.
 */
public class TetrisGame extends JFrame {

	/*
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -5654363616713726542L;

	/*
	 * To run the game(gameLoop), TetrisControl variable 
	 * created.
	 */
	private TetrisControl tetrisControl; 
	
	/*
	 * GameScreen object.
	 */
	private GameScreen gameScreen;
	
	/*
	 * SidePanel object.
	 */
	private SidePanel sidePanel;
	
	/*
	 * The number of screen width.
	 */
	private static int screenWidth;
	
	/*
	 * The number of game screen width.
	 */
	private static int gameScreenWidth;
	
	/*
	 * The number of game screen height.
	 */
	private static int gameScreenHeight;
	
	/*
	 * Default constructor to initialize the JFrame's title and 
	 * initialize the .
	 */
	protected TetrisGame() {
		super("Tetris Remake");
		initialize();
	}
	
	/*
	 * This method created to initialize all the components 
	 * of the main frame.
	 */
	private void initialize() {
		screenWidth = 700;
		
		settingUpTheGameScreen();
		settingUpTheSidePanel();
		
		tetrisControl = new TetrisControl(gameScreen, this);
		
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, screenWidth, gameScreenHeight+28);
		addKeyListener(new KeyListener(tetrisControl));
		setLayout(null);
		setVisible(true);
		setResizable(false);
		
		add(sidePanel);
		tetrisControl.start();
	}

	/*
	 * Creating GameScreen's width and height and sending
	 * that variables to the GameScreen's constructor.
	 */
	private void settingUpTheGameScreen() {
		gameScreenWidth = (screenWidth*3)/5;
		gameScreenHeight = (gameScreenWidth/10)*16;
		gameScreen = new GameScreen(gameScreenWidth, gameScreenHeight, this);
		add(gameScreen);
	}
	
	/*
	 * Setting up a new side panel with location of it.
	 */
	private void settingUpTheSidePanel() {
		sidePanel = new SidePanel(gameScreenWidth);
	}

	/*
	 * Encapsulated variables.
	 */
	protected TetrisGame getTetrisGame() {
		return this;
	}
	
	protected TetrisControl getTetrisControl() {
		return tetrisControl;
	}
	
	protected SidePanel getSidePanel() {
		return sidePanel;
	}
	
	protected void setGameScreen(GameScreen gameScreen) {
		settingUpTheGameScreen();
	}
	
	/*
	 * Main method creates a TetrisGame object and that object 
	 * responsible for creating the window.
	 */
	public static void main(String[] args) {
		new TetrisGame();
	}

}