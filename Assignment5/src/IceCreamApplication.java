import javax.swing.JFrame;

/** 
 * Main application for starting up the Ice Cream Shop GUI.
 *     	
 * @author Ioanna Deni
 * @version 11/4/2017
 * (Code borrowed from assignment 3)
 * 
 **/
public class IceCreamApplication {		
	
	/**
	 * Create a JFrame that holds the panels.
	 * 
	 **/
	
	public static void main( String[] args )
	{
		JFrame guiFrame;
			
		// create a new JFrame to hold a single canvas for the ice cream
		guiFrame = new JFrame( "The Ice Cream Shop: Swift and Sweet!");
		
		// set size
		guiFrame.setSize( 700, 900 );

		// create a TreePanel and add it
		guiFrame.add( new IceCreamMaker() );
		

		// exit normally on closing the window
		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// show frame
		guiFrame.setVisible( true );
	}
}