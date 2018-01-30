import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.Random;

/**
 * The IceCreamCone connects the logic of the game with the interactive components of the application.
 * 
 * @author Ioanna Deni
 * @version 11/4/2017
 *
 */
public class IceCreamCone extends JComponent {
	
	//The list to store the scoops
	private StackLL<String> scoopList;

	//The values for the cone
	private static final int WIDTH = 50;
	private static final int HEIGHT = WIDTH * 3;
	
	//The values of the scoop
	private static final int SCOOP = 120;
	
	//The overlap of the scoop and the cone
	private static final int OVERLAP = 28;

	/** 
	 * Constructor initiates a stack
	 **/
	public IceCreamCone() {
		
		//The list is initiated
		scoopList = new StackLL<String>();
		
	}
	
	/**
	 * This paint method overrides the java paint method and calls the paintCone method that draws the cone.
	 */
	@Override
	public void paint(Graphics g){
		
		paintIceCream(g, scoopList);
		paintCone (g); 
		
	}
	
	/**
	 * The add method adds the element of type string to the linkList
	 * 
	 * @param scoop
	 */
	public void add(String scoop){
		scoopList.push(scoop);
		}
	
	/**
	 * This method adds random scoop flavors.
	 * Code borrowed from Assignment3
	 * This method is not used in this assignment
	 * 
	 */
	private void addRandom() {
		
		// this is a random int generator to assign random values to flavors
		Random random = new Random();
		
		//we get the int between zero and tree
		int flavorValue = random.nextInt(4); 

		// push different flavors to our stack
		if (flavorValue==1){
			// if value is one we add vanilla
			scoopList.push("vanilla");
		}
		else if (flavorValue==3){
			// if value is three we add chocolate
			scoopList.push("chocolate");
		}
		else if (flavorValue==3){
			// if value is two we add greenTea
			scoopList.push("greenTea");
		}
		else if (flavorValue==0){
			// if value is zero we add strawberry
			scoopList.push("strawberry");
		}
	}
	
	/**
	 * The delete method  deletes the top (last) element type string fro the linkList 
	 */
	public void delete(){
		scoopList.pop();
	}
	
	/**
	 * This method paint and places the cone on the bottom of the canvas.
	 * 
	 * @param cone
	 */
    public void paintCone (Graphics cone) {
    	 
    	//Dark brown
		cone.setColor(new Color(181, 152, 114)); 
		
		//This calls the java made fillPolygon class that takes two int [] and and int which shows the number of elements in the arrays
		//The two int [] contain the x and y coordinates of the cone
		cone.fillPolygon(new int [] {this.getWidth()/2, this.getWidth()/2 - WIDTH, this.getWidth()/2 + WIDTH}, 
				new int [] {this.getHeight(), this.getHeight() - HEIGHT, this.getHeight() - HEIGHT},3);
		}
    
    /**
	 * This method paint and places the scoops on the top of the cone.
	 * 
	 * @param scoops
	 * @param flavorList
	 * 
	 */
    public void paintIceCream (Graphics scoops, StackLL<String> flavorList) {
    	 
    	//first we create a temporary list to save the scoops after moving them from the stack of the original list 
    	StackLL<String> tempList = new StackLL<String>();
    	
    	//This is a count because when we draw the scoops it will have to measure the width of the previous
    	int number = 0;
    	
    	//Now we fill the temporary list with scoops from the actual scoopList as long as the list is not empty
    	if (!scoopList.isEmpty()){
    		
    		int size = scoopList.size();
    		
    		for (int i = 0; i< size; i++){
    			
        		String scoop = scoopList.pop();
        		//the scoop is saved and transferred to the tempList
        		tempList.push(scoop);}
    		
    		//after filling the tempList we create the scoops and put it back on the scoopList 
        	//This is done because we want to start drawing upside down but we can only pop the last scoop 
    		
    		for (int i = 0; i< size; i++){	
    			
        		//Here we save the flavor of the scoop in the tempList and the color it should be
        		String flavor = tempList.pop();
        		Color scoopColor = null;
        		
        		
        		if (flavor.equals("vanilla")){
        			
        			//we put the value back in the scoopList
        			scoopList.push("vanilla");
        			
        			//update the number of scoops and the color of the scoop
        			number ++;
        			scoopColor = new Color(250, 255, 255);
        		}
        		
        		else if (flavor.equals("strawberry")){
        			
        			//we put the value back in the scoopList
        			scoopList.push("strawberry");
        			
        			//update the number of scoops and the color of the scoop
        			number ++;
        			scoopColor = new Color(255, 204, 204);
        		}
        		
        		else if (flavor.equals("greenTea")){
        			
        			//we put the value back in the scoopList
        			scoopList.push("greenTea");
        			
        			//update the number of scoops and the color of the scoop
        			number ++;
        			scoopColor = new Color(180, 229, 163);
        		}
        		
        		else if (flavor.equals("chocolate")){
        			
        			//we put the value back in the scoopList
        			scoopList.push("chocolate");
        			
        			//update the number of scoops and the color of the scoop
        			number ++;
        			scoopColor = new Color(102, 51, 0);
        		}  
        		
        	//after defining the color and the number the scoops are drawn
        	scoops.setColor(scoopColor);
        	// paint the scoop
        	scoops.fillOval(this.getWidth()/2 - SCOOP/2, this.getHeight() - HEIGHT -(SCOOP-OVERLAP) * number, SCOOP, SCOOP);
    		}
    	}
	}
}
