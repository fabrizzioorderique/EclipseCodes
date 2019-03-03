package sudokuAttempt;
/**
 * This code is an attempt to make a sudoku solver
 * that takes in puzzles and solves them
 * @author fabri
 * @date 2 March 2019
 * @version 1.1
 * @status 
 */
import javax.swing.JOptionPane;
public class Sudoku {
	
	private static int[][] grid = new int[9][9];

	public static int[][] myBoard = { 
			{ 9, 0, 0, 1, 0, 0, 0, 0, 5 }, 
			{ 0, 0, 5, 0, 9, 0, 2, 0, 1 },
			{ 0, 0, 0, 0, 4, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 8, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 0, 0, 0, 9 }, 
			{ 2, 0, 0, 3, 0, 0, 0, 0, 6 }, 
			{ 0, 0, 0, 2, 0, 0, 9, 0, 0 },
			{ 0, 0, 1, 0, 0, 4, 5, 7, 0 }, 
			};
	
	public static int[][] finalTable = new int[][]{
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
	
	private static void buildGrid(int[][] table) {
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				grid[row][col] = table[row][col];
			}
		}
	}
	//prints the grid
	private static void printGrid(int[][] table) {
		for(int row = 0; row < table.length; row++) {
			for(int col = 0; col < table[row].length; col++) {
				System.out.print(table[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// we check if a possible number is already in a row
	private static boolean checkRow(int row, int number) {
		for (int i = 0; i < 9; i++)
			if (grid[row][i] == number)
				return true;

		return false;
	}

	// we check if a possible number is already in a column
	private static boolean checkCol(int col, int number) {
		for (int i = 0; i < 9; i++)
			if (grid[i][col] == number)
				return true;

		return false;
	}

	// we check if a possible number is in its 3x3 box
	private static boolean checkBox(int row, int col, int number) {
		int r = row - row % 3;
		int c = col - col % 3;

		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (grid[i][j] == number)
					return true;

		return false;
	}

	// combined method to check if a number possible to a row,col position is ok
	private static boolean isOk(int row, int col, int number) {
		return !checkRow(row, number) && !checkCol(col, number) && !checkBox(row, col, number);
	}

	// Solve method. We will use a recursive BackTracking algorithm.
	// we will see better approaches in next video :)
	public static boolean solve() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				// we search an empty cell
				if (grid[row][col] == 0) {
					// we try possible numbers
					for (int number = 1; number <= 9; number++) {
						if (isOk(row, col, number)) {
							// number ok. it respects sudoku constraints
							grid[row][col] = number;

							if (solve()) { // we start backtracking recursively
								return true;
							} else { // if not a solution, we empty the cell and we continue
								grid[row][col] = 0;
							}
						}
					}

					return false; // we return false
				}
			}
		}

		return true; // sudoku solved
	}

	public static void main(String[] args) {
		buildGrid(finalTable);
		printGrid(grid);
		if (solve()) {
			System.out.println("Solution:");
			printGrid(grid);
		} else {
			System.out.println("Unsolvable");
		}
	}
}