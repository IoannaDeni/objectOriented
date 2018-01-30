import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;

/**
 * This is the controller where the tetris view and game of tetris are called
 * This is the class that that make changes to the model and the view, based on user input and the timer
 * 
 * @author Ioanna Deni
 * @version 10/23/2017
 *
 */
public class TetrisGameGUIController extends JPanel implements KeyListener, ActionListener {
	
	//the timer counts in milliseconds 1000 = 1 sec
	public static final int defaultDropRate = 800;
	
	private TetrisGame game;
	
	private TetrisBoardGUIView view;
	
	//The next two labs are saved here because we are going to be updating them based on the score
	private JLabel linesLabel;
	private JLabel tetrisesLabel;
	
	private Timer gameTimer;

	
	/**
	 * The constructor calls the functions that make the board appear
	 */
	public TetrisGameGUIController (){
		
		// Set the layout to be border-style
		super(new BorderLayout());
		
		//add the key listener
		setFocusable(true);
		addKeyListener(this);
					
		//The game starts here and a view of the game too
		game = new TetrisGame();
		view = new TetrisBoardGUIView(game.getTetrisBoard());
						
		// Display the view of the board in the center of the panel
		this.add(view, BorderLayout.CENTER);
		
		//This creates the view and the timer
		createView();
		setupTimer();
	}
	
	/**
	 * This method initializes the timer based on a value
	 */
	private void setupTimer(){
				
		gameTimer = new Timer(defaultDropRate, this);
		//creates a new timer and initializes it
		gameTimer.start();
		
		
	}
	
	/**
	 * This method defines Listener for the ActionListener interface and what is does is move the piece down at the pace of the timer
	 * 
	 * @param evt
	 */
	@Override
	public void actionPerformed(ActionEvent evt){

		//This is an attempt to move the piece down
		game.attemptMove(3);
		
		//We need to refresh and repaint to update the view version and draw the new vew version
		refreshDisplay();
		repaint();
		}
	
	
	/**
	 * Creates the necessary variables for for making the blocks of the game have time related behavior and GUI characteristics 
	 */
	private void createView(){
					
		// the appearing text on the board for the score will be
		String clearedLines = ("Number of lines cleared: " + 0);
		String clearedTetrises = ("Number of tetrises cleared: " + 0);

		// a separate panel for the two labels to be stack on a grid 
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(new GridLayout(2, 0));

		// the strings are set as 
		linesLabel = new JLabel(clearedLines);
		tetrisesLabel = new JLabel(clearedTetrises);

		// add the labels to the panel
		scorePanel.add(linesLabel);
		scorePanel.add(tetrisesLabel);
		
		//now adding the panel to the bigger bordedLayout
		add(scorePanel, BorderLayout.NORTH);
	}
	
	/**
	 * This method sets the updated text for the labels defining the score (of lines and tetrises)
	 */
	private void createScore(){

		//the labels are updated based on the number of lines and tetrises 
		linesLabel.setText("Number of lines cleared: " + game.getNumLines());
		tetrisesLabel.setText("Number of tetrises cleared: " + game.getNumTetrises());
		
	}

	/**
	 * Prints the new view of the game after an update 
	 */
	public void refreshDisplay(){	
		//score is updated on every refresh
		createScore();
			
		//a new view of the board is required because the view of the board isn't updated only the board itself is
		view = new TetrisBoardGUIView(game.getTetrisBoard());
		
	}
	
	/**
	 * Handles the key typed event.
	 * @param e
	 */
	@Override
	public void keyTyped(KeyEvent e){
		
	}
	
	/**
	 * Handles the key-released event.
	 * Code borrowed from lab5
	 * 
	 * @param e
	 */
	@Override
	public void keyReleased(KeyEvent e){
		
		System.out.println(e.getKeyCode());
		//"KeyCode" is the enum of the key that was pressed
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_RIGHT){
	    	
	    	//This is an attempt to move the piece left
			game.attemptMove(1);
			
			//Here we are updating the board
			refreshDisplay();
			
			//this is inside each if statement because we want it to repaint only if these keys are pressed
			repaint();
	    }
		
		else if (key == KeyEvent.VK_LEFT) {
	    	
	    	//This is an attempt to move the piece left
			game.attemptMove(2);
			
			//Here we are updating the board
			refreshDisplay();
			
			//this is inside each if statement because we want it to repaint only if these keys are pressed
			repaint();
	    }
	    	
		else if (key == KeyEvent.VK_DOWN) {
	    	
	    	//This is an attempt to move the piece down
			game.attemptMove(3);
			
			//Here we are updating the board
			refreshDisplay();
			
			//this is inside each if statement because we want it to repaint only if these keys are pressed
			repaint();
	    }

		else if (key == KeyEvent.VK_Z){
	    	//This is an attempt to rotate the clockwise by 90 degrees
			game.attemptMove(4);
			
			//Here we are updating the board
			refreshDisplay();
			
			//this is inside each if statement because we want it to repaint only if these keys are pressed
			repaint();
	    }
		
		else if (key == KeyEvent.VK_X){
	    	//This is an attempt to rotate the anti-clockwise by 90 degrees
			game.attemptMove(5);
			
			//Here we are updating the board
			refreshDisplay();
			
			//this is inside each if statement because we want it to repaint only if these keys are pressed
			repaint();
	    }
	}
	
	/**
	 * Handles the key-pressed event.
	 * 
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e){
	}
}
