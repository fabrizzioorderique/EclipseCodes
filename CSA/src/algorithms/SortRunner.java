package algorithms;
import java.util.Arrays;

public class SortRunner {
	public static void main(String[] args) {
		int[] numbers = {0,-10,20,-20,10};
		System.out.println(Arrays.toString(numbers));
		
		Sort.insertionSort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
}
