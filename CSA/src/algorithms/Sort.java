package algorithms;

import java.io.File;
import java.util.*;
import javax.swing.JFileChooser;
/*
 * @author Piero Orderique
 * @date 2/14/2020
 * @class CSA 2
 * 
 * Description:
 * 	-Sort class contains three different sorting algorithms:
 * 		-Selection Sort
 * 		-Insertion Sort
 * 		-Merge Sort
 * 
 * 	-Program is intended to...
 * 		-Read in a file of integers from 1 - 10
 * 		-Convert file into an int array 
 * 		-Sort array in ascending order using all 3 algorithms
 * 		-Display number of steps taken by each sorting method 
 * 		-Display frequency of each integer in given array
 */
//"C:\\Users\\fabri\\OneDrive\\Documents\\DasText\\random10kIntegers.txt"

public class Sort {
	private static int mergeStep = 0;
	private static int[] integers = new int[10000]; // holds all integers
	private static int[][] temps = new int[3][10000];
	private static int[] frequencies = new int[10];	//holds frequencies

	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser();
		Scanner s = new Scanner(System.in);
		System.out.println("Ready to load in the file? (y/n)");
		if (s.nextLine().equalsIgnoreCase("y")) {
			int result = fc.showOpenDialog(fc);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				try {createData(file);} 
				catch (Exception e) {e.printStackTrace();}
				String path = file.getAbsolutePath();
				System.out.println(path + " is now loaded in.");
				System.out.println();
			}
			setTemps(); // sets temps to original unsorted array
			displaySteps();
			showFrequencies();
		}else {System.out.println("Program Terminated.");}
	}

	// fills the array with data from the txt file
	public static void createData(File f) throws Exception {
		String currentLine;
		int i = 0;
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			currentLine = sc.nextLine();
			integers[i] = Integer.parseInt(currentLine);
			i++;
		}
	}

	// sets the temp arrays equal to original data to be used by sorts
	public static void setTemps() {
		for (int i = 0; i < temps.length; i++) {
			for (int j = 0; j < integers.length; j++) {
				temps[i][j] = integers[j];
			}
		}
	}

	// prints arrays - for testing
	public static void printArray(int[] array) {
		for (int i : array) {System.out.println(i);}
	}

	public static void printArray(int[][] array) {
		for (int[] i : array) {
			for (int j : i) {System.out.print(j + " ");}
			System.out.println();
		}
	}
	
	//displays the amount of steps each sorting algorthm takes
	public static void displaySteps() {
		System.out.println("Sort selected: Selection Sort");
		selectionSort(temps[0]);
		System.out.println("Sort selected: Insertion Sort");
		insertionSort(temps[1]);
		System.out.println("Sort selected: Merge Sort");
		mergeSort(temps[2]);
	}
	
	//displays the frequencies of each integer in a list
	public static void showFrequencies() {
		for(int i : integers) {frequencies[i-1]++;}
		for(int i = 0; i < frequencies.length;i++) {
			System.out.println("Frequency of "+(i+1)+": "+frequencies[i]);
		}
	}
	
	/*************************** SORTING METHODS *******************************/
	
	// SELECTION SORT -- n(n - 1) / 2 comparisons no matter what
	public static int[] selectionSort(int[] elements) {
		int selectionSteps = 0;
		for (int j = 0; j < elements.length - 1; j++) {
			int minIndex = j;
			for (int k = j + 1; k < elements.length; k++) {
				if (elements[k] < elements[minIndex]) {
					minIndex = k;
				}
				selectionSteps++;
			}
			int temp = elements[j];
			elements[j] = elements[minIndex];
			elements[minIndex] = temp;
		}
		System.out.println("Number of steps taken: " + selectionSteps);
		System.out.println();
		return elements;
	}

	// INSERTION SORT
	public static int[] insertionSort(int[] elements) {
		int steps = 0;
		int whileCount = 0;
		for (int j = 1; j < elements.length; j++) {
			int temp = elements[j];
			int possibleIndex = j;
			while (possibleIndex > 0 && temp < elements[possibleIndex - 1]) {
				whileCount++;
				elements[possibleIndex] = elements[possibleIndex - 1];
				possibleIndex--;
			}
			steps++;
			elements[possibleIndex] = temp;
		}
		System.out.println("Number of steps taken: " + (steps + whileCount));
		System.out.println();
		return elements;
	}

	//MERGE SORT
	public static int[] mergeSort(int[] elements) {
		int n = elements.length;
		int[] temp = new int[n];
		mergeSortHelper(elements, 0, n - 1, temp);
		System.out.println("Number of steps taken: " + mergeStep);
		System.out.println();
		return elements;
	}

	private static void mergeSortHelper(int[] elements, int from, int to, int[] temp) {
		if (from < to) {
			int middle = (from + to) / 2;
			mergeSortHelper(elements, from, middle, temp);
			mergeSortHelper(elements, middle + 1, to, temp);
			merge(elements, from, middle, to, temp);
		}
	}

	private static void merge(int[] elements, int from, int mid, int to, int[] temp) {
		int i = from;
		int j = mid + 1;
		int k = from;

		while (i <= mid && j <= to) {
			mergeStep++;
			if (elements[i] < elements[j]) {
				temp[k] = elements[i];
				i++;
			} else {
				temp[k] = elements[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			temp[k] = elements[i];
			i++;
			k++;
		}
		while (j <= to) {
			temp[k] = elements[j];
			j++;
			k++;
		}
		for (k = from; k <= to; k++) {
			elements[k] = temp[k];
		}
	}
}