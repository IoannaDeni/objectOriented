/**
 * This class is responsible for creating a String view of a TetrisBoard for the
 * game on a terminal window or a command prompt.
 * 
 * @author Ioanna Deni
 * @version 10/16/2017
 *
 */
public class TetrisBoardTextView {

	private TetrisBoard board;

	/**
	 * This constructor makes it possible for the board to be printed on the
	 * screen by creating it.
	 * 
	 * @param board
	 */
	public TetrisBoardTextView(TetrisBoard board) {
		this.board = board;

		TetrisPiece piece = board.getCurrentPiece();

		// This returns the rotation of the current piece
		int rotation = piece.getPieceRotation();

		// This will tell us were the piece is located
		int[] position = board.getCurrentPieceGridPosition();

		// Gets the board out of the model - the Tetris board
		boolean[][] sizeBoard = board.getBlockMatrix();

		System.out.print("-----------");
		// To switch line to keep printing the board
		System.out.println();

		// loop through board rows - code taken from lab 4
		for (int row = 0; row < sizeBoard.length; row++) {
			// for each board row

			for (int col = 0; col < sizeBoard[row].length; col++) {
				// for each board column
				
				//The background board has already some pieces so these appear first
				if (board.hasBlock(row, col)) {
					System.out.print("x");
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
							System.out.print("x");
						} else {
							System.out.print(" ");
						}
					}

					// if the index is out of the specified col range
					else {
						System.out.print(" ");
					}
				}
				// if the index is out of the specified col and row range
				else {
					System.out.print(" ");
				}
			}
			// To switch line to keep printing the board
			System.out.println();
		}

		System.out.print("-----------");
	}

}
