package SocialSecurityProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUISample extends JFrame {
    private JLabel message = new JLabel("Enter a number");
    private JLabel output = new JLabel("And the answer is...");
    private JTextField input = new JTextField("");
    private JTextField answer = new JTextField("");
    private JButton clickMe = new JButton("Click to Double");
    
    public GUISample() {
        JPanel inputpanel = new JPanel(new GridLayout(2, 1));
        inputpanel.add(message);
        inputpanel.add(input);
        
        JPanel buttonpanel = new JPanel();
        buttonpanel.add(clickMe);
        
        JPanel outputpanel = new JPanel(new GridLayout(1, 2, 10, 0));
        outputpanel.add(output);
        outputpanel.add(answer);
        
        Container pane = getContentPane();
        pane.add(inputpanel, BorderLayout.NORTH);
        pane.add(buttonpanel, BorderLayout.CENTER);
        pane.add(outputpanel, BorderLayout.SOUTH);
        
        clickMe.addActionListener(new MyListener());
    }
    public static void main(String[] args) {
        GUISample theGUI = new GUISample();
        theGUI.setTitle("Sample GUI");
        theGUI.setSize(250, 150);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setVisible(true);
    }
    public class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String myNumAsString = input.getText();
            int myNum = Integer.parseInt(myNumAsString);
            int myDouble = myNum * 2;
            answer.setText("" + myDouble);
        }
    }
}
