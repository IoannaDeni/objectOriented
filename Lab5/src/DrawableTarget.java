/** 
 * Class for drawabling targets
 * Extends DrawableCircle
 *
 * @author Amy Tayloe
 * @version 2
 */
import java.awt.Color;
import java.awt.Graphics;
 
public class DrawableTarget extends DrawableCircle {
	//alternating color for rings
	private Color altColor;
	
	/**
	 * Construct a new drawable target
	 * 
	 * @param newX starting x value
	 * @param newY starting y value
	 * @param newDiam starting diameter
	 * @param newColor base color of the target
	 * @param newAltColor color of the alternating rings
	 **/
	public DrawableTarget(int newX, int newY, int newDiam, Color newColor, Color newAltColor) {
		super(newX, newY, newDiam, newColor);
		altColor = newAltColor;
	}
		
	/**
	 * Gets the alternate color
	 * 
	 * @return current alternate color
	 **/
	public Color getAltColor() {
		return altColor;
	}
		
	/**
	 * Sets alternate color to a new color
	 * 
	 * @param newAltColor new alt color
	 **/
	public void setAltColor(Color newAltColor) {
		altColor = newAltColor;
	}
	
	/**
	 * Draws the target on the screen
	 * 
	 * @param g graphics object to draw on
	 **/
	public void draw(Graphics g) {
		//draws the base ring
		//super.draw(g);
		//starts the recursion
		drawConcentric(g, super.getX(), super.getY(), getDiam(), getAltColor());
	}

	/** 
	  * Draws a series of smaller rings
	  * Adds subsequent rings if there is still space for them
	  * Target is always a perfect circle
	  * 
	  * @param g the Graphics object to draw the target on
	  * @param x leftmost point of the ring
	  * @param y uppermost point of the ring
	  * @param diam the diameter of the current ring
	  * @param alt if true, use the alternate color instead of the fill color for this ring
	  */
	public void drawConcentric(Graphics g, int x, int y, int diam, Color col) {
		g.setColor(col);
		g.fillOval(x, y, diam, diam);
		if (diam - 8 > 0) { //again, if diam is greater than 0, keep drawing circles
			drawConcentric(g, x + 4, y + 4, diam - 8, col.darker());
		}
 	}
 }