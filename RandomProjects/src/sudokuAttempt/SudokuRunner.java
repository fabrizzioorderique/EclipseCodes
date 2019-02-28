package sudokuAttempt;
/**
 * This code is an attempt to make a sudoku solver
 * that takes in puzzles and solves them
 * @author fabri
 * @date 27 February 2019
 * 
 * Program Requirements:
 * 1) takes in user input to actually have a puzzle to solve
 * 2) solves it
 *
 * Game Requirements:
 * 1) numbers 1 - 9 must fill a 9x9 grid
 * 2) rows and cols must contain diff nums
 * 3) 3x3 boxes must contain diff nums
 */
import javax.swing.JOptionPane;
public class SudokuRunner {
	//class variables
	private static int[][] myTable;
	
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
	private static void userFillTable() {
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
	}
	
	//builds the simple sudoku puzzle thats saved with this src code
	private static void buildBasicTable(){
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
	}
	
	//checks rows and cols for one empty spot and fills it
	private static void finishRowCol() {
	}
	
	//main method
	public static void main(String[] args) {
		myTable = new int[9][9];
		printTable(myTable);
		userFillTable();
		printTable(myTable);
		buildBasicTable();
		printTable(myTable);
	}
	
}
