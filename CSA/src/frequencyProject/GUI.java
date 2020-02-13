package frequencyProject;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

import SocialSecurityProject.NameRecord1;
import SocialSecurityProject.NameSurfer1;

import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame{
	private JLabel output = new JLabel("");
	private JButton fileButton = new JButton("Upload File");
	private JFileChooser fc = new JFileChooser();
	private String selectedFile;
	private static String[] ranges = new String[10];

	private ArrayList<Double> numbers = new ArrayList<>();
	
	public GUI() {
		//sets up the range panel
		JPanel rangePanel = new JPanel(new GridLayout(2,10,10,10));
		for (int i = 0; i < 10; i++) {
			ranges[i] = 10*i+1+" - "+((i+1)*10);
			rangePanel.add(new JLabel(ranges[i]));
		}
	}
	
	public static void main(String[] args) {
        GUI theGUI = new GUI();
        theGUI.setTitle("Frequency Table");
        theGUI.setSize(500, 300);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setVisible(true);
        System.out.println(Arrays.toString(ranges));
    }
}


