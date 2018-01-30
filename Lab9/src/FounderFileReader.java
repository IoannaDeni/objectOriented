import javax.xml.parsers.*;
import org.xml.sax.SAXException;  
import org.w3c.dom.*;
import java.io.*;

/**
 * This program is a simple parsing program that takes a file of type xml and matches the text with what is supposed to be.
 * The file that we input has 5 individuals with personal information so the parser reads the information and matches it to the type of information it is
 * 
 * @author Ioanna Deni
 * @version 11/14/2017
 *
 */
public class FounderFileReader {
	
	/**
	 * This is the method that initiates the program
	 * It takes as arguments the file and creates a readable document which is then parsed 
	 * 	
	 * @param args
	 */
	public static void main( String[] args )
	{
		
		//This only works with the file name "college_founders.xml" passed in configuration arguments
		if (args.length > 0 && args[0].equals("college_founders.xml")) {
			
			//We try doing these procedures and catching the errors
			try {
				
				//Setup XML Document -code given by lab instructions
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				javax.xml.parsers.DocumentBuilder builder = factory.newDocumentBuilder();
				File xmlFile = new File( args[0] );
				Document document = builder.parse( xmlFile );
				
				//We initiate the parsing
				parseFounderFile(document);		
				
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
			
			
		}
	}
	
	/**
	 * This method starts the recursive parsing by taking the root of the document 
	 * 
	 * @param document
	 */
	private static void parseFounderFile( Document document ){
		
		//getting the root
		Node docRoot =  document.getDocumentElement();
		
		//the recursion happens here
		parseNode(docRoot);
	}
	
	
	/**
	 * This methods selects the desired information and prints the values of text to have the desired design
	 * 
	 * @param n
	 */
	private static void parseNode(Node n){
		
		//If the node of the document tree has the desired name print the name and the value
		if (n.getNodeName().equals("name") || n.getNodeName().equals("year") || n.getNodeName().equals("college")){
			System.out.print(n.getNodeName() + ":");
			System.out.println(n.getTextContent());
		}
		
		//Now that they are printed we look at their branches/leaves
		if (n.hasChildNodes()){
			
			NodeList list = n.getChildNodes();
			
			//we look at all their branches separately
			for (int i = 0; i < list.getLength(); i++){
				
				Node node = list.item(i);
				
				//if they are elements (we remove possible non desired text like #text)
				if( node.getNodeType() == Node.ELEMENT_NODE )
				{	
				   //we get only the element to put into the list
				   Element currentElt = (Element)node;
				   
				   //if that element has an attribute we print that too
				   if (currentElt.hasAttribute("id")){
					   System.out.println("id : " + currentElt.getAttribute("id"));
					}
				   
				   //recursion happens
				   parseNode(currentElt);
				}
				
			}
		}
	}

}
