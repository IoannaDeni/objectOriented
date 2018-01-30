/**
 * TetrisL1 represents one of the Tetris O shapes.
 * This class is responsible for giving values to the filledSquares inherited field 
 * and defining algorithms for the methods inherited from the super class but also specific to this tetris piece  
 *  
 * @author Ioanna Deni
 * @version 10/16/17
 *
 */
public class TetrisO extends TetrisPiece{
	
	/**
	 * Constructor sets up inherited field filledSquares.
	 */
	public TetrisO(){
		
		super();

		//This is for all the rotations of the square
		filledSquares[0][0][0]= true;
		filledSquares[0][1][1]= true;
		filledSquares[0][1][0]= true;
		filledSquares[0][0][1]= true;
		
		filledSquares[1][0][0]= true;
		filledSquares[1][1][1]= true;
		filledSquares[1][1][0]= true;
		filledSquares[1][0][1]= true;
		
		filledSquares[2][0][0]= true;
		filledSquares[2][1][1]= true;
		filledSquares[2][1][0]= true;
		filledSquares[2][0][1]= true;
		
		filledSquares[3][0][0]= true;
		filledSquares[3][1][1]= true;
		filledSquares[3][1][0]= true;
		filledSquares[3][0][1]= true;
		
	}
}
