package MathPrograms;
/**
 * This program tries to find a nine digit number that
 * meets the following criteria:
 * 1) first digit is divisible by 1, first 2 digits are divisible by 2 and so on
 * 2) all digits must be unique
 * @author fabri
 *
 */
public class NineDigitNum {
	
	//This method will separate the partitions into an array
	public static void setPartitionsList(int num, int[] partitions) {
		int j = partitions.length - 1;
		for(int i = 0; i < partitions.length; i++) {
			partitions[i] = (int) (num/(Math.pow(10, j)));
			//System.out.print(partitions[i] +" ");
			j--;
		}
	}
	
	//This will check if each partition is divisible by its length
	public static boolean checkDivisibility(int[] partitions) {
		int j = 1;
		int counter = 0;
		for(int i = 0; i < partitions.length; i++) {
			if(partitions[i]%j == 0) {
				counter++;
			}
			j++;
		}
		if(counter == partitions.length) {
			return true;
		}else {
			return false;
		}
	}
	
	//separate each individual digit into a list
	public static void setDigitsList(int n, int[] digits) {
		double num = n;
		int j = digits.length;
		for(int i = 0; i < digits.length; i++) {
			digits[i] = (int) (num/(Math.pow(10, j-1)));
			//System.out.print(digits[i]+ " ");
			num -= digits[i]*(Math.pow(10, j-1));
			j--;
		}
	}
	
	//checks to see if each individual digit is unique
	public static boolean checkUniqueness(int[] digits) {
		for (int i = 0; i < digits.length; i++) {
			for(int j = i+1; j < digits.length;j++) {
				if(digits[i] == digits[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		int lengthOfNum = 9;
		int [] partitions = new int[lengthOfNum];
		int [] digits = new int[lengthOfNum];
		for(int num = 100000000;num<1000000000;num++) {
			if(num%1000000==0) {
				System.out.println("Running iteration number "+num+"...");
			}
			setPartitionsList(num,partitions);
			setDigitsList(num,digits);
			if(checkDivisibility(partitions) && checkUniqueness(digits)) {
				System.out.println("Number Found! Result: " +num);
				break;
			}
		}
		System.out.println("Done");

	}
}
