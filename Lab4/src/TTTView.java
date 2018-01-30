import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * Prints a board and the symbols of each player and updates the board in every clicks of the user.
 * 
 * @author Ioanna Deni
 * @version 10/5/2017
 *
 */

public class TTTView 
{
	//The board object from the game
	private TTTModel model;
	
	/**
	 * constructor initializes the board array
	 * @param board
	 */
	public TTTView(TTTModel model){
		this.model = model;
	}
	
	/**
	 * Print the board to the console
	 */
	public void printBoard(){
		//Get the board out of the model, then
		int [][] sizeBoard = model.getBoard();
		
		//loop through board and add appropriate character based on board contents
		for (int row=0; row< sizeBoard.length; row++) {
			// for each board row 
			
			//This is to create only two vertical lines on the middle of the board
			if (row==2 || row==1){
				System.out.println("------------");}
			
			for (int col=0; col < sizeBoard[row].length; col++){
				//for each board column

				//check if the board is occupied by player X, or player O, or neither
				
				if ( sizeBoard[row][col] == 1){
					//Print the correct character to the screen depending on the contents of the square
					System.out.print( " X ");}
				
				else if ( sizeBoard[row][col] == 2){
					//Print the correct character to the screen depending on the contents of the square
					System.out.print( " O ");}
				
				else {
					//Print the correct character to the screen depending on the contents of the square
					System.out.print("   ");}
				
				//This is to create 6 horizontal lines on the middle of the board
				if (col==1 || col==0 ){
					System.out.print("|");}
			}
		//To switch line to keep printing the board	
		System.out.println();
			
		}
	}
	
	/**
	 * This function prints the instructions of the game when 'help' is typed by the user
	 */
	
	public void help(){
		System.out.println("How to play:");
		System.out.println();
		System.out.println("You can only use numbers 1-9 which correspond to the index of the grid you want to input your X or O.");
		System.out.println();
		System.out.println("The first player takes the Xs and can play in any position in the 9 spaced tic tac toe grid,");
		System.out.println("once the game has begin you can't choose the same space twice else you'll get an error.");
		System.out.println();
		System.out.println("The goal of the game is to complete a full row or a column with your symbol without the interuption of your opponent.");
		System.out.println("If you do win the game is over, else the game is restarted");
		System.out.println();
		System.out.println("You can quit by typing 'quit'.");}
}