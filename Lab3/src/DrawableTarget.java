/** 
* Class for drawing circles one on top of the other in the form of targets
* It accepts a x, y coordinate as defined in the drawableCircle class and a diameter and two colors
* It's function is two draw smaller circles of the alternative color pair passed as parameters till it has a small circle in the middle 
* Extends DrawableCircle
*
* @author Ioanna Deni
* @version 9/26/2017
* 
* borrowed code from the DrawableSmile class
*/

import java.awt.Color;
import java.awt.Graphics;

public class DrawableTarget extends DrawableCircle {
	
	// The colors of the big and small circle that are passed as parameters from the constructor are saved here to be used in methods later
	private Color backgroundColor;
	private Color innerColor;
	
	//This global variables hold the upper left x, upper left y, and diameter of the circles passed as parameters to the constructor
	private int x;
	private int y;
	private int diam;
	
	/**
	 * Construct a new drawable target
	 * 
	 * @param newX starting x value
	 * @param newY starting y value
	 * @param newDiam starting diameter
	 * @param newColor base color of the circle
	 * @param innerColor color of smaller circle
	 **/
	
	public DrawableTarget(int newX, int newY, int newDiam, Color newColor, Color newInnerColor) {
		super(newX, newY, newDiam, newColor);
		
		//Here we passe to the variables the values that come from the constructor
		backgroundColor = newColor;
		x = newX;
		y = newY;
		diam = newDiam;
		innerColor = newInnerColor;
		
		}
	/**
	 * Draws a the first circle and calls the drawRing methods that draws a complete target of alternative colors
	 * 
	 * @param g graphics object to draw on
	 **/

	public void draw(Graphics g) {
		//draw the base circle
		super.draw(g);
			
		//Set the color of the background
		g.setColor(backgroundColor);
		
		//here we call the recursive method defined below
		drawRing(g, x, y, diam, true);
		
		//These commented lines of code that follow are for the first part of the lab that just draws two circles
		
		//Set the color of the smaller circle
		//g.setColor(innerColor);
		
		//Draw the smaller circle 
		//g.fillOval(x + diam/2 - 4*(diam/10), y + diam/2 - 4*(diam/10), 4*(diam/5), 4*(diam/5));
			}
	
	/**
	 * Draws circles all with diameter smaller by 10 units and of 
	 * alternative color till the diameter is smaller than zero 
	 * 
	 * @param g graphics object 
	 * @param int x 
	 * @param int y 
	 * @param int diameter
	 * @param boolean type 
	 *  
	 **/
	public void drawRing(Graphics g, int x, int y, int diameter, boolean type) {
		
		//We hold these newly established variables here because every time the method is 
		//drawn for every complete target that we draw
		boolean newtype;
		int newDiameter;
		
		if (type == true){    
			
			//Set the color of the object g
			g.setColor(innerColor);
			
			//change the type for alternative color in next recursion
			newtype = false;
		}
		else {
			
			//Set the color of the object g
			g.setColor(backgroundColor);
			
			//change the type for alternative color in next recursion
			newtype = true;
		}
		
		//Draw the smaller circle 
		g.fillOval(x + diameter/2 - (diameter-10)/2, y + diameter/2 - (diameter-10)/2, diameter-10, diameter-10); 
		
		//set the new variables for next circle
		newDiameter = diameter-10;
		x = x + diameter/2 - (diameter-10)/2;
		y = y + + diameter/2 - (diameter-10)/2;
		
		//if the diameter of the next circle is bigger than zero then call the drawRing method again
		if (newDiameter > 0){
			drawRing(g, x, y, newDiameter, newtype);
		}
		
	}
	
}
