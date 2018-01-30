/**
 * The TetrisBoard class represents a board on which the game is played.
 * It maintains grid of specified length and width and the symbols of each piece on the board 
 * both the fallen and the current piece updated every time the user gives a new key input.
 * 
 * @author Ioanna Deni
 * @version 10/16/2017
 *
 */
public class TetrisBoard {
	
	//The background board that holds the filled stable positions where no new block can be added
	private boolean [][] blockMatrix;
	
	private TetrisPiece currentPiece;
	
	//position of current (falling) piece currentPieceGridPosition[0] 
	//stores the current row currentPieceGridPosition[1] stores the current column
	private int[] currentPieceGridPosition;
	
	//the columns of the final board
	public static final int colsNum = 10;
	
	//the rows of the final board
	public static final int rowNum = 18;
	
	
	/**
	 * Constructor sets up the board based on the given col and row values
	 */
	public TetrisBoard(){
		
		//A new board is initiated - this happens once for every game or round
		initBoard();
	}
	
	/**
	 * Initialize an int array of length two to keep track of the grid position of the current piece (row, col)
	 */
	private void initCurrentGP(){
		
		currentPieceGridPosition = new int[2];
		
		//Here we give the coordinates of the point that the piece will appear initial at the addPiece method
		currentPieceGridPosition[0] = 0;
		currentPieceGridPosition[1] = 3;
			
	}
	
	/**
	 * Initialize the 2D board array to have all false values
	 */
	private void initBoard(){
			
		//Here we create the matrix of the board of tetris
		blockMatrix = new boolean[rowNum][colsNum];
		
		//we set all values false in the beginning so no squares are drawn
		for (int row=0; row<blockMatrix.length; row++){
			
			//All the positions are set to false because our board is empty in the beginning
			for (int col=0; col<blockMatrix[row].length; col++){
				blockMatrix[row][col] = false;}}
		}
	
	/**
	 * Update the board array to reflect the newly landed piece's filled squares 
	 * using the currentGridPosition values and the currentPiece's rotation value.
	 */
	public void landPiece(){
			//loop through board rows
			for (int row=0; row< blockMatrix.length; row++) {
				// for each board row 
				for (int col=0; col < blockMatrix[row].length; col++){
					//for each board column
					
					//if the indexes are inside the places we want to place the piece then we turn this places to true
					if (row>=currentPieceGridPosition[0]&& row<4+currentPieceGridPosition[0]){
						
						//as long as the columns are inside the limits of the grid of blocks of the piece 
						if (col>=currentPieceGridPosition[1] && col<4+currentPieceGridPosition[1]){
							
							//if the are we check the grid
							if (currentPiece.isFilled(currentPiece.getPieceRotation(), row-currentPieceGridPosition[0], col-currentPieceGridPosition[1])){
								blockMatrix[row][col] = true;
								}
						}}}}
			//And we set another piece to start falling
			addNewPiece();
			}
	
	/**
	 * Method for moving the piece one unit to the left after checking that the movement to the left is valid.
	 * @return true if valid move was performed
	 */
	public boolean moveToLeft(){
		
		//First we check if the move is valid
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1]-1)){
			
			//then we change the current position to the new position
			currentPieceGridPosition[1]= currentPieceGridPosition[1]-1;
			return true;}
		else{
			return false;}
		
	}
	
	/**
	 * Method for moving the piece one unit to the right after checking that the movement to the right is valid.
	 * @return true if valid move was performed
	 */
	public boolean moveToRight(){
		//First we check if the move is valid
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1]+1)){
			
			//then we change the current position to the new position
			currentPieceGridPosition[1]= currentPieceGridPosition[1]+1;
			return true;}
		else{
			return false;}
		
	}
	
	/**
	 * Method for moving the piece one unit down after checking that the movement down is valid.
	 * @return true if valid move was performed
	 */
	public boolean moveDown(){
		//First we check if the move is valid
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0]+1, currentPieceGridPosition[1])){

			//then we change the current position to the new position
			currentPieceGridPosition[0]= currentPieceGridPosition[0]+1;
			return true;}
		else{
			landPiece();
			return false;}
		
	}
	
	/**
	 * Method for landing the piece on the bottom.
	 * @return true if valid move was performed
	 */
	public boolean land(){
		
		//This local variable holds the blocks that exist in each column for a row - it is updated for every row
		int numOfRows= 0;
		
		//first we check if the board is empty in the specified col or if it's not we check how many pieces it has 
		for (int row=0; row<rowNum; row++){
			
			//we only care about the rows because we want to set it at the bottom not on the left or right so col is constant
			if (blockMatrix[row][currentPieceGridPosition[1]]){
				
				//the instance is updated
				numOfRows = numOfRows +1;
			}
		}	
		
		//the position we want to put the piece is on the bottom 
		//so the height minus the filled positions of the board
		int newPosition = rowNum - numOfRows - getNumRows();
		
		//First we check if the move is valid
		if (validMove(currentPiece, currentPiece.getPieceRotation(), newPosition, currentPieceGridPosition[1])){
			
			//then we change the current position to the new position
			currentPieceGridPosition[0]= newPosition;
			
			//Since there is not a possibility to move the piece down more we land the piece here
			landPiece();
			return true;
			}
		else{
			return false;}
		
	}
	
	/**
	 * Method for rotating the piece by 90 degrees clockwise after checking that the movement is valid.
	 * @return true if valid move was performed
	 */
	public boolean rotateCW(){
		//First we check if the move is valid
		if (validMove(currentPiece, currentPiece.getPieceRotation()+1, currentPieceGridPosition[0], currentPieceGridPosition[1])){
			
			//then we get the rotation of the piece
			currentPiece.rotateCW();
			return true;}
		else{
			return false;}
		
	}
	
	/**
	 * Method for rotating the piece by 90 degrees anti-clockwise after checking that the movement is valid.
	 * @return true if valid move was performed
	 */
	public boolean rotateCCW(){
		//First we check if the move is valid
		if (validMove(currentPiece, currentPiece.getPieceRotation()-1, currentPieceGridPosition[0], currentPieceGridPosition[1])){
			
			//then we get the rotation of the piece
			currentPiece.rotateCCW();
			return true;}
		else{
			return false;}
		
	}
	
	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) 
	 * would cause a collision (i.e., if there would be a block on an already-filled grid square).
	 * 
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return true if there would be a collision
	 */
	private boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol){
		
		//This is the length of the array of any TetrisPiece
		int length = 4;
		
		//loop through board rows
		for (int row=0; row < length; row++) {
			// for each board row 
			for (int col=0; col < length; col++){
				//for each board column
				//if the are we check the grid
				if (currentPiece.isFilled(currentPiece.getPieceRotation(), row, col)==true && blockMatrix[row+gridRow][col+gridCol]==true){
					//if there is a block in the position that we are trying to move then collision is true
					return true;}}}
		return false;
		
	}
	
	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) 
	 * would cause an out of bounds condition (i.e., if there would be a block falling off the board).
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return true if there would be a bounding error
	 */
	private boolean detectOutOfBounds(TetrisPiece piece, int rot, int gridRow, int gridCol){
		
		//First we check if this position is bigger than the number of rows a piece can move 
		//which is the length of the board minus the rows of the grid of blocks that has the piece 
		if (gridRow > rowNum - getNumRows() || gridCol> colsNum - getNumCols() || gridCol < 0){
			return true;}
		return false;
		
	}

	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) is a valid move.
	 * There are no collisions or bounding restrictions 
	 * 
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return true if no collision or bounding error
	 */
	private boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol){
		
		if (detectOutOfBounds(piece, rot, gridRow, gridCol) || detectCollision(piece, rot, gridRow, gridCol)){
			return false;
		}
		return true;
		
	}
	
	/**
	 * Check if there is a block in the row and column.
	 * 
	 * @param row
	 * @param col
	 * @return true if there is a block
	 */
	public boolean hasBlock(int row, int col){
		
		//if the position is true then a block does exist in this position
		if (blockMatrix[row][col]){
			return true;}
		return false;
	}
	
	/**
	 * Add a new random Tetris piece to the board at grid position (0, 3).
	 */
	public void addNewPiece(){
		
		//We initiate our methods to create a board and a position on the board to place the new piece
		initCurrentGP();
		
		//Here we generate a new piece by assigning them to numbers and generating a random number
		int random = (int)(Math.random()*7);
		
		if (random==0){
			
			currentPiece = new TetrisO();}
		else if (random==1){
			
			currentPiece = new TetrisI();}
		else if (random==2){
			
			currentPiece = new TetrisL();}
		else if (random==3){
			
			currentPiece = new TetrisJ();}
		else if (random==4){
			
			currentPiece = new TetrisS();}
		else if (random==5){
			
			currentPiece = new TetrisZ();}
		else if (random==6){
			
			currentPiece = new TetrisT();}
				
	}
	
	/**
	 * Detect and remove any lines formed.
	 * 
	 * @return the total number found.
	 */
	public int numberOfFormedLines(){
		
		//first we set a counter that counts the number of lines to be removed
		int linesRemoved = 0;
		
		//we check all rows for potential filled line
		for (int row = 0; row < rowNum; row++){
			if (fullLine(row)){
				
				//If there is a filled line the line is removed and the line count is increased
				removeLine(row);
				linesRemoved = linesRemoved+1;
			}
		}
		return linesRemoved;
		
	}
	
	/**
	 * Check if there is a full line at the row.
	 * 
	 * @param row
	 * @return true if there is a full line at the given row
	 */
	private boolean fullLine(int row){
		
		//this instance is created because like this we get to count the columns of the row that are true
		int line = 0;
		
		//For all the cols in the row of the parameter
		for (int col = 0; col < colsNum; col++) {
			if (blockMatrix[row][col]) {
				line = line +1;
			}}
		//if the line is full then the instance line will have the same value as the width of the board 
		if (line == colsNum ){
			return true;
		}
		return false;
	}
	
	/**
	 * Remove the line at row in the model and shift all values for rows at a lower index to be at one row higher. 
	 * Makes row 0 full of false values.
	 * 
	 * @param row
	 */
	private void removeLine(int row){
		//For all the rows before the row that just disappeared and down to the zero row
		for (int rows = row; rows > 0; rows--) {
			//and for all the col
			for (int col = 0; col < colsNum; col++) {
				blockMatrix[rows][col] = blockMatrix[rows-1][col];
			}
		}
		
		
		
	}
	
	/**
	 * Checks where the the grid of blocks is full with blocks and where it doesn't have any  
	 * 
	 * @return the block matrix filled with true or false values 
	 */
	public boolean[][] getBlockMatrix(){
		return blockMatrix;
	}
	
	/**
	 * The method that gets the grid of blocks of the current falling piece
	 * 
	 * @return the currentPiece
	 */
	public TetrisPiece getCurrentPiece(){
		return currentPiece;
	}
	
	/**
	 * The method that gets the grid of blocks position of the current falling piece on the board grid
	 * 
	 * @return the currentPieceGridPosition
	 */
	public int[] getCurrentPieceGridPosition(){
		return currentPieceGridPosition;
	}
	
	/**
	 * The method to returns number of filled cols of a specific grid of blocks
	 * 
	 * @return the numCols in the block matrix
	 */
	public int getNumCols(){
		
		int numCol = 0;
		
		//This is the length of the array of any TetrisPiece
		int length = 4; 
		
		//loop through board rows
		for (int col =0; col < length; col++) {
			// for each board row 
			for (int row=0; row < length; row++){
			//for each board column
				//if the are we check the grid
				if (currentPiece.isFilled(currentPiece.getPieceRotation(), row, col)){
					numCol = col + 1;}
		}}
		return numCol;
	}
	
	/**
	 * The method to returns of filled rows of a specific grid of blocks
	 * 
	 * @return the numRows in the block matrix
	 */
	public int getNumRows(){
		
		int numRow = 0;
		
		//This is the length of the array of any TetrisPiece
		int length = 4; 
				
		//loop through board rows
		for (int row=0; row < length; row++) {
			// for each board row 
			for (int col=0; col < length; col++){
				//for each board column
				
				//if the are we check the grid
				if (currentPiece.isFilled(currentPiece.getPieceRotation(), row, col)){
							numRow = row +1;}
				}}
				return numRow;
	}
}
