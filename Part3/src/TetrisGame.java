/**
 * The TetrisGame class maintains a Tetris game.
 * 
 * @author Ioanna Deni
 * @version 10/16/2017
 * updated 10/23/2017
 *
 */
public class TetrisGame {

	// Positions a piece can move right and left total
	public static final int LEFTRIGHT = 10;

	// Positions a piece can move down
	public static final int DOWN = 18;
	
	//For the score
	private int lines;
	private int tetrises;

	private TetrisBoard tetrisBoard;

	/**
	 * Constructor of the game.
	 */
	public TetrisGame() {

		//The game is initiated and a new piece is added
		tetrisBoard = new TetrisBoard();

		tetrisBoard.addNewPiece();

	}

	/**
	 * Try to move the current piece with RIGHT, LEFT, DOWN, CW, CCW
	 * 
	 * @param moveType
	 */
	public void attemptMove(int moveType) {

		if (moveType == 1) {
			//firstly the move is attempted 
			tetrisBoard.moveToRight();
		} else if (moveType == 2) {
			//firstly the move is attempted
			tetrisBoard.moveToLeft();
		} else if (moveType == 3) {
			//firstly the move is attempted
			tetrisBoard.moveDown();
		} else if (moveType == 4) {
			//firstly the move is attempted
			tetrisBoard.rotateCW();
		} else if (moveType == 5) {
			//firstly the move is attempted
			tetrisBoard.rotateCCW();
		}
		//then we check if the game should end
		endRound();
		
		//here we store the number of lines
		int line = tetrisBoard.numberOfFormedLines();
				
		//if lines are 4 the tetris score is updated
		if (line == 4){
			tetrises = tetrises + 1;
			}
		//Line variable is also updated		
		lines = lines + line; 
	}

	/**
	 * Performed when a piece cannot move down anymore. Ends the round by
	 * checking for newly formed lines and adding a new piece.
	 */
	private void endRound() {

		boolean[][] board = tetrisBoard.getBlockMatrix();

		//for all the columns we check to see if the row 0 is filled because if it is this means than the game has reach
		//the very top of the board 
		for (int col = 0; col < LEFTRIGHT; col++) {
			if (board[0][col]) {
				//The program is terminated 
				System.exit(0);
			}
		}
	}

	/**
	 * Checks the number of filled lines
	 * 
	 * @return the numLines
	 */
	public int getNumLines() {
		return lines;
	}

	/**
	 * Returns a score of Tetrises 1 for every 4 lines completed at once
	 * 
	 * @return the numTetrises
	 */
	public int getNumTetrises() {	
		return tetrises;
	}

	/**
	 * Gets the board in which the game will happen
	 * 
	 * @return the tetrisBoard
	 */
	public TetrisBoard getTetrisBoard() {
		return tetrisBoard;

	}

}
