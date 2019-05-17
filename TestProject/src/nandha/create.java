package nandha;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.JScrollBar;
public class create {

	private JFrame frame;
	private JTextField textField;

	
	 //Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					create window = new create();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 //Create the application.
	 
	public create() {
		initialize();
	}

	
	 //Initialize the contents of the frame.
	 
	private void initialize() {
		frame = new JFrame("Diary");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Text Field
		textField = new JTextField("Type Here");
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		frame.getContentPane().add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		//Label
		JLabel lblLabel = new JLabel("");
		
		lblLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel.setAlignmentX(0.5f);
		frame.getContentPane().add(lblLabel, BorderLayout.CENTER);
		lblLabel.setBackground(Color.black);
		//Button
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setAlignmentX(0.2f);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				String collector;
				String entry = textField.getText();
				if(entry == ""){
					
			lblLabel.setText("Empty Entry" + dtf.format(now) + entry);
				}
				else{
					lblLabel.setText(lblLabel.getText() + "<html> <body><p> <br>" + dtf.format(now)+": " + entry);
					
				}
			}
		});
		
		frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
		
		JScrollBar scrollBar = new JScrollBar();
		frame.getContentPane().add(scrollBar, BorderLayout.EAST);
		//Menu
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenuItem menuItemExit = new JMenuItem("Exit");
		JMenuItem menuItemSave = new JMenuItem("Save");
		menuItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileWriter writer;
				try {
					writer = new FileWriter("file.txt");
					writer.write(lblLabel.getText());
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		menuFile.add(menuItemExit);
		menuFile.add(menuItemSave);
		 
		menuBar.add(menuFile);
		 
		// adds menu bar to the frame
		frame.setJMenuBar(menuBar);	 
	}
}
