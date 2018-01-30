package Design;

/**
 * Model for tetris pieces.
 * This class is the constructor for all of the four block tetris pieces (which are seven, T, L, S, Z, I, O, and mirroredL).
 * It constructs them based on their y and x coordinates of their blocks and on their rotation. 
 * The purpose of this class is to be able to return an array of three numbers the x determining the x positions of the blocks 
 * the y determining the y values of the x position of the blocks 
 * and the z coordinate which will be relative to the x and y coordinates 
 * since it will give information for the statue of rotation the piece is currently on. 
 * This class is also responsible for methods specific to tetris piece information 
 * so if any information for the piece width, height, or orientation is required then the methods defined in this class will return them.
 * 
 * @author Ioanna Deni
 * @version 10/10/16 
 */

public class GameLogic {
	
	//holds the information for the constructed piece
	GameLogic [][][] currentPiece;
	
	/**
	 * Constructor of the tetris pieces.
	 */
	public GameLogic(){

	}
	
	/**
	 * Method for getting the width of the wider size of the piece
	 * @return int of total piece width
	 * @param piece to identify its width
	 */
	public int getWidth(GameLogic piece){
		return 1;
	}
	
	/**
	 * Method for getting the height of the higher size of the piece
	 * @return int of total piece height
	 * @param piece to identify its height
	 */
	public int getHeight(GameLogic piece){
		return 1;
	}

	/**
	 * Method for getting the specific current coordinates of a piece
	 * @param piece to determine its exact position
	 * @return GameLogic [][][] piece of the x, y, and z coordinates of the piece
	 */
	public GameLogic[][][] getPiece(GameLogic piece){
		return currentPiece;
	}
	
	/**
	 * Method for moving the piece one unit to the left
	 * @param piece to alter its position
	 */
	public void moveToLeft(GameLogic piece){
		
	}	
	
	/**
	 * Method for moving the piece one unit to the right
	 * @param piece to alter its position
	 */
	public void moveToRight(GameLogic piece){
		
	}
	
	/**
	 * Method for moving the piece one unit down
	 * @param piece to alter its position
	 */
	public void moveDown(GameLogic piece){
		
	}
	
	/**
	 * Method for painting the piece and making it visible
	 * @param piece to alter its color
	 */
	public void paint(GameLogic piece){
		
	}
	
	/**
	 * Method for rotating the piece by 90 degrees
	 * @param piece to alter its position
	 */
	public void nextRotation(GameLogic piece){
		
	}
	
}
