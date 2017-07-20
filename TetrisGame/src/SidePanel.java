import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * SidePanel class is responsible to show information
 * about the game like the score, next piece or controls.
 */
public class SidePanel extends JPanel {

	/*
	 * Serial version UID. 
	 */
	private static final long serialVersionUID = 5214506819372822801L;
	
	/*
	 * Following 4 variables are all the JLabels declarations for
	 * this panel.
	 */
	private static JLabel tetrisRemakeTextField;
	private static JLabel tetrisScoreTextField;
	private static JLabel tetrisNextTextField;
	private static JLabel tetrisHelpTextField;
	
	/*
	 * New JPanel for the next piece part.
	 */
	private JPanel nextPiecePanel;
	
	/*
	 * ArrayList that contains the information for 
	 * nextPiecePanel.
	 */
	private ArrayList<ArrayList<DataOfSquare>> data;
	
	/*
	 * Holds the score variable.
	 */
	private static int score;
	
	/*
	 * Holds the gameScreen's finishing point.
	 */
	private int x;
	
	/*
	 * Constructor for SidePanel class. Setting the 
	 * layout of the panels, background colors
	 * of them, setting the bound and etc.
	 */
	protected SidePanel(int x) {
		
		this.x = x;
		
		nextPiecePanel = new JPanel();
		nextPiecePanel.setLayout(new GridLayout(4, 4));
		nextPiecePanel.setBackground(Color.BLACK);
		nextPiecePanel.setBounds(x+70, 285, 150, 150);
		
		score = 0;
		
		setBackground(Color.BLACK);
		setLayout(null);
		setBounds(0, 0, 1000, 1000);
		
		settingTextFields();
		initializeNextPieceArea();
	}

	/*
	 * nextPiece's randomPiece variable is coming to this 
	 * method and this method creates the spesific 
	 * shape for that object and displays it.
	 */
	protected void settingNextPiece(int nextPiece) {
		clearNextPieceArea();
		switch(nextPiece) {
		/*  ------------
		 *  | 4  |	3  |
		 *  ------------
		 *  | 1  |	2  |
		 *  ------------
		 */
		case 1: 
			data.get(1).get(1).lightUp(Color.BLUE);
			data.get(1).get(2).lightUp(Color.BLUE);
			data.get(2).get(1).lightUp(Color.BLUE);
			data.get(2).get(2).lightUp(Color.BLUE);
			break;
		/*  ------------
		 *  | 4  |	3  |
		 *  ------------------
		 *  	 |  2  |  1  |
		 *  	 -------------
		 */
		case 2:
			data.get(1).get(0).lightUp(Color.PINK);
			data.get(1).get(1).lightUp(Color.PINK);
			data.get(2).get(1).lightUp(Color.PINK);
			data.get(2).get(2).lightUp(Color.PINK);
			break;
		/*  	  -------------
		 *  	  |  3  |  4  |
		 *  -------------------
		 *  |  1  |  2  |
		 *  -------------
		 */
		case 3:
			data.get(2).get(0).lightUp(Color.ORANGE);
			data.get(2).get(1).lightUp(Color.ORANGE);
			data.get(1).get(1).lightUp(Color.ORANGE);
			data.get(1).get(2).lightUp(Color.ORANGE);
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
			data.get(1).get(1).lightUp(Color.YELLOW);
			data.get(2).get(1).lightUp(Color.YELLOW);
			data.get(2).get(2).lightUp(Color.YELLOW);
			data.get(3).get(1).lightUp(Color.YELLOW);
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
			data.get(1).get(1).lightUp(Color.RED);
			data.get(2).get(1).lightUp(Color.RED);
			data.get(3).get(1).lightUp(Color.RED);
			data.get(3).get(2).lightUp(Color.RED);
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
			data.get(1).get(2).lightUp(Color.CYAN);
			data.get(2).get(2).lightUp(Color.CYAN);
			data.get(3).get(2).lightUp(Color.CYAN);
			data.get(3).get(1).lightUp(Color.CYAN);
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
			data.get(1).get(0).lightUp(Color.GREEN);
			data.get(1).get(1).lightUp(Color.GREEN);
			data.get(1).get(2).lightUp(Color.GREEN);
			data.get(1).get(3).lightUp(Color.GREEN);
			break;
		
		}
	}

	/*
	 * Setting the text fields.
	 */
	private void settingTextFields() {
		String tetrisRemakeHTMLCode = "<html><pre> Tetris<br>   Remake</pre></html>";
		tetrisRemakeTextField = new JLabel(tetrisRemakeHTMLCode);
		tetrisRemakeTextField.setFont(new Font("", Font.BOLD, 45));
		tetrisRemakeTextField.setForeground(Color.WHITE);
		tetrisRemakeTextField.setBounds(x, -25, 250, 250);
		add(tetrisRemakeTextField);
		
		tetrisScoreTextField = new JLabel("               Score: 0");
		tetrisScoreTextField.setFont(new Font("", Font.BOLD, 20));
		tetrisScoreTextField.setForeground(Color.WHITE);
		tetrisScoreTextField.setBounds(x, 100, 2000, 200);
		add(tetrisScoreTextField);
		
		String tetrisNextHTMLCode = "<html><pre>Next Piece:</pre></html>";
		tetrisNextTextField = new JLabel(tetrisNextHTMLCode);
		tetrisNextTextField.setFont(new Font("", Font.BOLD, 20));
		tetrisNextTextField.setForeground(Color.WHITE);
		tetrisNextTextField.setBounds(x, 175, 200, 200);
		add(tetrisNextTextField );
		
		String tetrisHelpHTML = "<html><body><pre>Controls:<br> Rotation: W / Up<br> Move Left: A / Left<br> Move Right: D / Right<br> Move Down: S / Down<br> Start: Enter<br> Pause: P</pre></body></html>";
		tetrisHelpTextField = new JLabel(tetrisHelpHTML);
		tetrisHelpTextField.setFont(new Font("", Font.BOLD, 20));
		tetrisHelpTextField.setForeground(Color.WHITE);
		tetrisHelpTextField.setBounds(x, 450, 300, 200);
		add(tetrisHelpTextField );
	}

	/*
	 * Initalizing the next piece area.
	 */
	private void initializeNextPieceArea() {
		data = new ArrayList<ArrayList<DataOfSquare>>();
		/*
		 * Declaring variables to each section of the 
		 * 2D ArrayList.
		 */
		for ( int i=0 ; i<4 ; i++) {
			ArrayList<DataOfSquare> rowData = new ArrayList<>();
			for ( int j=0; j<4 ; j++) {
				rowData.add(new DataOfSquare());
			}
			data.add(rowData);
		}
		
		/*
		 * Setting the gameScreen with the 2D ArrayList elements.
		 */
		for ( int i=0 ; i<4 ; i++) {
			for ( int j=0; j<4 ; j++) {
				nextPiecePanel.add(data.get(i).get(j));
			}
		}
		add(nextPiecePanel);
	}
	
	/*
	 * Cleans the nextPiece area.
	 */
	protected void clearNextPieceArea() {
		for ( int i=0 ; i<4 ; i++) {
			for ( int j=0; j<4 ; j++) {
				data.get(i).get(j).lightClose();
			}
		}
	}
	
	/*
	 * Creating some text views to show information 
	 * about the game.
	 */
	public static void addScore(int addScoreAmount) {
		score+=addScoreAmount;
		tetrisScoreTextField.setText("               Score: " + score);
	}
}
