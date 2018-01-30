package Design;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.Timer;


/**
 * This is the controller where the tetris viewBoard and GameLogic of tetris are called
 * This is the class that that make changes to the model and the view, based on user input and the timer
 *
 * @author Ioanna Deni
 * @version 10/10/2017
 *
 */

public class Controller {

	//holds the information for the constructed piece
	private GameLogic piece;
	
	//a variable to hold the new board grid
	private ViewBoard newBoard;
	
	//a variable for the left border of the board
	private static final int leftWall= 10;	
	
	//a variable for the right border of the board
	private static final int rightWall = 10;
	
	//a variable for the top border of the board
	private static final int topBorder = 17;
	
	//a variable for the bottom border of the board
	private static final int bottomBorder = 17;
	
	//holds a row of booleans 
	//(either filled or empty positions of the grid) 
	//for when a complete row has occurred and the board has to move down
	private boolean [][] copiedGrid;
	
	//holds a row of booleans (either filled or empty positions of the grid)
	private boolean [][] toRow;
	
	//holds the score of the user by the lines that the user has filled
	public int score;
	
	/**
	 * The constructor of the class that calls and updates the GameLogic and ViewBoard class 
	 */
	public Controller(){
		
	}
	
	/**
	 * Method required for getting input from the user and changing the GameLogic model accordingly 
	 * and updating the ViewBoard newBoard 
	 * after checking if the input is valid (doesn’t exit the board borders)
	 */
	public void keyTyped(){
		
	}
	
	/**
	 * Handles changes after our timer has been set in motion 
	 * so if no user input then the piece moves one line every unit of time till it gets to the bottom of the board 
	 * or hit another piece 
     */
	public void run() {
		
	}
	
	/**
	 * Checks if any row is filled saves it in toRow array and in the copiedGrid it saves all the pieces above it
	 * then it removes the toRow and copies the copiedGrid one row bellow
	 * updates the ViewBoard  
	 */
	public void checkRow(){
		
	}
	
	/**
	 * Checks if the copiedGrid has height bigger than the one of the board border 
	 * so finishes the game and starts another one
	 * updates the ViewBoard  
	 */
	public void endGame(){
		
	}
	
	/**
	 * Updates the score when the checkRow methods returns a new board 
	 * updates the ViewBoard  
	 */
	public void updateScore(){
		
	}
			
}
