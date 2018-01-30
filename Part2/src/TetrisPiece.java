/**
 * The TetrisPiece abstract class represents a class that holds all of the four-block tetris pieces 
 * (which are seven, T, L, J, S, Z, I, O). It maintains 4 rotations 
 * (0 degrees, 90 degrees, 180 degrees and 270 degrees), with each being a 4x4 grid with certain filled squares.
 * This class is also responsible for methods specific to tetris piece information thus it declares them
 * but the classes specify them.
 * The purpose of this class is to be able to return an array of three numbers the 4x4 grid of the blocks 
 * and the rotation pointer to the specific grid. 
 * 
 * @author Ioanna Deni
 * @version 10/16/17
 */

public abstract class TetrisPiece {
	
	//3 dimensional array maintaining which squares are filled 
	//first dimension is rotation (index 0: 0 degrees, index 1: 90 degrees, index 2: 180 degrees, index 3: 270 degrees) 
	//second and third dimensions create 4x4 grid with true values indicating filled squares
	protected boolean [][][] filledSquares;
	
	//Maintains the current rotation.
	protected int pieceRotation;
	
	/**
	 * Constructor of the tetris pieces that initiate their 3D array.
	 */
	public TetrisPiece(){
		
		//The initial piece is not rotated so the first component of the 3D array is 0 
		pieceRotation = 0;
		
		//Here we initiate the array that holds the piece
		filledSquares = new boolean[4][4][4];
		
	}
	
	/**
	 * Get the rotation of this piece.
	 * 
	 * @return 0, 90, 180, or 270 degrees
	 */
	public int getPieceRotation(){
		
		//Returns the number stored in the pieceRotation variable
		return pieceRotation;
	}
	
	/**
	 * Rotate the piece clockwise by 90 degrees.
	 */
	public void rotateCW(){
		
		//If the rotation has increased more than the four status that we have defined the rotation is returned to the initial zero
		if (pieceRotation > 2){
			pieceRotation = 0;}
		else{
			//First we update the pieceRotation index
			pieceRotation = pieceRotation + 1;
		}
				
	}
	
	/**
	 * Rotate the piece counter-clockwise by 90 degrees.
	 */
	public void rotateCCW(){
		
		//If the rotation is already in its initial form then the rotation of 270 degrees is returned - index 4
		if (pieceRotation == 0){
			pieceRotation = 3;
		}
		else {
			//Update the pieceRotation index a unit smaller 
			pieceRotation = pieceRotation - 1;
		}
	}
	
	/**
	 * Checks if there is a TetrisBlock at the (row, col) 
	 * position for the rotation rot, where rot is 0, 90, 180 or 270 degrees.
	 * 
	 * @param rot - the TetrisPiece rotation value (should be 0, 90, 180, or 270)
	 * @param row - the row within the TetrisPiece 4x4 grid
	 * @param col - the col within the TetrisPiece 4x4 grid
	 * @return true if there is a block in the position for that rotation
	 */
	
	public boolean isFilled (int rot, int row, int col){
		
		//If the position is not empty in the 4x4 grid then this method returns true
		if (filledSquares[rot][row][col] == true){
			return true;}
		
		//if any of the rotation row or column of the 4x4 grid is empty it returns false
		return false;
	}
}
