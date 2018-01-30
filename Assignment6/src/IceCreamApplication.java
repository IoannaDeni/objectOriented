import javax.swing.JFrame;

/** 
 * Application for starting up the GUI Ice Cream ordering.
 *     	
 * @author Ioanna Deni
 * @version 11/12/2017
 * (Code borrowed from Assignment5)
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
		guiFrame = new JFrame( "The Ice Cream Ordering Line: Please Be Patient We Are Not Smart!");
		
		// set size
		guiFrame.setSize( 560, 700 );

		// create a TreePanel and add it
		guiFrame.add( new IceCreamShop() );
		

		// exit normally on closing the window
		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// show frame
		guiFrame.setVisible( true );
	}
}