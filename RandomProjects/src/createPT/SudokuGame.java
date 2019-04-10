/**
 * Sudoku Game source code
 * This code is my attempt to make a Sudoku game which meets the following criteria:
 * 1) User chooses difficulty of board
 * 2) Given that, the program makes a random board of that difficulty
 * 3) User attempts to solve it
 * 		a) may use a "autoChecker" feature that helps avoid mistakes
 * 4) Checks to see if the board has been solved --> congratulates the player
 * 
 * @author Piero Orderique
 * @date 28 March 2019
 * @version 1.0
 */
package createPT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SudokuGame extends JFrame implements ActionListener{

	//actual board that will be solved and a declaration
	private static int[][] board = new int[9][9];
	
	//Easy Boards
	private int[][] easyTable1 = new int[][]{
		{0,0,5,6,1,4,8,9,2},
		{8,4,2,9,7,3,5,6,1},
		{9,6,1,2,8,5,3,7,4},
		{2,8,6,3,4,9,1,5,7},
		{4,1,3,8,5,7,9,2,6},
		{5,7,9,1,2,6,4,3,8},
		{1,5,7,4,9,2,6,8,3},
		{6,9,4,7,3,8,2,1,5},
		{3,2,8,5,6,1,7,4,9},
	};
	private int[][] easyTable2 = new int[][] {
		{9,5,7,6,1,3,2,8,4},
		{4,8,3,2,5,7,1,9,6},
		{6,1,2,8,4,9,5,3,7},
		{1,7,8,3,6,4,9,5,2},
		{5,2,4,9,7,1,3,6,8},
		{3,6,9,5,2,8,7,4,1},
		{8,4,5,7,9,2,6,1,3},
		{2,9,1,4,3,6,8,7,5},
		{0,0,6,1,8,5,4,2,9},
	};
	//Medium Boards
	private int[][] mediumTable1 = new int[][]{
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
	private int[][] mediumTable2 = new int[][]{
		{0,5,7,6,1,3,0,8,4},
		{4,8,3,2,5,7,1,0,6},
		{6,1,2,8,0,9,5,3,7},
		{0,7,8,3,6,4,9,0,2},
		{5,2,4,0,7,1,3,6,8},
		{3,6,9,5,0,8,7,0,1},
		{0,4,5,0,9,2,6,1,3},
		{2,9,1,4,3,6,0,7,5},
		{0,3,0,1,8,5,0,2,9},
	};
	//Hard Boards
	private int[][] hardTable1 = new int[][]{
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
	private int[][] hardTable2 = new int[][]{
		{9,5,0,6,1,0,2,8,4},
		{4,8,0,2,5,0,1,9,6},
		{6,1,2,8,4,9,5,0,0},
		{1,0,8,0,6,4,9,5,2},
		{5,2,4,9,0,1,0,6,8},
		{0,6,9,5,2,8,0,4,1},
		{8,4,5,0,9,2,6,1,0},
		{2,9,1,4,0,6,8,0,5},
		{0,0,6,1,8,5,4,2,9},
	};
	
	String[] difficulties = {"easy","medium","hard"};
	JComboBox diffSelection = new JComboBox(difficulties);
	JLabel text = new JLabel();
	Random r = new Random();
	
	//Constructor for when I make a JComboBox
	public SudokuGame() {
		setLayout(new FlowLayout());
		setSize(300,130);
		setTitle("Choose Difficulty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		diffSelection.setSelectedIndex(1);			//first option is auto selected
		diffSelection.addActionListener(this);		//will help me record the user's selection
		add(diffSelection);							//adds the combobox to the frame
		add(text);									//adds the label
	}
	
	//This allows me to "read" what was selected from the combo box
	@Override
	public void actionPerformed(ActionEvent e) {
		//checks to see if the event is from diffSelection
		if(e.getSource() == diffSelection) {
			JComboBox tempBox = (JComboBox)e.getSource();	//copies diffSelection to a new comboBox
			String selected = (String)tempBox.getSelectedItem();	//sees which item is selected
			//switch is used to 
			switch(selected) {
			case "easy": 
				text.setText("Selected Difficulty: EASY");
				makeRandBoard("easy");
				break;
			case "medium":
				text.setText("Selected Difficulty: MEDIUM");
				makeRandBoard("medium");
				break;
			case "hard":
				text.setText("Selected Difficulty: HARD");
				makeRandBoard("hard");
				break;
			default: 
				text.setText("Error");
			}
			haveUserSolveIt();
		}	
	}
	
	//Has the user fill out the table with the option to quit whenever
	private void haveUserSolveIt() {
		String input;
		while(true) {
			input = JOptionPane.showInputDialog("Type quit to exit, or just hit enter to continue");
			if(input.equals("quit") || input.equals("Quit") || input.equals("QUIT")) {
				JOptionPane.showMessageDialog(null, "Don't give up! Play again!");
				return;
			}
			int row = Integer.parseInt(JOptionPane.showInputDialog("Enter row"));
			int col = Integer.parseInt(JOptionPane.showInputDialog("Enter col"));
			//Only asks for number to fill the cell with if it is empty 
			if(board[row - 1][col - 1] != 0) {
				JOptionPane.showMessageDialog(null, "There is already a number here");
			}else {
				int num = Integer.parseInt(JOptionPane.showInputDialog("Enter number to fill in with"));
				if(num > 9 || num < 1) {
					JOptionPane.showMessageDialog(null, "Error: Number must be within 1 and 9 inclusive");
				}else {
					board[row - 1][col - 1] = num;
					printBoard();
				}
			}
			if(!zerosLeft()) {
				break;
			}
		}
		endProgram();
	}
	
	//Checks for any empty cells left in board
	private boolean zerosLeft() {
		for(int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == 0) return true;
			}
		}
		return false;
	}
	
	//checks to for duplicates in row
	private boolean rowOk(int num, int row) {
		int duplicate = 0;
		for (int i = 0; i < board[row].length; i++) {
			if(board[row][i] == num) {
				duplicate++;
				if(duplicate > 1) return false;
			}
		}
		return true;
	}

	//checks for duplicates in column
	private boolean colOk(int num, int col) {
		int duplicate = 0;
		for (int i = 0; i < board.length; i++) {
			if(board[i][col] == num) {
				duplicate++;
				if(duplicate > 1) return false;
			}
		}
		return true;
	}
	
	//checks for duplicates in 3x3 sub grid
	private boolean subGridOk(int num, int row, int col){
		int duplicate = 0;
		//sets the starting row and column of the sub board
		int startR =  row - (row%3);
		int startC = col - (col%3);
		//iterates through the sub board searching for the number
			for (int subRow = startR; subRow <= startR + 2; subRow++) {
				for (int subCol = startC; subCol <= startC + 2; subCol++) {
					if(board[subRow][subCol] == num) {
						duplicate++;
						if(duplicate > 1) return false;
					}
				}
			}
			return true;
	}
	
	//Checks to see if number fits the Sudoku criteria
	private boolean numWorks(int num, int row, int col) {
		if(rowOk(num,row) && colOk(num,col) && subGridOk(num,row,col)) {
			return true;
		}else {
			return false;
		}
	}
	
	//checks to see if the completed board is a solution
	private boolean isSolved() {
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				int num = board[row][col];
				if(!numWorks(num,row,col)) {
					return false;
				}
			}
		}
		return true;
	}

	//Checks isSolved in order to end the program
	private void endProgram() {
		if(!isSolved()) {
			JOptionPane.showMessageDialog(null, "Not quite. You'll get it next time!");
		}else {
			JOptionPane.showMessageDialog(null, "Congratulations! You've solved it! Play again soon!");		
		}
	}

	//Chooses a random board to make of specified difficulty
	private void makeRandBoard(String difficulty) {
		switch(r.nextInt(2)) {
		case 0:
			if(difficulty.equals("easy")) makeBoard(easyTable1);
			if(difficulty.equals("medium")) makeBoard(mediumTable1);
			if(difficulty.equals("hard")) makeBoard(hardTable1);
		case 1:
			if(difficulty.equals("easy")) makeBoard(easyTable2);
			if(difficulty.equals("medium")) makeBoard(mediumTable2);
			if(difficulty.equals("hard")) makeBoard(hardTable2);
		}
	}
	
	//Makes a board
	private void makeBoard(int[][] table) {
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				board[row][col] = table[row][col];
			}
		}
		printBoard();
	}
	
	//prints the board at current state
	private void printBoard() {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//main
	public static void main(String[] args) {
		SudokuGame diffChooser = new SudokuGame();
		diffChooser.setVisible(true);	
	}
}