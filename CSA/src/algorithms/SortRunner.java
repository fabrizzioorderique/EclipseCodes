package algorithms;
import java.util.Arrays;

public class SortRunner {
	public static void main(String[] args) {
		int[] numbers1 = {0,-10,20,-20,10};
		int[] numbers2 = {3,4,2,0,-342,23,2};
		int[] numbers3 = {23,52,-324,-3,23,0,324,2,3};
		System.out.println("Array 1 before sort: " +Arrays.toString(numbers1));
		System.out.println("Array 2 before sort: " +Arrays.toString(numbers2));
		System.out.println("Array 3 before sort: " +Arrays.toString(numbers3));
		System.out.println();

		Sort.selectionSort(numbers1);
		Sort.insertionSort(numbers2);
		Sort.mergeSort(numbers3);
		System.out.println("Array 1 after selection sort: " +Arrays.toString(numbers1));
		System.out.println("Array 2 after insertion sort: " +Arrays.toString(numbers1));
		System.out.println("Array 3 after merge sort: " +Arrays.toString(numbers1));

	}
}
