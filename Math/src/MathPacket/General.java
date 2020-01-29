package MathPacket;

public class General {
	public static int factorial(int n) {
		int result = 1;
		for(int i = n; i > 1; i--) {
			result *= i;
		}
		return result;
	}
}
