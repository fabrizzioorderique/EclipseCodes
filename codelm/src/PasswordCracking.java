import java.util.Scanner;

public class PasswordCracking {
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int guess = s.nextInt();              // A five-digit integer.
		int lower = s.nextInt();			  // The lower bound.
		int upper = s.nextInt();			  // The upper bound.
		int answer = s.nextInt();             // The correct password.

		// code to solve the problem.  You can write and call other methods as well.
		boolean inRange = true;
		double prob;
		int[] myGuess = intToArr(guess);
		int[] myAnswer = intToArr(answer);
		//get number of zeros
		int zeros = 0;
		for(int i: myGuess) {if(i == 0) {zeros++;}}
		//set inRange
		for(int i = 0; i < myGuess.length; i++) {
			if(myGuess[i] != 0 && myGuess[i] != myAnswer[i]) {inRange = false;}
			if(myGuess[i] == 0) {
				if(myAnswer[i]<lower || myAnswer[i]>upper) {inRange = false;}
			}	
		}
		//calculates prob:
		if(inRange) {
			prob = 100* Math.pow(((double)1/(upper-lower+1)), zeros) ;
		}else {
			prob = 0;
		}
		System.out.println(prob);                     // print your answer and just your answer.
	}
	public static int[] intToArr(int num) {
		int l = Integer.toString(num).length();
		int i = 0;
		int[] arr = new int[l];
		while(num!=0) {
			arr[l-1-i] = num%10;
			num/=10;
			i++;
		}
		return arr;
	}
}
