/* BubbleDisplay

Draws some bubbles
Date: 9/1/16
Author: Amy Tayloe
Modified: 9/12/2017 by Ioanna Deni
 */
 
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BubbleDisplay extends JComponent
{
	//Global constants
	//public static Color COLOR_BUBBLE = new Color(120, 160, 200);
	public static Color COLOR_OUTLINE = Color.BLACK;
	public static Color COLOR_HIGHLIGHT = Color.WHITE;
	public static int DIAM_BUBBLE = 50;
	
	/**
	 * Constructor to draw bubbles
	 **/
	public BubbleDisplay()
	{
		// Call the superclass' constructor
		super();
	}
	
	/**
	 * Override the paint method to draw bubbles
	 **/
	public void paint( Graphics g )
	{
		//Start with the x and y values of the upper left corner of the bubble
		int x = 0;
		int y = 0;
		//Draw ten bubbles in a row
		for (int i = 0; i < 16; i++) {
			Color color = new Color(120+(i*5), 160, 200);
			drawBubble(g, (DIAM_BUBBLE*i)+x, y, color);
			for (int a=0; a<10; a++) {
				Color newColor = new Color(120+(i*5), 160+(a*8), 200);
				drawBubble(g, (DIAM_BUBBLE*i)+x, y+(DIAM_BUBBLE*a), newColor);
			}
		}
	}
	
	/**
	 * Draw a single bubble
	 **/
	public void drawBubble(Graphics g, int x, int y, Color newColor)
	{
		// Set the color of the inside of the bubble
		g.setColor(newColor);
		
		// Draw the inside of the bubble (upper left x, upper left y, width, height)
		g.fillOval(x, y, DIAM_BUBBLE, DIAM_BUBBLE);
		
		//Set the color of the outside of the bubble
		g.setColor(COLOR_OUTLINE);
		
		//Draw the outline of the bubble 
		g.drawOval(x, y, DIAM_BUBBLE, DIAM_BUBBLE);
		
		//Set the color of a highlight
		g.setColor(COLOR_HIGHLIGHT);
		
		//Draw the highlight as a rounded rectangle (upper left x, upper left y, width, hight, arc width, arc height)
		g.fillRoundRect(x+(DIAM_BUBBLE*3/5), y+(DIAM_BUBBLE/5), 10, 10, 5, 5);
	}
	
}