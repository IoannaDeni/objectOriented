/** 
 * Creates a panel to draw circles in
 *
 * @author Amy Tayloe
 * @version 2
 */
 
import java.awt.*;
import javax.swing.*;

public class CirclePanel extends JPanel 
{
	//Global variable of the display
	private CircleDisplay circleDisplay;
	
	/**
	 * Constructor, to create a new panel
	 * 
	 * @param circType the type of circle to draw
	 **/
	public CirclePanel(int circType)
	{
		// Set the layout to be border-style
		super(new BorderLayout());
		// Create panel defaults
		initPanel(circType);
	}
	
	/** 
	 * Create GUI components.
	 * 
	 * @param circType the type of circle to draw
	 **/
	public void initPanel(int circType)
	{		
		// Display the circles in the center of the panel
		this.add(createCircleDisplay(circType), BorderLayout.CENTER);
	}
	
	/**
	 * Create and return the circle display.
	 * 
	 * @param circType the type of circle to draw
	 * @return the display to draw the bubbles in
	 **/
	public CircleDisplay createCircleDisplay(int circType)
	{	
		circleDisplay = new CircleDisplay(circType);
		return circleDisplay;
	}
	
}