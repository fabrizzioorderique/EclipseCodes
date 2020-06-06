import java.util.Arrays;
import java.util.Scanner;

public class BasicOperations {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		String digits = s.nextLine();                 // A string of digits.
		// code to solve the problem.  You can write and call other methods as well.
		boolean answer = false;
		//make int array
		String[] d = new String[digits.length()];
		for(int i = 0; i < digits.length(); i++) {d[i] = digits.substring(i, i+1);}
		int[] myDigits = new int[digits.length()];
		for(int i = 0; i < d.length; i++) {myDigits[i] = Integer.parseInt(d[i]);}
		
		//make signs array full of just 1's
		int[] signs = new int[digits.length()];
		for(int i = 0; i < signs.length; i++) {signs[i] = 1;}
		
		//do every combination of signs until zero
		int result;
		for (int i = 0; i < signs.length - 1; i++) {
			for (int j = i+1; j < signs.length; j++) {
				//System.out.println(Arrays.toString(signs));
				result = getResult(digits.length(),signs,myDigits);
				if(result == 0) {answer = true; break;}
				signs[j]=-1;
			}
			signs[i]=-1;
			//reset j row
			for(int j = i+1; j < signs.length; j++) {signs[j] = 1;}
		}
		
		//answer
		System.out.println(answer);                    // print your answer and just your answer.
	}
	//own method
	public static int getResult(int length, int[] s, int[] d) {
		int ans = 0; 
		for (int i = 0; i < length; i++) {
			ans += s[i]*d[i];
		}
		return ans;
	}
}
