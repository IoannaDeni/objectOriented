/** 
 * Draws circular objects on a screen
 *
 * @author Amy Tayloe
 * @version 2
 * @updated by Ioanna Deni at 10/17/2017
 * 
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;

public class CircleDisplay extends JComponent implements KeyListener
{
	//Starting circle
	private DrawableCircle circ;
	
	/**
	 * Constructor to draw circles
	 **/
	public CircleDisplay(int circType)
	{
		//add the key listener
		setFocusable(true);
		addKeyListener(this);
		
		int startX = 600;
		int startY = 400;
		int diameter = 50;
		//based on what's passed in, draw a bubble, target, or circle (default)
		switch (circType) {
			case 1:
				circ = new DrawableBubble(startX, startY, diameter, Color.black, Color.gray);
				break;
			case 2:
				circ = new DrawableTarget(startX, startY, diameter, Color.blue, Color.lightGray);
				break;
			default:
				circ = new DrawableCircle(startX, startY, diameter, Color.green);
				break;
		}
	};
	
	/**
	 * Draws circles using the paint method
	 * 
	 * @param g graphics object to draw on
	 **/
	public void paint(Graphics g)
	{
		circ.draw(g);
	}

	/**
	 * Do something when a key is pressed
	 * @param e the key that is pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
	}

	/**
	 * Move the circle when a key is released
	 * @param e the key that is released
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyCode());
		//"KeyCode" is the enum of the key that was pressed
		//Check the KeyEvent documentation for more
		int key = e.getKeyCode();
			
	    if (key == KeyEvent.VK_UP) {
	    	
	    	//This is to check that the new move is not out of the bounds 
	    	if (circ.getY()<10){
	    		
	    		//In the case that the component is going to be out of boundaries then we set the y value as zero so it stands at the top of the screen  
	    		circ.setY(0);
	    	}
	    	else{
	        circ.setY(circ.getY()-10);}
	    }

	    else if (key == KeyEvent.VK_DOWN) {
	    	
	    	//This is to check that the new move is not out of the bounds
	    	if (circ.getY()>getHeight()-circ.getDiam()-10){
	    		
	    		//In the case that the component is going to be out of boundaries then we set the y value as the Height of the screen minus 
	    		//the diameter so it stands at the bottom of the screen
	    		circ.setY(getHeight()-circ.getDiam());
	    	}
	    	else{
	    		circ.setY(circ.getY()+10);
	    	}
	    }
	    
	    else if (key == KeyEvent.VK_LEFT){
	    	
	    	//This is to check that the new move is not out of the bounds
	    	if (circ.getX()<10){
	    		
	    		//In the case that the component is going to be out of boundaries then we set the x value as zero
	    		circ.setX(0);
	    	}
	    	
	    	else{
	    	circ.setX(circ.getX()-10);}
	    }
	    
	    else if (key == KeyEvent.VK_RIGHT){
	    	
	    	//This is to check that the new move is not out of the bounds
	    	if (circ.getX()>getWidth()-10-circ.getDiam()){
	    		
	    		//In the case that the component is going to be out of boundaries then we set the x value as the width minus the diameter of the circle
	    		circ.setX(getWidth()-circ.getDiam());
	    	}
	    	else{
	    	circ.setX(circ.getX()+10);}
	    }
	    
	    else if (key == KeyEvent.VK_SPACE){
	    	circ.setY(getHeight()-circ.getDiam());
	    }
	    repaint();
	}

	/**
	 * Do something when a key is pressed and released
	 * @param e the key that is pressed and released
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
}