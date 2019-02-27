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
 * 2) rows and cols must contained diff nums
 * 3) 3x3 boxes must contain diff nums
 */
import javax.swing.JOptionPane;
public class SudokuRunner {
	//class variables
	private static int[][] myTable;
	
	//method for printing the table at a current time
	private static void printTable(int[][] table) {
		for(int row = 0; row < table.length; row++) {
			for(int col = 0; col < table[row].length; col++) {
				System.out.print(table[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	//user inputs each individual table value
	private static void userFillTable() {
		JOptionPane.showMessageDialog(null,"Instructions: fill in the table from left to right, top to bottom.\nType exit if you want to leave");
		for(int row = 0; row < myTable.length; row++) {
			for(int col = 0; col < myTable[row].length; col++) {
				String input = JOptionPane.showInputDialog("Value at row "+(row+1)+" col "+ (col +1)+":");
				myTable[row][col] = Integer.parseInt(input);
			}
		}
	}
	
	//main method
	public static void main(String[] args) {
		myTable = new int[9][9];
		printTable(myTable);
		userFillTable();
		printTable(myTable);
		//trying to make a method for initializing table elements
		
	}
	
}
