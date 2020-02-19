package algorithms;
import java.io.File;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.*;
import java.awt.*;
public class Histogram extends JFrame{
	private JLabel output = new JLabel("");
	private static String[] stringRanges = new String[10];
	private static int[] frequencies = new int[10];
	private static int[] integers = new int[10000]; // holds all integers	
	private static int[] testArr = {24,4,23,62,84,30,34,23,3};
	
	public Histogram(int[] arr) {
		//creates the frequencies data
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%10==0) {frequencies[arr[i]/10-1]++;}
			else {frequencies[arr[i]/10]++;}
		}
		//sets up the range panel
		JPanel rangePanel = new JPanel(new GridLayout(10,2,15,15));
		for (int i = 0; i < 10; i++) {
			stringRanges[i] = 10*i+1+" - "+((i+1)*10);
			String message = "  "+stringRanges[i]+"  ";
			if(i==0) {message+="  ";}
			if(i==9) {message = message.substring(0,message.length()-2);}
			message+="   | ";
			for (int j = 0; j < frequencies[i]; j++) {message+="*";}
			rangePanel.add(new JLabel(message));
		}
		
		//Puts panels together
		Container pane = getContentPane();
		pane.add(rangePanel,BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser();
		Scanner s = new Scanner(System.in);
		System.out.println("Ready to load in the file? (y/n)");
		if (s.nextLine().equalsIgnoreCase("y")) {
			int result = fc.showOpenDialog(fc);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				try {createData(file);} 
				catch (Exception e) {e.printStackTrace();}
				String path = file.getAbsolutePath();
				System.out.println(path + " is now loaded in.");
				System.out.println();
			}
		}else {System.out.println("Test Array used in instead.");}
		/////////////////////////////////////
        Histogram theGUI = new Histogram(testArr);
        theGUI.setTitle("Frequency Table");
        theGUI.setSize(600, 335);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setVisible(true);
        System.out.println(Arrays.toString(stringRanges));
        System.out.println(Arrays.toString(frequencies));
    }
	// fills the array with data from the txt file
	public static void createData(File f) throws Exception {
			String currentLine;
			int i = 0;
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				currentLine = sc.nextLine();
				integers[i] = Integer.parseInt(currentLine)*10;
				i++;
			}
			testArr = integers;
		}		
}


