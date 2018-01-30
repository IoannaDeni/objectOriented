/**
 * TetrisL1 represents one of the Tetris T shapes.
 * This class is responsible for giving values to the filledSquares inherited field 
 * and defining algorithms for the methods inherited from the super class but also specific to this tetris piece  
 *  
 * @author Ioanna Deni
 * @version 10/16/17
 *
 */
public class TetrisT extends TetrisPiece{
	
	/**
	 * Constructor sets up inherited field filledSquares.
	 */
	public TetrisT(){
		
		super();

		//This is for the non-rotated T piece in a 3x3 grid where it lies on its back
		filledSquares[0][0][1]= true;
		filledSquares[0][1][2]= true;
		filledSquares[0][1][0]= true;
		filledSquares[0][1][1]= true;
		
		//This is for the 90 degrees rotated T piece where it stands looking towards the right
		filledSquares[1][0][1]= true;
		filledSquares[1][1][2]= true;
		filledSquares[1][1][1]= true;
		filledSquares[1][2][1]= true;
		
		//This is for the 180 degrees rotated T piece where it lands on its belly
		filledSquares[2][0][0]= true;
		filledSquares[2][0][1]= true;
		filledSquares[2][1][1]= true;
		filledSquares[2][0][2]= true;
				
		//This is for the 270 degrees rotated T piece where it stands looking towards the left
		filledSquares[3][0][1]= true;
		filledSquares[3][1][0]= true;
		filledSquares[3][1][1]= true;
		filledSquares[3][2][1]= true;

				
	}
}
