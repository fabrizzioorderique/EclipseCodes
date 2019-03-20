import java.util.*;
import javax.swing.JOptionPane;
import SnakeGame.Entity; //class from another package within the project = packageName.className   
import MathPacket.Gcf;  //In order to use a class from another project, you have to put the project in the java path dependency
public class TestRunner {
	
	public static void main(String[] args) {
		int x = 0;
		do {
			x++;
			System.out.println(x);
		}while(x>10);
		System.out.println(0%3);
	}
}
