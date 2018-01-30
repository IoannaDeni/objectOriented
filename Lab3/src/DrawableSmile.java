/** 
* Class for drawabling smily faces
* Extends DrawableCircle
*
* @author Ioanna Deni
* @version 9/19/2017
* 
* borrowed code from the DrawableBubble class
*/

import java.awt.Color;
import java.awt.Graphics;


public class DrawableSmile extends DrawableCircle {
	
	// The colors of the face and the smile and eyes that are passed as parameters from the constructor are saved here to be used in methods later
	private Color backgroundColor;
	private Color mouthColor;
	
	//This global variables hold the upper left x, upper left y, and diameter of the circles passed as parameters to the constructor
	private int x;
	private int y;
	private int diam;
	
	/**
	 * Construct a new drawable bubble
	 * 
	 * @param newX starting x value
	 * @param newY starting y value
	 * @param newDiam starting diameter
	 * @param newColor base color of the bubble
	 * @param newSmileColor color of mouth and eyes
	 **/
	
	public DrawableSmile(int newX, int newY, int newDiam, Color newColor, Color newSmileColor) {
		super(newX, newY, newDiam, newColor);
		
		//Here we passe to the variables the values that come from the constructor
		backgroundColor = newColor;
		x = newX;
		y = newY;
		diam = newDiam;
		mouthColor = newSmileColor;
		
		}
	/**
	 * Draws a face with a mouth on the screen
	 * 
	 * @param g graphics object to draw on
	 **/

	public void draw(Graphics g) {
		//draw the base circle
		super.draw(g);
			
		//Set the color of the background
		g.setColor(backgroundColor);
		
		//Set the color of the background
		g.setColor(mouthColor);
		
		//Draw the eyes on top of the face two 
		g.fillOval(x + 10, y + 10, diam/5, diam/5);
		g.fillOval(x + 10 +20, y + 10, diam/5, diam/5);
		
		//Draw the rectangle for the mouth
		g.fillRoundRect(x + 10, y + 30, diam - 20, diam/4, diam, diam/5);
		
		g.setColor(Color.red);
		g.fillOval(x + diam/2 -5, y + diam/2 + 10, diam/5, diam/5);
			}
	 	}
