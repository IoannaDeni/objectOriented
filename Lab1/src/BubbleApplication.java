/* BubbleApplication

Creates a screen to draw bubbles on
Date: 9/1/16
Author: Amy Tayloe
Modified:
*/

import javax.swing.*;

public class BubbleApplication
{
	//Global constants
    public static int FRAME_WIDTH = 800;
    public static int FRAME_HEIGHT = 400;

    public static void main(String[] args)
    {
	//Creates and draws the frame, adding in a Bubble Panel
    	
	JFrame bubbleFrame = new JFrame("Bubbles!");
	bubbleFrame.add(new BubblePanel());
	bubbleFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	bubbleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	bubbleFrame.setVisible(true);

    }
}