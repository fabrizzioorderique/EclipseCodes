package MathPacket;
import javax.swing.JOptionPane;
public class Prime {
	static String input;
	static int testNum;
	public static boolean isPrime(int p) {
		int n = 2;
		while(n<Math.sqrt(p)) {
			if(p/n == 0) {
				return false;
			}else {
				n++;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		input = JOptionPane.showInputDialog("Type number in to see if it is prime");
		testNum = Integer.parseInt(input);
		if (isPrime(testNum)) {
			JOptionPane.showMessageDialog(null, "Yep! It's a prime!");
		}else {
			JOptionPane.showMessageDialog(null, "Nope, sorry");
		}
	}
}
