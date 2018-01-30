import java.awt.Color;
import java.awt.Graphics;

public class FallTreePainting extends TreePainting{
	/**
	 * This class is an interactive class that draws a flowered tree in winter season by inheriting 
	 * methods from the treePainting class and just changing the background color to white.
	 * @Author Ioanna Deni
	 * @Version 9/24/2017
	 * @param none
	 */
	
		protected void paintBackground( Graphics g )
	    {
			//This variable is to make the sky 
			int FallGround = 50;
			
			//Set the color of the sky
	    	g.setColor(new Color(199, 187, 133));
					
	    	
	    	//Draw the background by getting the width and height of the window
	    	g.fillRect(0, 0, getWidth(), getHeight()-FallGround);
	    	
	    	
	    	//Set the color of the ground
	    	g.setColor(new Color(142, 189, 153));			
	    	
	    	
	    	//Draw the background by getting the width and height of the window
	    	g.fillRect(0, getHeight()-FallGround, getWidth(), getHeight());

	    }
		

}

