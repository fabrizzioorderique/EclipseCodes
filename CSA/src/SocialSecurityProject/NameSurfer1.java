package SocialSecurityProject;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//"C:\\Users\\3223027017\\Documents\\PieroBio.txt"
//"C:\\Users\\3223027017\\Documents\\namedata.txt"
//"C:\\Users\\fabri\\OneDrive\\Documents\\DasText\\familydata.txt"
//"C:\\Users\\fabri\\OneDrive\\Documents\\DasText\\namedata.txt"

public class NameSurfer1 extends JFrame{
	private JLabel message1 = new JLabel("Enter a Decade");
	private JLabel message2 = new JLabel("Enter a Name");
	private JTextField input1 = new JTextField("");
	private JTextField input2 = new JTextField("");
	private JLabel output = new JLabel("");
	private JButton fileButton = new JButton("Upload File");
	private JButton nameButton = new JButton("Search for Name");
	private JButton rankButton = new JButton("Rank in Decade");
	private JFileChooser fc = new JFileChooser();
	private JTextField display = new JTextField("");
	private String selectedFile;
	private ArrayList<NameRecord1> nameData = new ArrayList<>(11);


	public NameSurfer1() {
		//sets up input spaces for 
		JPanel inputpanel = new JPanel(new GridLayout(2,2,10,10));
		inputpanel.add(message2);
		inputpanel.add(message1);
		inputpanel.add(input2);
		inputpanel.add(input1);
		
		//sets up display field to display info 
		JPanel displaypanel = new JPanel(new GridLayout(1,1));
		displaypanel.add(display);
		
		//output text setup to say file was loaded 
		JPanel filepanel = new JPanel(new GridLayout(1,1));
		filepanel.add(output);
		
		//to fix display and file panel, adds from bottom to top
		JPanel middlepannel = new JPanel(new GridLayout(2,1));
		middlepannel.add(displaypanel);
		middlepannel.add(filepanel);
		
		//sets up the buttons for the GUI
		JPanel buttonpanel = new JPanel();
		buttonpanel.add(fileButton);
		buttonpanel.add(nameButton);
		buttonpanel.add(rankButton);
		nameButton.setEnabled(false);
		rankButton.setEnabled(false);
		
		//all the panels go in a pane
		Container pane = getContentPane();
		pane.add(inputpanel, BorderLayout.NORTH);
		pane.add(middlepannel, BorderLayout.CENTER);
		pane.add(buttonpanel, BorderLayout.SOUTH);
		
		//adds functionality to the buttons
		fileButton.addActionListener(new loadFile());
		nameButton.addActionListener(new nameSearch());
		rankButton.addActionListener(new displayTopRank());
	}
	public static void main(String[] args) {
        NameSurfer1 theGUI = new NameSurfer1();
        theGUI.setTitle("Social Security Data Base");
        theGUI.setSize(500, 300);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setVisible(true);
    }
	//personal methods for testing and making array 
	public void createData(File f) throws Exception {
		String currentLine;
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()){ 
			currentLine = sc.nextLine();
            nameData.add(new NameRecord1(currentLine));
        }
		testArrayData(nameData);
	}
	public void testArrayData(ArrayList<NameRecord1> arr) {
		for(NameRecord1 n : arr) {
			System.out.print(n.getName()+" ");
			n.printRanks();
			System.out.println();
		}
	}
	//Action Listeners for the buttons
	public class loadFile implements ActionListener {
		public void actionPerformed(ActionEvent papa) {
			int result = fc.showOpenDialog(fc);
			if (result == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                selectedFile = file.getAbsolutePath();
                nameButton.setEnabled(true);
                rankButton.setEnabled(true);
                fileButton.setEnabled(false);
                try {
					createData(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            output.setText(selectedFile + " is now loaded.");
		}
	}
	public class nameSearch implements ActionListener{
		public void actionPerformed(ActionEvent mama) {
			String nameInput = input2.getText();
			for(NameRecord1 n: nameData) {
				if(n.getName().equalsIgnoreCase(nameInput)) {
					display.setText(nameInput+" was most popular in "
					+ n.bestYear());
					break;
				}
				display.setText("Name is not in the data base");
			}
		}
	}
	public class displayTopRank implements ActionListener{
		public void actionPerformed(ActionEvent mama) {
			String nameInput = input2.getText();
			String rankInput = input1.getText();
			int year = Integer.parseInt(rankInput);
			if(nameData.get(0).getRank(year) < 0) {
				display.setText("Year is not in the data base");
			}else {
				for(NameRecord1 n: nameData) {
					if(n.getName().equalsIgnoreCase(nameInput)) {
						display.setText(nameInput+" ranked "+n.getRank(year)
						+" in "+rankInput);
						break;
					}
				}
			}
		}
	}
}