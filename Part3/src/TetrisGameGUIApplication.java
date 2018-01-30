/** 
 * Draw the platform for the game on the screen.
 * Code borrowed from lab 5
 *
 * @author Ioanna Deni
 * @version 10/23/2017
 */

import javax.swing.*;

public class TetrisGameGUIApplication
{
	/**
	 * Sets the width of the frame
	 */
    public static int FRAME_WIDTH = 420;
	
	/**
	 * Sets the height of the frame
	 */
    public static int FRAME_HEIGHT = 740;

	/**
	 * Creates and draws the frame for the game
	 * 
	 * @param args not used
	*/
    public static void main(String[] args)
    {
		JFrame frame = new JFrame("TETRIS: THE ONE AND ONLY");
		
		//Calls the controller of the game so it can be initialized
		TetrisGameGUIController controller = new TetrisGameGUIController();
		
		//The size of the screen in set
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		//The game operations are terminated when the window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//The controller is added to the frame so it can become visible
		frame.add(controller);
		
		//This method initializes the paint graphics method
		frame.setVisible(true);

    }
}
