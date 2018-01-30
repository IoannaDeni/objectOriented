/**
 * TetrisL1 represents one of the Tetris L shapes.
 * This class is responsible for giving values to the filledSquares inherited field 
 * and defining algorithms for the methods inherited from the super class but also specific to this tetris piece  
 *  
 * @author Ioanna Deni
 * @version 10/16/17
 *
 */
public class TetrisL extends TetrisPiece{
	
	/**
	 * Constructor sets up inherited field filledSquares.
	 */
	public TetrisL(){
		
		super();

		//This is for the non-rotated L piece in a 3x3 grid
		filledSquares[0][0][0]= true;
		filledSquares[0][1][0]= true;
		filledSquares[0][2][0]= true;
		filledSquares[0][2][1]= true;
		
		//This is for the 90 degrees rotated L piece on its belly
		filledSquares[1][1][1]= true;
		filledSquares[1][1][0]= true;
		filledSquares[1][2][0]= true;
		filledSquares[1][1][2]= true;
		
		//This is for the 180 degrees rotated L piece on its belly
		filledSquares[2][0][0]= true;
		filledSquares[2][0][1]= true;
		filledSquares[2][1][1]= true;
		filledSquares[2][2][1]= true;
		
		//This is for the 180 degrees rotated L piece on its back
		filledSquares[3][2][1]= true;
		filledSquares[3][2][0]= true;
		filledSquares[3][2][2]= true;
		filledSquares[3][1][2]= true;
				
	}
}