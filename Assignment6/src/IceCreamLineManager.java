import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;    

/** 
 * Displays instructions and the ice cream ordered line and allows manipulation from the user based on the button interaction.
 *     	
 * @author Ioanna Deni
 * @version 11/12/2017
 * (Code borrowed from Assignment4)
 * 
 **/
public class IceCreamLineManager extends JPanel implements ActionListener{	
	
	//The game that has the stored list of ice creams 
	private IceCreamLine iceCreamLine;
		
	//these are all of the buttons of the panel
	private JButton serveOrder, addOrder; 
	
	/** 
	 * Constructor uses a border layout. The GUI is set up by
	 * putting a JLabel with instructions in the NORTH region, 
	 * and a new ice cream line in the CENTER region.
	 **/
	public IceCreamLineManager()
	{
		// use a BorderLayout
		super( new BorderLayout() );
		
		//this creates the list that allows manipulation of the ice creams
		iceCreamLine = new IceCreamLine();
		
		// Display the view of the board in the center of the panel
		this.add(iceCreamLine, BorderLayout.CENTER);
		
		// create the buttons 
		createView();
	}
	
	/**
	 * This method defines Listener for the ActionListener interface and what is does is move the piece down at the pace of the timer
	 * 
	 * @param evt
	 */
	@Override
	public void actionPerformed(ActionEvent evt){
		
		if (evt.getSource().equals(serveOrder)) {
			//if the serveOrder button is clicked then an ice cream is deleted
			iceCreamLine.deleteIceCream();
			} 
		
		else if (evt.getSource().equals(addOrder)) {
			//if the addOrder button is clicked then an ice cream is added
			iceCreamLine.addIceCream();
			}
		
		//and then all are repaint
		iceCreamLine.repaint();
		iceCreamLine.validate();
		}
	
	/**
	 * Creates the necessary variables for for making the blocks of the game have time related behavior and GUI characteristics 
	 */
	private void createView(){
					
		// the appearing text on the buttons for the scoops 
		String serveOrderText = ("Serve The Next Order");
		String addOrderText = ("Add Random Order");
		
		// the strings are set as 
		serveOrder = new JButton(serveOrderText);
		addOrder = new JButton(addOrderText);
		
		//adding the buttons listener
		serveOrder.addActionListener(this);
		addOrder.addActionListener(this);


		// a separate panel for the two buttons to be stack on a grid 
		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new GridLayout(2, 0));

		// add the labels to the panel
		bigPanel.add(addOrder);
		bigPanel.add(serveOrder);
		
		//now adding the panel to the bigger bordedLayout
		add(bigPanel, BorderLayout.NORTH);
	}
}
