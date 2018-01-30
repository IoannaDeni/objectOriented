import java.util.Random;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Graphics;
/** 
 * This class is responsible for creating a GUI view of a TetrisBoard for the
 * game on JComponents window.
 *
 * @author Ioanna Deni
 * @version 10/23/2017
 */

public class TetrisBoardGUIView extends JComponent{
	
	private TetrisBoard board;
	
	/**
	 * 
	 * @param board
	 */
	public TetrisBoardGUIView(TetrisBoard board){
		this.board = board;
	}
	
	/**
	 * Calls the methods responsible for painting the different components.
	 * This method makes it possible for the board to be printed on the
	 * screen by creating it.
	 * Code borrowed from TetrisBoardTextView.class
	 * 
	 */
	@Override
	public void paint(java.awt.Graphics g){
			
		TetrisPiece piece = board.getCurrentPiece();

		// This returns the rotation of the current piece
		int rotation = piece.getPieceRotation();

		// This will tell us were the piece is located
		int[] position = board.getCurrentPieceGridPosition();

		// Gets the board out of the model - the Tetris board
		boolean[][] sizeBoard = board.getBlockMatrix();
		
		// loop through board rows - code taken from lab 4
		for (int row = 0; row < sizeBoard.length; row++) {
			// for each board row

			for (int col = 0; col < sizeBoard[row].length; col++) {
				// for each board column
				
				//The background board has already some pieces so these appear first
				if (board.hasBlock(row, col)) {
					//Set the color of the outside of the outline
					g.setColor(Color.black);
					g.fillRect(10+col*computeBlockSize(), 10+row*computeBlockSize(), computeBlockSize(), computeBlockSize());
				}
				// as long as the rows are inside the limits of the grid of
				// blocks of the piece
				else if (row >= position[0] && row < 4 + position[0]) {
					// four is the length of the 4x4 grid of the piece

					// as long as the columns are inside the limits of the grid
					// of blocks of the piece
					if (col >= position[1] && col < 4 + position[1]) {

						// if the are we check the grid
						if (piece.isFilled(rotation, row - position[0], col - position[1])) {
							paintBlock(g, 10+col*computeBlockSize(), 10+row*computeBlockSize(), computeBlockSize());
						} else {
							//Set the color of the outside of the outline
							//The forth color is the transparency, it is high so it matches the background color
							g.setColor(new Color(255,255,255,125));
							g.fillRect(10+col*computeBlockSize(), 10+row*computeBlockSize(), computeBlockSize(), computeBlockSize());
						}
					}

					// if the index is out of the specified col range
					else {
						//Set the color of the outside of the outline
						g.setColor(new Color(255,255,255,125));
						g.fillRect(10+col*computeBlockSize(), 10+row*computeBlockSize(), computeBlockSize(), computeBlockSize());
					}
				}
				// if the index is out of the specified col and row range
				else {
					//Set the color of the outside of the outline
					g.setColor(new Color(255,255,255,125));
					g.fillRect(10+col*computeBlockSize(), 10+row*computeBlockSize(), computeBlockSize(), computeBlockSize());
				}
			}
		}
		//After so we can see them
		paintBoardOutline(g, computeBlockSize());
	}
	
	/**
	 * Draws the outside frame
	 * 
	 * @param g
	 */
	private void paintBoardOutline(java.awt.Graphics g, int blockSize){
		
		//Set the color of the outside of the outline
		g.setColor(Color.black);
			
		//Draw the outline based on the number of squares that can fit on the sized canvas starting from the very beginning
		g.drawRect(10, 10, 10*blockSize, blockSize*18);
	}
	
	/**
	 * Paints the block at specified position.
	 * Code borrowed from assignment 2
	 * 
	 * @param g
	 * @param row
	 * @param col
	 * @param blockSize
	 */
	private void paintBlock(java.awt.Graphics g, int row, int col, int blockSize){
		
		//Here we generate a random number for our colors
		Random random = new Random();
		
		// Generate random integers in range 0 to 180 because the three colors go up to 180
        int red = random.nextInt(181);
        int green = random.nextInt(181);
        int blue = random.nextInt(181);
        
        //The new color of the block will be
        Color color = new Color(red, green, blue);
        
        // Set the color of the inside of the square
        g.setColor(color);
		
		// Draw the inside of the square on the instructed row and col and with the instructed width and height
		g.fillRect(row, col, blockSize, blockSize);
		
		//Set the color of the outside of the square - the outline
		g.setColor(Color.black);
		
		//Draw the outline of the square 
		g.drawRect(row, col, blockSize, blockSize);
	}
	
	/**
	 * Computes the best block size for the current width and height given on the application class.
	 * @return the size of each square
	 */
	private int computeBlockSize(){
		
		//There are 18 rows and 10 col and the height is 740 with 420 as the width 
		//20 is the boundaries 10 up 10 down 10 left 10 right
		int size = (getHeight()-10)/18;
		
		//or getWidth()-20/10 - they are giving the same results
		return size;
	}

}
