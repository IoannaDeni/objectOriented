import javax.swing.JFrame;

/** 
 * Main application for starting up the Tree Painting GUI.
 * 
 * Command line usage:
 * 
 * To create a single tree painting:
 *     java -cp bin TreeApplication
 *     
 * To create a collage of five seasons of tree paintings:
 *     java -cp bin TreeApplication seasons  
 *     	
 * @author Ioanna Deni
 * @version 9/30/2017
 * (Code borrowed from assignment 2)
 **/
public class TreeApplication
{
  	// Edit this line if you want to change the instruction text
	public static final String INSTRUCTIONS_TEXT = "Click, drag, and release to start painting!";
		
	/**
	 * Create a JFrame that holds the TreePaintings.
	 * 
	 **/
	public static void main( String[] args )
	{
		JFrame guiFrame;
			
		// create a new JFrame to hold a single TreePainting
		guiFrame = new JFrame( "A Single Recursive Tree Painting");
		
		// set size
		guiFrame.setSize( 400, 500 );

		// create a TreePanel and add it
		guiFrame.add( new SingleTreePanel(INSTRUCTIONS_TEXT) );
		

		// exit normally on closing the window
		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// show frame
		guiFrame.setVisible( true );
	}
}