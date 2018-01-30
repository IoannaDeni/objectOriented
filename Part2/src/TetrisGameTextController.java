import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is responsible for a command line version of tetris by printing the game after each move.
 * 
 * @author Ioanna Deni
 * @version 10/16/2017
 *
 */
public class TetrisGameTextController {
	
	private TetrisGame game;
	
	private TetrisBoardTextView view;
	
	
	/**
	 * The constructor for printing the game board
	 */
	public TetrisGameTextController(){
		
		//The game starts here and a view of the game too
		game = new TetrisGame();
		view = new TetrisBoardTextView(game.getTetrisBoard());
	
		
		//This initiate the users input 
		readInput();

	}
	
	/**
	 * Gets input from the user (l,r,d,z,x), 
	 * l for move left, r for move right, d for down
	 * z for rotate counter-clockwise, x for rotate clockwise
	 * looping until the user types "Quit".
	 */
	private void readInput(){
		
		// code taken from lab 4
		// Buffered readers are used to read text input from the command line
		BufferedReader in =  new BufferedReader( new InputStreamReader( System.in ) );
		
		// Prompt the user for input
		System.out.println();
		System.out.println( "This is a text version of tetris"); 
				
		// Bufferedreaders require a try/catch block, to prevent exceptions from crashing your program
		try {
			System.out.println("Please enter a move (r: right l: left d: down z: clockwise rotation x: anti-clockwise rotation, a:for landing) or type quit to end.");

			// This function reads the next line where the user writes the move
			String input = in.readLine(); 
			
			// Loop until the user types "quit"
			while ( !input.toLowerCase().equals( "quit" )  ) {
				
				//if the input is any of the characters (Strings) below
				if (input.equals( "l" ) || input.equals( "r" ) || input.equals( "d" ) || input.equals( "z" )|| input.equals( "x" ) || input.equals("a")) {
					
					//This method is called
					moveEntered(input);
					
					//This follow for the next input
					System.out.println();
					System.out.println( "This is a text version of tetris"); 
					System.out.println("Please enter a move (r: right l: left d: down z: clockwise rotation x: anti-clockwise rotation, a:for landing) or type quit to end.");
}
				else {
					System.out.println("Error: Invalid move.");
}
					
				//Ask for the next input
				input = in.readLine();}
		}
		// catch I/O exception
				catch ( IOException ioenfe )
				{
					//inform user of problem
					System.out.println("Error: IOException. ");
				}}

	
	/**
	 * Print text view of the game. First, print the number of tetris pieces cleared. 
	 * Second, print the number of lines cleared. Then, print the tetris board.
	 */
	private void refreshDisplay(){
		
		//And how many tetris pieces based on the number of lines cleared are also printed for the user to see
		System.out.println("Number of tetris pieces cleared: " + game.getNumTetrises());
		
		//The score of the user based on how many lines it's been cleared is showed 
		System.out.println("Number of lines cleared: " + game.getNumLines());
		
		//a new view of the board is required because the view of the board isn't updated only the board itself is
		view = new TetrisBoardTextView(game.getTetrisBoard());
		
	}
	
	/**
	 * For r: right l: left d: down z: cw x: ccw
	 * 
	 * @param move
	 */
	private void moveEntered(java.lang.String move){
		
		if ("r".equals(move)){
			
			//This is an attempt to move the piece left
			game.attemptMove(1);
			
			//Here we are updating the board
			refreshDisplay();
		}
		
		else if ("l".equals(move)){
			
			//This is an attempt to move the piece left
			game.attemptMove(2);
			
			//Here we are updating the board
			refreshDisplay();
		}
		
		else if ("d".equals(move)){
			
			//This is an attempt to move the piece down
			game.attemptMove(3);
			
			//Here we are updating the board
			refreshDisplay();
		}
		
		else if ("z".equals(move)){
			
			//This is an attempt to rotate the clockwise by 90 degrees
			game.attemptMove(4);
			
			//Here we are updating the board
			refreshDisplay();
		}
		
		else if ("x".equals(move)){
			
			//This is an attempt to rotate the anti-clockwise by 90 degrees
			game.attemptMove(5);
			
			//Here we are updating the board
			refreshDisplay();
		}
		else if ("a".equals(move)){
			
			//This is an attempt to land the piece
			game.attemptMove(6);
			
			//Here we are updating the board
			refreshDisplay();}
	}
	
	/**
	 * This is the main method that starts the game.
	 * @param args
	 */
	public static void main(java.lang.String[] args){
		
		//Calls its constructor
		new TetrisGameTextController();
		
	}

}
