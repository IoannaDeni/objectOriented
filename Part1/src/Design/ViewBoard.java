package Design;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Prints a board grid of specified length and width and the symbols of each piece on the board and updates the board in every unit of time
 * or when the user gives a new key input.
 * This class is also responsible for showing the instruction text (JLabel) and the layouts (BorderLayouts) 
 * 
 * @author Ioanna Deni
 * @version 10/10/2017
 *
 */

public class ViewBoard {
	
	// displays the titles
	private JLabel instructions;
	
	// displays the grid that will be our board 
	private JPanel board;
	
	//holds the information for the constructed piece
	private GameLogic piece;
	
	/** 
	 * Constructor uses a border layout. The GUI is set up by
	 * putting a JLabel with instructions in the NORTH region, 
	 * and a new board object in the CENTER region.
	 **/
	public ViewBoard(){
		
	}
	
	/**
	 * Print the board to the console
	 */
	public void printBoard(){
		
	}

}
