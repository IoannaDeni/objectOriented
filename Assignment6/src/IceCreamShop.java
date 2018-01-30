import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * This is the main class that connects the iceCreamMaker class and the iceCreamLine class. 
 * It connects them by trying to match the scoops of the one to the other.   
 * 
 * @author Ioanna Deni
 * @version 11/14/2017
 *
 */
public class IceCreamShop extends JPanel{
	
	//These variables hold the points that the user wins or loses
	public static final int WINPOINTS = 10;
	public static final int LOSEPOINTS = 5;
	
	//here we store the total score and the place we put it
	private int totalScore;
	private JLabel scoreLabel;
	
	//We input the two ice creams constructions with their different abilities
	private IceCreamLine orderLine;
	private IceCreamMaker iceCreamMaker;
		
	/**
	 * The constructor creates the correct design for the view. 
	 * Adding the buttons on the screen and the information for the score. 
	 */
	public IceCreamShop(){
		
		super(new BorderLayout());
		
		//we initiate our variables 
		 orderLine = new IceCreamLine();
		 iceCreamMaker = new IceCreamMaker();
	    
		//this panel will hold the line and the orderLine view
		JPanel leftView = new JPanel(new BorderLayout());
		 leftView.add(orderLine, "Center");
		
		//we create a button for adding the random orders 
		JButton nextOrder = new JButton("Add A Random Order");
		
		//we are putting this button on the bottom of the view
		leftView.add(nextOrder, "South");
		
		//the button will have the functions defined here no implement of ActionListener class
		//this is an override that  I adopted after reading if the different ways to implement listeners because the traditional wouldn't work
		nextOrder.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent evt) {
	    		orderLine.addIceCream();
	    	}
		});
	    
		//now we have to add this view (panel) on the actual left side of our main view 
	    add(leftView, "West");
	    
	    //now we add the iceCreamMaker on the other side
	    add(iceCreamMaker, "East");
	    
	    //This panel will hold the information for the score and it will be on the top of the main view	    
	    JPanel scoreView = new JPanel(new GridLayout(5, 1));
	    add(scoreView, "North");
	    
	    //these are the instructions for the game
	    JLabel firstSentence = new JLabel("Make ice cream cones to match every order (starting at the top).");
	    JLabel secondSentence = new JLabel("Every correct order served earns you 10 points.");  
	    JLabel thirdSentence = new JLabel ("Make the wrong cone and you'll lose 5 points.");
	    
	    //We add the instructions in the view on the top of the window
	    scoreView.add(firstSentence);
	    scoreView.add(secondSentence);
	    scoreView.add(thirdSentence);
	    
	    //the last thing that is added is the score which is zero initially
	    totalScore = 0;
	    scoreLabel = new JLabel("Score: " + totalScore);
	    scoreView.add(scoreLabel);
	    
	    //This button is the big serve button under the score information 
	    JButton serveButton = new JButton("Serve The Next Order");
	    
	    //the action of the button is found here
	    serveButton.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent evt) {
	    		serving();
	    		//to repaint everything
	    		repaint();
	    		validate();}
	    	});
	    
	    //add the button to the panel
	    scoreView.add(serveButton);}
	
	
	/**
	 * This method updates the score and the view if the serving button is pressed which called the matching algorithm to compare the ice creams. 
	 */
	public void serving(){
		
		//if the line is not empty we get the iceCream on the front of the queue 
		if (orderLine!=null){
			
			//these two are the ice creams compared
			IceCreamCone iceCreamFromQueue = orderLine.getIceCream();
			IceCreamCone iceCreamFromStack = iceCreamMaker.getIceCream();

			//the method matchedForServe is called that compares the ice creams 
			if (matchedForServe(iceCreamFromQueue, iceCreamFromStack)) {
				//the ice cream in the orderLine is removed for the view
				orderLine.deleteIceCream();
				
				//for all the scoops that it is known is between 1 and for we pop the stack
				for(int i =0; i < 4; i++){
					iceCreamFromStack.delete();
				}
				
				//if that is true then 10 points are added to the score 
				totalScore += 10;}
			else {
				//else five points are taken of the score
				totalScore -= 5;
				}
			//the score label is updated to show the right score
			scoreLabel.setText("Score: " + totalScore);
	   }
	}

	
	/**
	 * This method checks the matching of two ice creams  
	 * 
	 * @param cone1
	 * @param cone2
	 * @return
	 */
	public boolean matchedForServe(IceCreamCone cone1, IceCreamCone cone2){
		
		//if any of the cones is empty then the method returns false
		if (cone1.isEmpty() || cone2.isEmpty()) {
	        return false;
		}
		
		//as long as there is a scoop in the cones of the queue
		if (!cone1.isEmpty() && !cone2.isEmpty()){
			
			//as big as their size
			for (int i =0; i < cone1.iceCreamSize(); i++){
			
			//if during the while loop in any of the scoops there is an mismatch then the method returns false 
			if (!cone1.check().equals(cone2.check())) {
				return false;}
			}
		}
		
		return true;
	  }
}
