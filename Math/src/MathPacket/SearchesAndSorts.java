package MathPacket;
//All searches assume list in ascending order
//All sorts put list in ascending order
public class SearchesAndSorts {
	//Binary Search  returns target index
	public static int binarySearch(int[] arr, int target){
		int middle = arr.length/2;
		int lowIndex = 0;
		int highIndex = arr.length-1;
		while(lowIndex <= highIndex) {
			if(arr[middle] == target) 
				return middle;
			else if(target > arr[middle]) 
				lowIndex = middle+1;
			else
				highIndex = middle-1;
			middle = (highIndex+lowIndex)/2;
		}
		return -1;
	}
	
	//selection sort recreates array by swapping 
	public static int[] selectionSort(int[] arr){
		int currentMin = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]<arr[i]) {
					currentMin = arr[j];
					//swap
					arr[j] = arr[i];
					arr[i] = currentMin;
				}
			}
		}
		return arr;
	}
	
	//insertion sort 
	public static int[] insertionSort(int[] arr) {
		System.out.print("Insertion Sort started.");
		for (int i = 1; i < arr.length; i++) {
			System.out.print(".");
			int index = i;
			while(index > 0) {
				if(arr[index] < arr[index-1]) {
					int temp = arr[index];
					arr[index] = arr[index-1];
					arr[index-1] = temp;
				}
				index--;
			}
		}
		return arr;
	}
}
