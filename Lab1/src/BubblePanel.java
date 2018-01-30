/* BubblePanel
Creates a panel to draw bubbles in
Date: 9/1/16
Author: Amy Tayloe
Modified: 
 */
 
import java.awt.*;
import javax.swing.*;

public class BubblePanel extends JPanel 
{
	//Global variable of the display
	private BubbleDisplay bubbleDisplay;
	
	/**
	 * Constructor, to create a new panel
	 **/
	public BubblePanel()
	{
		// Set the layout to be border-style
		super( new BorderLayout());
		// Create panel defaults
		initPanel();
	}
	
	/** 
	 * Create GUI components.
	 **/
	public void initPanel()
	{		
		// Display the bubbles in the center of the panel
		this.add(  createBubbleDisplay(), BorderLayout.CENTER );
	}
	
	/**
	 * Create and return the bubble display.
	 **/
	public BubbleDisplay createBubbleDisplay()
	{	
		bubbleDisplay = new BubbleDisplay();
		return bubbleDisplay;
	}
	
}