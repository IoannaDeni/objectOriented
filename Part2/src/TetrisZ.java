/**
 * TetrisL1 represents one of the Tetris Z shapes.
 * This class is responsible for giving values to the filledSquares inherited field 
 * and defining algorithms for the methods inherited from the super class but also specific to this tetris piece  
 *  
 * @author Ioanna Deni
 * @version 10/16/17
 *
 */
public class TetrisZ extends TetrisPiece{
	
	/**
	 * Constructor sets up inherited field filledSquares.
	 */
	public TetrisZ(){
		
		super();

		//This is for the non-rotated Z piece in a 3x3 grid
		filledSquares[0][0][0]= true;
		filledSquares[0][0][1]= true;
		filledSquares[0][1][1]= true;
		filledSquares[0][1][2]= true;
		
		//This is for the 90 degrees rotated Z piece
		filledSquares[1][0][2]= true;
		filledSquares[1][1][1]= true;
		filledSquares[1][1][2]= true;
		filledSquares[1][2][1]= true;
		
		//This is identical with the initial rotation - rotation after 180 degrees
		filledSquares[2][0][0]= true;
		filledSquares[2][0][1]= true;
		filledSquares[2][1][1]= true;
		filledSquares[2][1][2]= true;
		
		//This is identical with the second rotation - rotation after 270 degrees
		filledSquares[3][0][2]= true;
		filledSquares[3][1][1]= true;
		filledSquares[3][1][2]= true;
		filledSquares[3][2][1]= true;
	}
}