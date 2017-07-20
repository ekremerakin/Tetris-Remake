import java.awt.Color;
import javax.swing.JPanel;

/*
 * This method fills all the parts of the grid layout
 * with JPanels. That help us to use the each individual
 * part of the grid layout as a display.
 */
public class DataOfSquare extends JPanel{
	
	/*
	 * Serial version UID. 
	 */
	private static final long serialVersionUID = -6085068757465692902L;
	
	/*
	 * Setting the default color.
	 */
	private Color color = Color.BLACK;
	
	/*
	 * Default constructor for an empty block.
	 */
	protected DataOfSquare() {
		setEmptyColor();
	}
	
	/*
	 * Setting the default color(Black) value for 
	 * empty blocks.
	 */
	private void setEmptyColor() {
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		this.repaint();
	}
	
	/*
	 * Following 2 method were written to
	 * change the color of whatever part
	 * of the grid layout we want. 
	 */
	protected void lightUp(Color color) {
		this.color = color;
		setBackground(color);
	}
	
	/*
	 * Setting a blocks background color to black.
	 */
	protected void lightClose() {
		this.color = Color.BLACK;
		setBackground(color);
	}
	
	/*
	 * Setting a blocks background color to whatever the 
	 * program wants.
	 */
	protected Color getColor() {
		return color;
	}
}
