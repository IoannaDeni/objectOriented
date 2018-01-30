import org.w3c.dom.Document;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This is the view class responsible for creating the different frames of the application and combining the
 * J objects appearing on the screen and their function - also holds the new image class manipulation methods
 *  
 * @author Ioanna Deni
 * @version 12/5/2017
 */
public class TreeView extends JPanel{
	
	//This panel holds the different components organized one on top of the other (in a grid)
	private JPanel mainCollagePanel = new JPanel(new GridLayout(3,1));
	
	//This instances are saved here because they will be updated every time the frame changes
	private JLabel question, picLabel, text;
	private JPanel buttons, newGamePanel;
	private JButton start, yes, no, classic, intelligent, newGame;
	
	//this is the logic of the game and the parameter necessary for it
	private GameController game;
	private Document document;
	
	
	/**
	 * The constructor takes the read xml file and calls the logic of the game and 
	 * the first view of the game
	 *  
	 * @param document
	 */
	public TreeView(Document document){
		
		//We get the frame from the application class and add our components
		super(new BorderLayout());
		
		//this is going to set to a pale blue color the background of the panel
		mainCollagePanel.setBackground(new Color(213, 235, 245));
		
		//this will set white a very small portion of the view under the mainCollagePanel panel
		//that holds the suggestions for the countries
		this.setBackground(Color.WHITE);
		
		//sets the parameter to the global variable document ofthis class
		this.document = document;
		
		//initiate the logic of the game
		game = new GameController(document);
	
		//we write the root question of the quessing game
		question = new JLabel("What European Country Would You Want To Visit?", SwingConstants.CENTER);
		question.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		
		//we make a picture read and processed as a type JLabel
		picLabel = addPicture("europe-map165250170.jpg");
		
		//we create the buttons starting the game 
		start = new JButton("Start?");
		start.setBackground(new Color(112, 175, 175));
		
		newGame = new JButton("New Game");
		newGame.setBackground(Color.LIGHT_GRAY);
		
		//and add listener to the button
		start.addActionListener(new ActionListener(){
		   	@Override
		   	public void actionPerformed(ActionEvent evt) {
		   		//call the next frame 
		   		updateGame();
		   		//to repaint everything
		   		repaint();
		   		validate();}});
		
		//and add listener to the button
		newGame.addActionListener(new ActionListener(){
		   	@Override
		   	public void actionPerformed(ActionEvent evt) {
		    	//call the logic of the game again to renew it
		  		game.restart();
		  		updateGame();
		   		question.setText("Do you want to play the Classic Quessing Game or the 'Intelligent'one?");
		   		//to repaint everything
		   		repaint();
		   		revalidate();}});
		
		//adding the button to their panel which is of specified color
		buttons = new JPanel ();
		buttons.add(start);
		buttons.setBackground(new Color(213, 235, 245));
		
		newGamePanel = new JPanel();
		newGamePanel.add(newGame);
		newGamePanel.setBackground(new Color(213, 235, 245));
		// the panel does not appear on screen yet
		newGamePanel.setVisible(false);	
		
		//Create a little place to add all guessed countries
		String line = "Some suggestions: " + game.leafLibrary();
		text = new JLabel(line);
		text.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		//adding the components to the grid
		mainCollagePanel.add(question);
		mainCollagePanel.add(picLabel);
		mainCollagePanel.add(buttons);
		
		//adding the grid to the general frame
		add(mainCollagePanel,BorderLayout.CENTER );
		add(text, BorderLayout.SOUTH);
		add(newGamePanel, BorderLayout.NORTH);
	}
	
	/**
	 * This is the updated view of the game 
	 * That contains two possible games the restricted and the unrestricted one
	 * With a different picture and a different question and buttons
	 */
	private void updateGame(){
		
		//the text in the question label changes
		question.setText("Do you want to play the Classic Quessing Game or the 'Intelligent'one?");
		
		//cleaning up method that removes the buttons and the picture
		cleanUp();
		
		//we make another picture read and processed as a type JLabel
		picLabel = addPicture("maybe.jpg");
		
		//we create the other buttons
		classic = new JButton("Classic");
		classic.setBackground(new Color(195, 154, 40));
		
		intelligent = new JButton("Intelligent");
		intelligent.setBackground(new Color(192, 84, 219));
		
		//and add listener to the button
		classic.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent evt) {
	    		//call the logic of the game
	    		playClassic();
	    		//to repaint everything
	    		repaint();
	    		validate();}});
		
		
		intelligent.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent evt) {
	    		//call the logic of the game
	    		playInt();
	    		//to repaint everything
	    		repaint();
	    		revalidate();}});
		

		//adding the button to their panel
		buttons.add(classic);
		buttons.add(intelligent);
	
		//adding the new components to the grid
		mainCollagePanel.add(picLabel);
		mainCollagePanel.add(buttons);

	}
	
	
	/**
	 * This is the intelligent game that has specified listeners to its buttons 
	 * a different picture and is calling the unrestricted methods of the controller  
	 */
	private void playInt(){
		
		//updating the question of the JLabel to the root question of the xml tree
		question.setText(game.getQuestion());
		
		//cleaning up method that removes the buttons and the picture
		cleanUp();
		
		//we make another picture read and processed as a type JLabel
		picLabel = addPicture("learning.jpg");
		
		//we create the new buttons
		yes = new JButton("Yes");
		yes.setBackground(new Color(89, 169, 72));
		
		no = new JButton("No");
		no.setBackground(new Color(193, 78, 78));
		
		//and add listener to the button
		yes.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent evt) {
	    		//call the logic of the game
	    		question.setText(game.getYes());
	    		//to repaint everything
	    		repaint();
	    		revalidate();}});
		
		no.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent evt) {
	    		//call the logic of the game
	    		question.setText(game.updateNo(mainCollagePanel, document));
	    		//to repaint everything
	    		repaint();
	    		validate();}});
		
		//adding the button to their panel
		buttons.add(yes);
		buttons.add(no);
		
		//adding the new components to the grid
		mainCollagePanel.add(picLabel);
		mainCollagePanel.add(buttons);
		
		//setting the newGamePanel visible for interaction with its user
		newGamePanel.setVisible(true);
	}
	
	
	/**
	 * This is the classic game it calls the method that define the unrestricted game with the 
	 * classic answers and set length of leafs 
	 */
	private void playClassic(){
		
		//updating the question of the JLabel to the root question of the xml tree
		question.setText(game.getQuestion());
	
		//cleaning up method that removes the buttons and the picture
		cleanUp();
		
		//we make a picture read and processed as a type JLabel
		picLabel = addPicture("1.jpg");
		
		//we create the new buttons
		yes = new JButton("Yes");
		yes.setBackground(new Color(89, 169, 72));
		
		no = new JButton("No");
		no.setBackground(new Color(193, 78, 78));
		
		//and add listener to the button
		yes.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent evt) {
	    		//call the logic of the game
	    		question.setText(game.getYes());
	    		//to repaint everything
	    		repaint();
	    		revalidate();}});
		
		no.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent evt) {
	    		//call the logic of the game
	    		question.setText(game.getNo());
	    		//to repaint everything
	    		repaint();
	    		validate();}});

		//adding the button to their panel
		buttons.add(yes);
		buttons.add(no);
		
		//adding the new components to the grid
		mainCollagePanel.add(picLabel);
		mainCollagePanel.add(buttons);
		
		//setting the newGamePanel visible for interaction with its user
		newGamePanel.setVisible(true);
	}
	
	/**
	 * This method takes as parameter a string image name that must be located in the same directory as the 
	 * source code of this game and read it as an image and also sets it in the correct position
	 * 
	 * @param imagePath as a string
	 * @return an image JLabel
	 */
	private JLabel addPicture(String imagePath){
		
		//this is the JLabel we are going to fill
		JLabel theImage = null;
		
		//when adding the picture if it is located at a wrong path 
		//it will show exceptions so we catch those 
		try {
			
			//we import the picture by reading the file and scaling it as bing as we want it on the frame
			BufferedImage myPicture = ImageIO.read(new File(imagePath));
			Image scaled = myPicture.getScaledInstance(400, 600/3, Image.SCALE_SMOOTH);
			
			//then we put the picture into the label
			ImageIcon icon = new ImageIcon(scaled);
			theImage = new JLabel(icon);
			
		} catch (IOException ioe) {
		   //inform user of problem
			System.out.println("Error: IOException. ");}
		
		return theImage;
		}
	
	/**
	 * This method clears the buttons and the picture
	 */
	private void cleanUp(){
		
		//remove all the buttons from the panel
		buttons.removeAll();
		
		//removes the picture from the panel
		mainCollagePanel.remove(picLabel);
		
	}
}
