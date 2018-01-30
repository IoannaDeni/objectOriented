import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;    

/**
 * A IceCreamMaker displays instructions and the ice cream shop and allows manipulation from the user based on the button interaction.
 * @author Ioanna Deni
 * 
 * (code borrowed from Assignment3 and Part3 of Tetris)
 * 
 **/
public class IceCreamMaker extends JPanel implements ActionListener
{
	//The game that has the stored list of scoops 
	private IceCreamCone cone;
	
	//these are all of the buttons of the panel
	private JButton vanilaButton, strawberryButton, greenTeaButton, chocolateButton, trashButton; 
	
	/** 
	 * Constructor uses a border layout. The GUI is set up by
	 * putting a JLabel with instructions in the NORTH region, 
	 * and a new ice cream object in the CENTER region.
	 **/
	public IceCreamMaker()
	{
		// use a BorderLayout
		super( new BorderLayout() );
		
		//this creates the list that allows manipulation of the flavor scoops
		cone = new IceCreamCone();
		
		// Display the view of the board in the center of the panel
		this.add(cone, BorderLayout.CENTER);
		
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
		
		if (evt.getSource().equals(vanilaButton)) {
			//if the vanila button is clicked then a vanila scoop is added
			cone.add("vanilla");} 
		
		else if (evt.getSource().equals(strawberryButton)) {
			//if the strawberry button is clicked then a strawberry scoop is added
			cone.add("strawberry");}
		
		else if (evt.getSource().equals(greenTeaButton)) {
			//if the greenTea button is clicked then a greenTea scoop is added
			cone.add("greenTea");}
		
		else if (evt.getSource().equals(chocolateButton)) {
			//if the chocolate button is clicked then a chocolate scoop is added
			cone.add("chocolate");}
		
		else if (evt.getSource() == trashButton) {//click eat button
			//if the trash button is clicked then the top scoop is removed 
			cone.delete();}
		
		//and then all are repaint
		repaint();
		}
	
	/**
	 * Creates the necessary variables for for making the blocks of the game have time related behavior and GUI characteristics 
	 */
	private void createView(){
					
		// the appearing text on the buttons for the scoops 
		String vanila = ("vanila");
		String strawberry = ("strawberry");
		String greenTea = ("green tea");
		String chocolate = ("chocolate");
		String trash = ("drop the top scoop");
		
		//a panel to store the scoop buttons one next to the other 
		JPanel scoopPanel = new JPanel();
		scoopPanel.setLayout(new GridLayout(0, 4));
		
		//a panel to store the trash button
		JPanel trashPanel = new JPanel();
		
		// the strings are set as 
		vanilaButton = new JButton(vanila);
		strawberryButton = new JButton(strawberry);
		greenTeaButton = new JButton(greenTea);
		chocolateButton = new JButton(chocolate);
		trashButton = new JButton(trash);
		
		//adding the buttons listener
		vanilaButton.addActionListener(this);
		strawberryButton.addActionListener(this);
		greenTeaButton.addActionListener(this);
		chocolateButton.addActionListener(this);
		trashButton.addActionListener(this);
		
		//setting the color of the buttons which after research seems that uses the setBackground
		vanilaButton.setBackground(new Color(250, 255, 255));
		strawberryButton.setBackground(new Color(255, 204, 204));
		greenTeaButton.setBackground(new Color(180, 229, 163));
		chocolateButton.setBackground(new Color(102, 51, 0));
		trashButton.setBackground(new Color(115, 190, 190));
		
		//setting the color of the buttons' text which after research seems that uses the setForeground
		chocolateButton.setForeground(Color.white);

		// add the labels to the panel
		scoopPanel.add(vanilaButton);
		scoopPanel.add(strawberryButton);
		scoopPanel.add(greenTeaButton);
		scoopPanel.add(chocolateButton);
		trashPanel.add(trashButton);

		// a separate panel for the two labels to be stack on a grid 
		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new GridLayout(2, 0));

		// add the labels to the panel
		bigPanel.add(scoopPanel);
		bigPanel.add(trashPanel);
		
		//now adding the panel to the bigger bordedLayout
		add(bigPanel, BorderLayout.NORTH);
	}
	
	
	/**
	 * This method returns the current flavored ice cream 
	 * 
	 * @return
	 */
	public IceCreamCone getIceCream(){
		
		//firstly the ice cream is null
		IceCreamCone iceCreamCone = null;
		
		//if there is an ice cream is full this is returned
		if (cone!=null){
			iceCreamCone = cone;
		}
		return iceCreamCone;
	}
}
