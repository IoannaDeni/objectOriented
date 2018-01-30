/** 
 * Class for drawabling bubbles
 * Extends DrawableCircle
 *
 * @author Amy Tayloe
 * @version 2
 */
import java.awt.Color;
import java.awt.Graphics;
 
public class DrawableBubble extends DrawableCircle {
	//color of the highlight on the ring
	 private Color highlightColor;
	 
	/**
	 * Construct a new drawable bubble
	 * 
	 * @param newX starting x value
	 * @param newY starting y value
	 * @param newDiam starting diameter
	 * @param newColor base color of the target
	 * @param newHighlight color of highlight
	 **/
	 public DrawableBubble(int newX, int newY, int newDiam, Color newColor, Color newHighlight) {
		super(newX, newY, newDiam, newColor);
		highlightColor = newHighlight;
	}
	
	/**
	 * Draws the bubble on the screen
	 * 
	 * @param g graphics object to draw on
	 **/
	public void draw(Graphics g) {
		//draw the base circle
		super.draw(g);
		
		//Set the color of the highlight
		g.setColor(highlightColor);
		
		//Draw the highlight
		g.fillRoundRect(getX()+(getDiam()*3/5), getY()+(getDiam()/5), getDiam()/5, getDiam()/5, getDiam()/10, getDiam()/10);
	}
 }