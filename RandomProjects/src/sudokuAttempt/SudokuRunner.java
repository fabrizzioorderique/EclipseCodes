package sudokuAttempt;
/**
 * This code is an attempt to make a sudoku solver
 * that takes in puzzles and solves them
 * @author fabri
 * @date 27 February 2019
 * @version 1.0
 * @status FAILED
 * 
 * Program Requirements:
 * 1) takes in user input to actually have a puzzle to solve
 * 2) solves it
 *
 * Game Requirements:
 * 1) numbers 1 - 9 must fill a 9x9 grid
 * 2) rows and cols must contain diff nums
 * 3) 3x3 boxes must contain diff nums
 * 
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class SudokuRunner {
	//class variables
	private static int[][] myTable;
	private static int[][] grid1, grid2, grid3, grid4, grid5, grid6, grid7, grid8, grid9; //left to right, top to bottom
	//method for printing the table at a current state
	private static void printTable(int[][] table) {
		for(int row = 0; row < table.length; row++) {
			for(int col = 0; col < table[row].length; col++) {
				System.out.print(table[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//user inputs each individual table value
	private static void userBuildTable() {
		JOptionPane.showMessageDialog(null,"Instructions: fill in the table from left to right, top to bottom.\nType quit if you want to leave");
		String input  = "";
		for(int row = 0; row < myTable.length; row++) {
			for(int col = 0; col < myTable[row].length; col++) {
				input = JOptionPane.showInputDialog("Value at row "+(row+1)+" col "+ (col +1)+":");
				if(input.equals("quit") || input.equals("Quit") || input.equals("QUIT")) {
					return;
				}else{
					myTable[row][col] = Integer.parseInt(input);
				}
			}
		}
		System.out.println("User Input Table:");
		printTable(myTable);
	}
	
	//End goal of program: to solve this random Sudoku puzzle
	private static void buildFinalTableToSolve(){
		System.out.println("Input Table:");
		myTable = new int[][]{
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
		printTable(myTable);
	}
	
	//Uses the basic table outline to test program
	private static void buildTestingTable(){
		System.out.println("Input Table:");
		myTable = new int[][]{
			{7,3,5,0,1,4,8,9,2},
			{8,4,2,0,7,3,5,0,1},
			{9,6,1,2,8,5,0,7,4},
			{2,8,6,3,4,0,1,5,7},
			{0,1,3,8,0,7,9,2,6},
			{5,7,9,1,2,6,4,3,8},
			{1,0,7,4,9,2,6,8,3},
			{6,9,0,7,3,8,2,0,5},
			{0,2,8,5,0,1,7,4,9},
		};
		printTable(myTable);
	}
	
	//resets the FINISHED basic table from png 2
	private static void resetBasicTable() {
		System.out.println("Basic Table:");
		myTable = new int[][]{
			{7,3,5,6,1,4,8,9,2},
			{8,4,2,9,7,3,5,6,1},
			{9,6,1,2,8,5,3,7,4},
			{2,8,6,3,4,9,1,5,7},
			{4,1,3,8,5,7,9,2,6},
			{5,7,9,1,2,6,4,3,8},
			{1,5,7,4,9,2,6,8,3},
			{6,9,4,7,3,8,2,1,5},
			{3,2,8,5,6,1,7,4,9},
		};
		printTable(myTable);
	}
	
	//fill in empty spaces in a row with one unknown
	private static void fillRows() {
		int rowSum = 0, zeroCount = 0;
		//iterates through all rows
		for(int row = 0; row < myTable.length; row++) {
			//gets sum for that row
			for(int col = 0; col < myTable[row].length; col++) {
				rowSum += myTable[row][col];
				if(myTable[row][col] == 0) {
						zeroCount++;
					}
				}
			//inserts missing value only if there is one missing value
			if(zeroCount == 0) {
				System.out.println("Row "+(row+1)+ " is done");
			}else if(zeroCount == 1) {
				for(int col = 0; col < myTable[row].length; col++) {
					if(myTable[row][col] == 0) {
						myTable[row][col] = 45 - rowSum;
						System.out.println("Row "+(row+1)+ " has been fixed");						
					}
				}
			}else{
				System.out.println("Row "+(row+1)+ " has " +zeroCount+ " unknowns");
			}
			//resets the rowSum and zeroCount value to be used for next row
			rowSum = 0;
			zeroCount = 0;
		}
	}
	
	//fill in empty spaces in a column with one unknown
	private static void fillCols() {
		int colSum = 0, zeroCount = 0;
		//iterates through all the columns
		for(int col = 0; col < myTable[0].length; col++) {
			//gets sum for that column
			for(int row = 0; row < myTable.length; row++) {
				colSum += myTable[row][col];
				if(myTable[row][col] == 0) {
					zeroCount++;
				}
			}
			//inserts missing value if only one unknown
			if(zeroCount == 0) {
				System.out.println("Column "+(col+1)+" is done");
			}else if(zeroCount == 1) {
				for(int row = 0; row < myTable.length; row++) {
					if(myTable[row][col] == 0) {
						myTable[row][col] = 45 - colSum;
						System.out.println("Column "+(col+1)+" has been fixed");
					}
				}
			}else {
				System.out.println("Column "+(col+1)+" has "+zeroCount+" unknowns");
			}
			//resets the colSum and zeroCount for the next column
			colSum = 0;
			zeroCount = 0;
			}
		}
	
	//method for filling in singular values more than once
	private static void fillRowsAndCols(String side, int times) {
		if(side.equals("row")) {
			for(int i = 0; i < times; i++) {
				fillRows();
				printTable(myTable);
				fillCols();
				printTable(myTable);
			}
		}else if(side.equals("col")) {
			for(int i = 0; i < times; i++) {
				fillCols();
				printTable(myTable);
				fillRows();
				printTable(myTable);
			}
		}else {
			System.out.println("input error on fillRowsAndCols method");
		}
	}
	
	//fills the individual 3x3 grids that make up the bigger puzzle
	private static void buildGrids() {
		grid1 = grid2 = grid3 = grid4 = grid5 = grid6 = grid7 = grid8 = grid9 = new int[3][3];
		for(int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				grid1[row][col] = myTable[row][col];
			}
		}
		for(int row = 0; row < 3; row++) {
			for (int col = 3; col < 6; col++) {
				grid2[row][col] = myTable[row][col];
			}
		}
		for(int row = 0; row < 3; row++) {
			for (int col = 6; col < 9; col++) {
				grid3[row][col] = myTable[row][col];
			}
		}
		for(int row = 3; row < 6; row++) {
			for (int col = 0; col < 3; col++) {
				grid4[row][col] = myTable[row][col];
			}
		}
		for(int row = 3; row < 6; row++) {
			for (int col = 3; col < 6; col++) {
				grid5[row][col] = myTable[row][col];
			}
		}
		for(int row = 3; row < 6; row++) {
			for (int col = 6; col < 9; col++) {
				grid6[row][col] = myTable[row][col];
			}
		}
		for(int row = 6; row < 9; row++) {
			for (int col = 0; col < 3; col++) {
				grid7[row][col] = myTable[row][col];
			}
		}
		for(int row = 6; row < 9; row++) {
			for (int col = 3; col < 6; col++) {
				grid8[row][col] = myTable[row][col];
			}
		}
		for(int row = 6; row < 9; row++) {
			for (int col = 6; col < 9; col++) {
				grid9[row][col] = myTable[row][col];
			}
		}
	}
	
	//fills in 3x3 grids with only one unknown
	private static void fillGrids() {
		int gridSum = 0, zeroCount = 0;
		for(int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				gridSum += myTable[row][col];
				if(myTable[row][col] == 0) {
					zeroCount++;
				}
			}
			if(zeroCount == 0) {
				System.out.println("Grid1 is done");
			}else if(zeroCount == 1) {
				for(int col = 0; col < 3; col++) {
					if(myTable[row][col] == 0) {
						myTable[row][col] = 45 - gridSum;
						System.out.println("Grid1 has been fixed");						
					}
				}
			}else{
				System.out.println("Grid1 has " +zeroCount+ " unknowns");
			}
			gridSum = zeroCount = 0;
		}
		for(int row = 0; row < 3; row++) {
			for (int col = 3; col < 6; col++) {
				gridSum += myTable[row][col];
				if(myTable[row][col] == 0) {
					zeroCount++;
				}
			}
			if(zeroCount == 0) {
				System.out.println("Grid2 is done");
			}else if(zeroCount == 1) {
				for(int col = 3; col < 6; col++) {
					if(myTable[row][col] == 0) {
						myTable[row][col] = 45 - gridSum;
						System.out.println("Grid2 has been fixed");						
					}
				}
			}else{
				System.out.println("Grid2 has " +zeroCount+ " unknowns");
			}
			gridSum = zeroCount = 0;
		}
		for(int row = 0; row < 3; row++) {
			for (int col = 6; col < 9; col++) {
				gridSum += myTable[row][col];
				if(myTable[row][col] == 0) {
					zeroCount++;
				}
			}
			if(zeroCount == 0) {
				System.out.println("Grid3 is done");
			}else if(zeroCount == 1) {
				for(int col = 6; col < 9; col++) {
					if(myTable[row][col] == 0) {
						myTable[row][col] = 45 - gridSum;
						System.out.println("Grid3 has been fixed");						
					}
				}
			}else{
				System.out.println("Grid3 has " +zeroCount+ " unknowns");
			}
			gridSum = zeroCount = 0;
		}
		for(int row = 3; row < 6; row++) {
			for (int col = 0; col < 3; col++) {
				gridSum += myTable[row][col];
				if(myTable[row][col] == 0) {
					zeroCount++;
				}
			}
			if(zeroCount == 0) {
				System.out.println("Grid4 is done");
			}else if(zeroCount == 1) {
				for(int col = 0; col < 3; col++) {
					if(myTable[row][col] == 0) {
						myTable[row][col] = 45 - gridSum;
						System.out.println("Grid4 has been fixed");						
					}
				}
			}else{
				System.out.println("Grid4 has " +zeroCount+ " unknowns");
			}
			gridSum = zeroCount = 0;
		}
		for(int row = 3; row < 6; row++) {
			for (int col = 3; col < 6; col++) {
				gridSum += myTable[row][col];
				if(myTable[row][col] == 0) {
					zeroCount++;
				}
			}
			if(zeroCount == 0) {
				System.out.println("Grid5 is done");
			}else if(zeroCount == 1) {
				for(int col = 3; col < 6; col++) {
					if(myTable[row][col] == 0) {
						myTable[row][col] = 45 - gridSum;
						System.out.println("Grid5 has been fixed");						
					}
				}
			}else{
				System.out.println("Grid5 has " +zeroCount+ " unknowns");
			}
			gridSum = zeroCount = 0;
		}
		for(int row = 3; row < 6; row++) {
			for (int col = 6; col < 9; col++) {
				gridSum += myTable[row][col];
				if(myTable[row][col] == 0) {
					zeroCount++;
				}
			}
			if(zeroCount == 0) {
				System.out.println("Grid6 is done");
			}else if(zeroCount == 1) {
				for(int col = 6; col < 9; col++) {
					if(myTable[row][col] == 0) {
						myTable[row][col] = 45 - gridSum;
						System.out.println("Grid6 has been fixed");						
					}
				}
			}else{
				System.out.println("Grid6 has " +zeroCount+ " unknowns");
			}
			gridSum = zeroCount = 0;
		}
		for(int row = 6; row < 9; row++) {
			for (int col = 0; col < 3; col++) {
				gridSum += myTable[row][col];
				if(myTable[row][col] == 0) {
					zeroCount++;
				}
			}
			if(zeroCount == 0) {
				System.out.println("Grid7 is done");
			}else if(zeroCount == 1) {
				for(int col = 0; col < 3; col++) {
					if(myTable[row][col] == 0) {
						myTable[row][col] = 45 - gridSum;
						System.out.println("Grid7 has been fixed");						
					}
				}
			}else{
				System.out.println("Grid7 has " +zeroCount+ " unknowns");
			}
			gridSum = zeroCount = 0;
		}
		for(int row = 6; row < 9; row++) {
			for (int col = 3; col < 6; col++) {
				gridSum += myTable[row][col];
				if(myTable[row][col] == 0) {
					zeroCount++;
				}
			}
			if(zeroCount == 0) {
				System.out.println("Grid8 is done");
			}else if(zeroCount == 1) {
				for(int col = 3; col < 6; col++) {
					if(myTable[row][col] == 0) {
						myTable[row][col] = 45 - gridSum;
						System.out.println("Grid8 has been fixed");						
					}
				}
			}else{
				System.out.println("Grid8 has " +zeroCount+ " unknowns");
			}
			gridSum = zeroCount = 0;
		}
		for(int row = 6; row < 9; row++) {
			for (int col = 6; col < 9; col++) {
				gridSum += myTable[row][col];
				if(myTable[row][col] == 0) {
					zeroCount++;
				}
			}
			if(zeroCount == 0) {
				System.out.println("Grid9 is done");
			}else if(zeroCount == 1) {
				for(int col = 6; col < 9; col++) {
					if(myTable[row][col] == 0) {
						myTable[row][col] = 45 - gridSum;
						System.out.println("Grid9 has been fixed");						
					}
				}
			}else{
				System.out.println("Grid9 has " +zeroCount+ " unknowns");
			}
			gridSum = zeroCount = 0;
		}
	}
	
	private static void fillAll(int times) {
		for(int i = 0; i < times; i++) {
			fillRowsAndCols("row",1);
			fillGrids();
			fillRowsAndCols("col",1);
		}
	}
	//main method
	public static void main(String[] args) {
		buildTestingTable();
		fillGrids();
		printTable(myTable);
	}
	
}