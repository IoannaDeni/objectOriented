/** 
 * Parent class for drawable circular objects
 *
 * @author Amy Tayloe
 * @version 2
 */
import java.awt.Color;
import java.awt.Graphics;
 
public class DrawableCircle {
	
	//Private variables holding default starting values
	private int x;
	private int y;
	private int diam;
	private Color fillColor;
	 
	/**
	 * Construct a new drawable circld
	 * 
	 * @param newX starting x value
	 * @param newY starting y value
	 * @param newDiam starting diameter
	 * @param newColor base color of the target
	 **/
	public DrawableCircle(int newX, int newY, int newDiam, Color newColor) {
		x = newX - (newDiam/2);
		y = newY - (newDiam/2);
		diam = newDiam;
		fillColor = newColor;
	}
	
	/**
	 * Gets the current value of x
	 * 
	 * @return current value of x
	 **/
	public int getX() {
		return x;
	}
		
	/**
	 * Sets x to a new value
	 * 
	 * @param newX new x value
	 **/
	public void setX(int newX) {
		x = newX;
	}
		
	/**
	 * Gets the current value of y
	 * 
	 * @return current value of y
	 **/
	public int getY() {
		return y;
	}
		
	/**
	 * Sets y to a new value
	 * 
	 * @param newY new y value
	 **/
	public void setY(int newY) {
		y = newY;
	}
		
	/**
	 * Gets the current diameter
	 * 
	 * @return current diameter
	 **/
	public int getDiam() {
		return diam;
	}
		
	/**
	 * Sets the diameter to a new value
	 * 
	 * @param newDiam new diameter
	 **/
	public void setDiam(int newDiam) {
		diam = newDiam;
	}
		
	/**
	 * Gets the current fill color
	 * 
	 * @return current fill color
	 **/
	public Color getFillColor() {
		return fillColor;
	}
		
	/**
	 * Sets fill color to a new color
	 * 
	 * @param newFillColor new fill color
	 **/
	public void setFillColor(Color newFillColor) {
		fillColor = newFillColor;
	}
	
	/**
	 * Draw a single circle
	 * 
	 * @param g the graphics object to draw on
	 **/
	public void draw(Graphics g)
	{
		// Set the color of the inside of the circle
		g.setColor(fillColor);
		
		// Draw the inside of the circle (upper left x, upper left y, width, height)
		g.fillOval(x, y, diam, diam);
		
		//Set the color of the outside of the circle
		g.setColor(fillColor.darker());
		
		//Draw the outline of the circle 
		g.drawOval(x, y, diam, diam);
	}
	 
 }