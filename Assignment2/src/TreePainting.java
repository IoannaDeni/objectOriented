import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * This class is an interactive class that draws a flowered tree with a tree 
 * trunk as long as the users dragging movement.
 * 
 * @param none
 * @Author Ioanna Deni
 * @Version 9/24/2017
 */

public class TreePainting extends JComponent implements MouseListener{
	
	/** Number of branches **/
	public static final int NUM_BRANCHES = 8; 
 
	/** Diameter of the blossoms. **/
	public static final int BLOSSOM_DIAM = 25;
 
	/** Golden ratio makes the trunk length:branch length ratio aesthetically appealing **/
	public static final double GOLDEN_RATIO = 1.618;
	
	//Private variables holding the points of the mouse events
	private int xStart;
	private int yStart;
	private int xEnd;
	private int yEnd;
	
	//Here are the colors used for the background and the tree
	private Color backGround = Color.black;
	private Color treeTrunk = new Color(34,139,34);
	
	//This boolean holds true when the use clicks
	private boolean clicked = false;
	
	//This is the length of the branches based on the length of the tree drawn by the user
	private double length;
	
	public TreePainting () {
		
		// have this be a mouse listener for its own mouse events
		addMouseListener(this);
		
		}
    
	/**
	 * Invoked when the mouse is pressed down. The coordinates of the point are recored.
	 * 
	 * @param e the current state of the mouse
	 */
	public void mousePressed(MouseEvent e){
		
		xStart = e.getX();
		yStart = e.getY();     
	}
    
	/**
	 * Invoked when the mouse is released. The coordinates of the point are recored.
	 * 
	 * @param e the current state of the mouse
	 */
	public void mouseReleased(MouseEvent e){
		
		xEnd = e.getX();
		yEnd = e.getY();
		
		//Sets the clicked value true so the tree can be drawn in the method called
		clicked = true;
		
		//Here we calculate the length of the tree branches based on the users choice of length of the tree trunk
		double xDifference = xStart - xEnd;
		double yDifference = yStart - yEnd;
		length = Math.sqrt(xDifference*xDifference + yDifference*yDifference);
		
		//This is to call the paint method and draw the tree trunk
		repaint();
	}
	
	/**
     * Method for drawing on this component. 
     * Overrides the paint method specified in JComponent (parent)
     */
    public void paint( Graphics g )
{ 	
    	// paint the background
    	paintBackground( g );
    	
	
        // if user has pressed and released mouse, paint tree
    	if (clicked == true) {
    		   		
    		//Set the color of the tree trunk
    		g.setColor(treeTrunk);
    		
    		//Here we transform the graphics to 2D to add the effect of the pen 
    		Graphics2D g2 = (Graphics2D) g;
    	   	
    		//Use a pen with the defined transparency and color
    		g2.setStroke(new BasicStroke(10.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f));
       	      
    		//Draw the tree trunk
    		g2.drawLine(xStart, yStart, xEnd, yEnd);
    		
    		//We draw the 12 branches as lines starting from the end point and the number is choosen so the tree looks nice
    		for (int i=1; i<13; i++){
    			
    			//Set the color of the tree trunk
        		g2.setColor(treeTrunk);
        		
        	   	
        		//Use a pen with the defined transparency and color
        		g2.setStroke(new BasicStroke(10.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f));
           	     
    			
    			//Here we set the p we have as a set of coordinates of the end point of the tree trunk 
    			Point2D p = new Point2D.Double(xEnd, yEnd);
    			
    			//Here we generate a random number for our angle
    			Random random = new Random();
    			
    			// Generate random integers in range 0 to 180
    	        int randNumber = random.nextInt(181);
    	        
    	        //To constrain the branch angles based on the trunk angle
    	        double theta = Math.atan2(yEnd - yStart, xEnd - xStart);
    			
    			//This value calls the methods that does (weird) math and calculates the end point of the branches
    			Point2D endPoint = computeEndpoint( p, length/GOLDEN_RATIO, theta + 90 + i);
    			
    			//Here we draw the 8 branches  			
    			g2.drawLine(xEnd, yEnd, (int)endPoint.getX(), (int)endPoint.getY());
    			
    			// Set the color of the flower to a random value from 245 to 255 (the brigth standard red)
    			g2.setColor(new Color(75+randNumber, 0, 0));
    			
    			// Draw the inside of the circle (upper left x, upper left y, width, height)
    			g2.fillOval((int)endPoint.getX() - (BLOSSOM_DIAM+((int)length/20))/2, (int)endPoint.getY() - (BLOSSOM_DIAM+((int)length/20))/2, BLOSSOM_DIAM+((int)length/20), BLOSSOM_DIAM+((int)length/20));
    		}
    		
    		//Set it again false so we can redraw
    		clicked = false;
       	}
}
    
    /** 
	 * Compute the point that is length away from point p at the specified angle.
	 * Uses cosine to get the new x coordinate, sine to get the new y coordinate.
	 */
	public Point2D computeEndpoint( Point2D p, double length, double angle )
	{
	    return new Point2D.Double( p.getX() + length*Math.cos(angle), // x is cos
                		       p.getY() + length*Math.sin(angle)); // y is sin
	}
    
    /**
     * Method for painting the background of the screen by creating a filled rectangle 
     * based on the sizes that the canvas is given in class TreeApplication for SingleTreePanel
     */
    protected void paintBackground( Graphics g )
    {
    	//Set the color of the background
    	g.setColor(backGround);
    	
    	//Draw the background by getting the width and height of the window
    	g.fillRect(0, 0, getWidth(), getHeight());	
    }
	
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