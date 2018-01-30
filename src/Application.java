import javax.xml.parsers.*;
import org.xml.sax.SAXException;  
import org.w3c.dom.*;
import java.io.*;
import javax.swing.JFrame;

/**
 * This is the main application of the program that accepts the arguments and initiate a view 
 * 
 * @author Ioanna Deni
 * @version 12/4/2017
 *
 */
public class Application {
	
	//the main method takes argumenst
	public static void main( String[] args ){
		
		JFrame guiFrame = null;
		
		//This only works with the file name "decisionTree.xml" passed in configuration arguments
		if (args.length > 0 && args[0].equals("decisionTree.xml")) {
			
			//We try doing these procedures and catching the errors
			try {
				
				//Setup XML Document -code given by lab instructions from lab 10
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				javax.xml.parsers.DocumentBuilder builder = factory.newDocumentBuilder();
				File xmlFile = new File( args[0] );
				Document document = builder.parse( xmlFile );
				
				// create a new JFrame to hold a single canvas for the view of the game
				guiFrame = new JFrame("The Guessing Game");
				
				// set size
				guiFrame.setSize( 1000, 600 );
				
				//create a view and add it to the frame
				guiFrame.add(new TreeView(document));
				
				} catch (ParserConfigurationException pce) {
					//inform user of problem
					System.out.println("Error: ParserConfigurationException. ");
					
				} catch (SAXException saxe) {
					//inform user of problem
					System.out.println("Error: SAXException. ");
					
				} catch (IOException ioe) {
				   //inform user of problem
					System.out.println("Error: IOException. ");
				}
			
			// exit normally on closing the window
			guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

			// show frame
			guiFrame.setVisible( true );		
		}
	}

}
