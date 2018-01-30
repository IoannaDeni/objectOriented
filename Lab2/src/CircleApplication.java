/** 
 * Draw circles on a screen
 *
 * @author Amy Tayloe
 * @version 2
 */

import javax.swing.*;

public class CircleApplication
{
	/**
	 * Sets the width of the frame to 800 pixels
	 */
    public static int FRAME_WIDTH = 800;
	
	/**
	 * Sets the height of the frame to 600 pixels
	 */
    public static int FRAME_HEIGHT = 600;

	/**
	 * Creates and draws the frame for the circles
	 * 
	 * @param args not used
	*/
    public static void main(String[] args)
    {
		JFrame circleFrame = new JFrame("Draw by clicking!");
		if (args.length > 0) {
			if (args[0].equals("circle")) {
				circleFrame.add(new CirclePanel(1));
			}
			else {
				circleFrame.add(new CirclePanel(0));
			}
		}
		else {
			circleFrame.add(new CirclePanel(0));
		}
		circleFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		circleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		circleFrame.setVisible(true);

    }
}