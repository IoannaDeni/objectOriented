/**
 * TetrisL1 represents one of the Tetris I shapes.
 * This class is responsible for giving values to the filledSquares inherited field 
 * and defining algorithms for the methods inherited from the super class but also specific to this tetris piece  
 *  
 * @author Ioanna Deni
 * @version 10/16/17
 *
 */
public class TetrisI extends TetrisPiece{
	
	/**
	 * Constructor sets up inherited field filledSquares.
	 */
	public TetrisI(){
		
		super();

		//This is for the initial non-rotated 4x4 grid of the line as siting straight
		filledSquares[0][0][0]= true;
		filledSquares[0][1][0]= true;
		filledSquares[0][2][0]= true;
		filledSquares[0][3][0]= true;
		
		//This is for the 90 degrees rotation of the line as vertical line 
		filledSquares[1][1][0]= true;
		filledSquares[1][1][1]= true;
		filledSquares[1][1][2]= true;
		filledSquares[1][1][3]= true;
		
		//This is identical with the initial rotation - rotation after 180 degrees
		filledSquares[2][0][0]= true;
		filledSquares[2][1][0]= true;
		filledSquares[2][2][0]= true;
		filledSquares[2][3][0]= true;
		
		//This is identical with the second rotation - rotation after 270 degrees
		filledSquares[3][1][0]= true;
		filledSquares[3][1][1]= true;
		filledSquares[3][1][2]= true;
		filledSquares[3][1][3]= true;
		
	}
}