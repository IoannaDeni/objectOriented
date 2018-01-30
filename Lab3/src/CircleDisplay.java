/** 
 * Draws circular objects on a screen
 *
 * @author Amy Tayloe
 * @version 2
 * 
 * updated by @author Ioanna Deni
 * @version 9/26/2017
 */
import java.util.LinkedList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

public class CircleDisplay extends JComponent implements MouseListener
{
	//Holds the list of circles to draw
	private LinkedList<DrawableCircle> CircleList;
	//Holds the type of circle to draw
	private int cType;
	//Default circle color - which was set to pink because it was not given a value before
	Color circColor = Color.pink;
	
	/**
	 * Constructor to draw circles
	 * 
	 * @param circType the type of circle to draw
	 **/
	public CircleDisplay(int circType)
	{
		// have this be a mouse listener for its own mouse events
		addMouseListener(this);
		CircleList = new LinkedList<DrawableCircle>();
		cType = circType;
	}
	
	/**
	 * Draws circles using the paint method
	 * 
	 * @param g graphics object to draw on
	 **/
	public void paint(Graphics g)
	{
		for (DrawableCircle circ : CircleList) {
			circ.draw(g);
		}
	}
	
	/**
	 * Invoked when the mouse is pressed down. Adds a circle at the current location.
	 * 
	 * @param e the current state of the mouse
	 */
	public void mousePressed(MouseEvent e)
	{
		DrawableCircle newCirc;

		if (cType == 1) {
			
			//modified this so that it doesn't draw circles anymore but it draws faces
			//newCirc = new DrawableCircle(e.getX(), e.getY(), 50, circColor);
			newCirc = new DrawableSmile(e.getX(), e.getY(), 50, Color.yellow, Color.black);
		}
		
		else if (cType == 2) {
			//added another if statement to hold the drawableTarget constructor when parameter of the application is set to "target"
			newCirc = new DrawableTarget(e.getX(), e.getY(), 50, Color.red, Color.pink);
		}
		
		else {
			newCirc = new DrawableBubble(e.getX(), e.getY(), 50, new Color(120, 160, 200), Color.white);
		}
		
		//This line was creating a list every time so by removing it the faces are all added onto the same list and thus are all drawn on the screen
		//CircleList = new LinkedList<DrawableCircle>();
		CircleList.add(newCirc);
		repaint();
    }
    
	/**
	 * Invoked when the mouse is released.
	 * 
	 * @param e the current state of the mouse
	 */
	public void mouseReleased(MouseEvent e){}
	
	/**
	 * Invoked when the mouse enters the component.
	 * 
	 * @param e the current state of the mouse
	 */
	public void mouseEntered(MouseEvent e){}

	/**
	 * Invoked when the mouse leaves the component.
	 * 
	 * @param e the current state of the mouse
	 */
	public void mouseExited(MouseEvent e){}

	/**
	 * Invoked when the mouse is clicked (pressed down and released).
	 * 
	 * @param e the current state of the mouse
	 */
	public void mouseClicked(MouseEvent e){}
	
}