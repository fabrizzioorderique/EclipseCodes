package sudokuAttempt;
/**
 * CSP Sudoku
 * 
 * This is an attempt to finish the final Sudoku puzzle
 * solver for the CSP Explore Performance Task
 * 
 * @author fabri
 * @date 14 March 2019
 */
public class CspSudoku {
	//This is the board that is actually going to get solved:
	private static int[][] board = new int[9][9];
	
	//iteration counter (just for user to see)
	private static int iterNum;
	
	//This is just a stored table that can be set to board
	private static int[][] testTable = new int[][]{
		{1,0,6,0,0,2,3,0,0},
		{0,5,0,0,0,6,0,9,1},
		{0,0,9,5,0,1,4,6,2},
		{0,3,7,9,0,5,0,0,0},
		{5,8,1,0,2,7,9,0,0},
		{0,0,0,4,0,8,1,5,7},
		{0,0,0,2,6,0,5,4,0},
		{0,0,4,1,5,0,6,0,9},
		{9,0,0,8,7,4,2,1,0},
	};
	
	// Just in case i need to print the table out at a certain point
	private static void printBoard() {
		System.out.println("Board to Solve:");
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void makeBoard(int[][] table) {
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				board[row][col] = table[row][col];
			}
		}
	}
	
	//Checks is a number in the a row
	private static boolean isNotInRow(int num, int row) {
		for (int i = 0; i < board[row].length; i++) {
			if(board[row][i] == num) {
				return false;
			}
		}
		return true;
	}
	
	//checks if a number is in a column
	private static boolean isNotInCol(int num, int col) {
		for (int i = 0; i < board.length; i++) {
			if(board[i][col] == num) {
				return false;
			}
		}
		return true;
	}
	
	//checks if number is in its 3x3 sub board
	private static boolean isNotInSubBoard(int num, int row, int col) {
		//sets the starting row and column of the sub board
		int startR =  row - (row%3);
		int startC = col - (col%3);
		//iterates through the sub board searching for the number
		for (int subRow = startR; subRow <= startR + 2; subRow++) {
			for (int subCol = startC; subCol <= startC + 2; subCol++) {
				if(board[subRow][subCol] == num) {
					return false;
				}
			}
		}
		return true;
	}

	//backtracking solving method
	private static void solveBoard() {
		//iterates through the entire board
		for (int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				//finds an empty cell
				if(board[row][col] == 0) {
					//test all numbers, 1 through 9
					for(int n = 1; n <=9; n++) {
						//checks to see if the number meets the constraints and places the number in the cell
						if(isNotInRow(n, row) && isNotInCol(n, col) && isNotInSubBoard(n, row, col)) {
							board[row][col] = n;
							//now starts the process over again
							solveBoard();
						}
					}
				}
			}
		}
		//adds one for every iteration
		iterNum++;
	}
	
	public static void main(String[] args) {
		iterNum = 0;
		makeBoard(testTable);
		printBoard();
		solveBoard();
		printBoard();
		System.out.println("Number of iterations: "+ iterNum);
	}
	
}
