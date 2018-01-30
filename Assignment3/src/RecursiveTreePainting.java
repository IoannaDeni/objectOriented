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
 * trunk as long as the users dragging movement and many branches. 
 * 
 * Code base borrowed from TreePainting Assignment 2
 * 
 * @param none
 * @Author Ioanna Deni
 * @Version 9/30/2017
 */

public class RecursiveTreePainting extends JComponent implements MouseListener{
	
	/** Number of generations to create branches. **/
	public static final int NUM_GENERATIONS = 8;
 
	/** Number of children for each branch. **/
	public static final int NUM_CHILDREN = 3;
 
	/** Diameter of the blossoms. **/
	public static final int BLOSSOM_DIAM = 10;
 
	/** Golden ratio makes the trunk length:branch length ratio aesthetically appealing **/
	public static final double GOLDEN_RATIO = 1.618;
	
	//Private variables holding the points of the mouse events
	private int xStart;
	private int yStart;
	private int xEnd;
	private int yEnd;
	
	//This boolean holds true when the use clicks
	private boolean clicked = false;
	

	public RecursiveTreePainting () {
		
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
		
		//This is to call the paint method and draw the tree trunk
		repaint();
	}
	
	/**
     * Method for drawing on this component. 
     * Overrides the paint method specified in JComponent (parent)
     * Paints the background in every click (and initially without user interaction)
     * Draws the tree trunk and calculates the angle between the tree trunk and the p
     * The point p is a set of coordinates of the end point of the tree trunk
     * Also the magnitude is also calculated between the starting coordinates and the end coordinates of the users interaction
     * The magnitude is the passed as parameters for branch length 
     * Then the branches are drawn and the boolean clicked is set to false to initiate the method again with another user interaction 
     * @param Graphics g
     */
    public void paint( Graphics g ){ 
    	
    	paintBackground(g );
    	   		
    	if (clicked) {
    		
        	paintTree (g, xStart, yStart, xEnd, yEnd);
    		Graphics2D g2 = (Graphics2D) g;
   	        double theta = Math.atan2(yEnd - yStart, xEnd - xStart);
   			Point2D p = new Point2D.Double(xEnd, yEnd);	
   			
   			//Here we calculate the length of the tree branches
   			double xDifference = xStart - xEnd;
   			double yDifference = yStart - yEnd;
   			double length = Math.sqrt(xDifference*xDifference + yDifference*yDifference);
   			
   			paintBranch(g2, NUM_GENERATIONS, theta-90, p, length);}
    		clicked = false;}
    
    /**
     * Method for drawing the tree branches attached to the top part of the tree trunk
     * based on the points of the users pressing and releasing the mouse. 
     * We set the color, transparency and thickness of the pen and draw triples of branches because we have set the children to triples,
     * the angle is changed by default by 120 degrees plus the number of the loop the branch is drawn on 
     * If it's the last generation of the branches then the paintFlower method is called and we add the flowers
     * else the generation number is decreased by 1, the angle is decreased by 90 degrees and the length is the 3/4 of the previous length
     * and the method is recalled.
     * @param Graphics g
     * @param int generation
     * @param double angle
     * @param Point2D point
     * @param double length
     */
    public void paintBranch( Graphics2D g2, int generation, double angle, Point2D point, double length){ 
    	    
    	for (int i=0; i<NUM_CHILDREN; i++){
    		
			g2.setColor(new Color(34,139,34)); 
    		g2.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f)); 
    		Point2D endPoint = computeEndpoint(point, (length/GOLDEN_RATIO), angle +i +120);
    		g2.drawLine((int)point.getX(), (int)point.getY(), (int)endPoint.getX(), (int)endPoint.getY());
    		
    		if (generation == 1){
    		paintFlowers(g2,  endPoint, length);}
    		
    		else {
    		paintBranch(g2, generation-1, (angle)-90, endPoint, (3*length)/5);}}}
    
    /**
     * Method for drawing the tree blossomed flowers attached to the top branches of the tree trunk
     * represented by little circles. 
     * We generate randomized values up to 255 to set each of the three values of colors.
     * Warm colors have a lot of red and not a lot of blue thus the values are adjusted.
     * This method draws only one flower when called alone thus each flower will be of different color
     * The parameter coordinates is the point that the flower is going to be drawn.
     * Lastly, the diameter of the flower is modified as to fit the length of the branches
     * the diameter is the set diameter number plus half the length of the branches divided by 10 
     * 
     * @param Graphics2D flower
     * @param int coordinates
     */
    public void paintFlowers( Graphics2D flower,  Point2D coordinates, double branchLength){ 
    	
		Random random = new Random();
        int red = random.nextInt(255);
        int green = random.nextInt(120);
        int blue = random.nextInt(50);
        
        flower.setColor(new Color(red, green, blue));
        flower.fillOval((int)coordinates.getX() - (BLOSSOM_DIAM+((int)branchLength/20))/2, (int)coordinates.getY() - (BLOSSOM_DIAM+((int)branchLength/20))/2, BLOSSOM_DIAM+((int)branchLength/20), BLOSSOM_DIAM+((int)branchLength/20));}
 
    
    /** 
	 * Method for painting the tree trunk on the screen by creating a filled thin line the assigned color 
     * based on the points of the users pressing and releasing the mouse. 
     * We set the color of the tree trunk to a preferred color, 
     * we transform the graphics to 2D to add the effect of the pen which are transparency and color
     * Lastly we draw the tree trunk as a line.
     * @param Graphics g
     * @param int startPointx
     * @param int startPointy
     * @param int endPointx
     * @param int endPointy 
	 */
    public void paintTree (Graphics tree, int x1, int y1, int x2, int y2) {
    	    	
		tree.setColor(new Color(34,139,34)); 
		
		Graphics2D g2 = (Graphics2D) tree;
		g2.setStroke(new BasicStroke(6.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f));
   	    
		g2.drawLine(x1, y1, x2, y2);}
    
    
    /** 
	 * Compute the point that is length away from point p at the specified angle.
	 * Uses cosine to get the new x coordinate, sine to get the new y coordinate.
	 * Given!
	 * @param Point2D p
	 * @param double branchLength
	 * @param double angle
	 */
	public Point2D computeEndpoint( Point2D p, double length, double angle ){
	    return new Point2D.Double( p.getX() + length*Math.cos(angle),
                		       p.getY() + length*Math.sin(angle));}
    
	
    /**
     * Method for painting the background of the screen by creating a filled rectangle 
     * based on the sizes that the canvas is given in class TreeApplication for SingleTreePanel
     * We set the color of the background to the preferred color in this case black
     * and draw the background by getting the width and height of the window.
     * @param Graphics g
     */
    protected void paintBackground( Graphics g ){
    	g.setColor(Color.black);
    	g.fillRect(0, 0, getWidth(), getHeight());}
	
    
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
