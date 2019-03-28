/**
 * Sudoku Game source code
 * This code is my attempt to make a Sudoku game which meets the following criteria:
 * 1) User chooses difficulty of board
 * 2) Given that, the program makes a random board of that diffuculty
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

public class SudokuGame extends JFrame implements ActionListener{

	String[] difficulties = {"easy","medium","hard"};
	JComboBox diffSelection = new JComboBox(difficulties);
	JLabel text = new JLabel();
	
	public SudokuGame() {
		setLayout(new FlowLayout());
		setSize(400,300);
		setTitle("Sudoku Game Difficulty Chooser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		diffSelection.setSelectedIndex(0);			//first option is auto selected
		diffSelection.addActionListener(this);		//will help me record the user's selection
		add(diffSelection);							//adds the combobox to the frame
		add(text);									//adds the label
	}
	
	public static void main(String[] args) {
		SudokuGame real = new SudokuGame();
		//centerFrame(real);							//put the list in the middle
		real.setVisible(true);
	}

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
				break;
			case "medium":
				text.setText("Selected Difficulty: MEDIUM");
				break;
			case "hard":
				text.setText("Selected Difficulty: HARD");
				break;
			default: 
				text.setText("Error");
			}
		}
	}

}
