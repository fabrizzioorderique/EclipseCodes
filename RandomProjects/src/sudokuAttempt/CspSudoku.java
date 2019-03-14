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
	//This is the GRID that is actually going to get solved:
	private static int[][] grid = new int[9][9];
	
	//This is just a stored table that can be set to grid
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
	private static void printBoard(int[][] table) {
		for(int row = 0; row < table.length; row++) {
			for(int col = 0; col < table[row].length; col++) {
				System.out.print(table[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void buildBoard(int[][] table) {
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				grid[row][col] = table[row][col];
			}
		}
	}
	
	//Checks is a number in the a row
	private static boolean isInRow(int row, int num) {
		for (int i = 0; i < grid[row].length; i++) {
			if(grid[row][i] == num) {
				return true;
			}
		}
		return false;
	}
	
	//checks if a number is in a column
	private static boolean isInCol(int col, int num) {
		for (int i = 0; i < grid.length; i++) {
			if(grid[i][col] == num) {
				return true;
			}
		}
		return false;
	}
	
	//checks if number is in its 3x3 subGrid
	private static boolean isInSubgrid(int row, int col, int num) {
		int r = row - (row%3);
		int c = col - (col%3);
		for (int subRow = r; subRow < r + 3; subRow++) {
			for (int subCol = c; subCol < c + 3; subCol++) {
				if(grid[subRow][subCol] == num) {
					return true;
				}
			}
		}
		return false;
	}
	
	//checks to see if all conditions have been met
	private static boolean thisNumWorks(int row, int col, int num) {
		return (!isInRow(row, num) && !isInCol(col, num) && !isInSubgrid(row, col, num));
	}
}
