package algorithms;
/*
 * Sorts int arrays in decending order!
 */
import java.util.Arrays;
public class Sort{
   private int number;
   private static int mergeStep = 0;
   public Sort(int n){
       number = n;
   }
   //SELECTION SORT -- n(n - 1) / 2 comparisons no matter what
    public static int[] selectionSort(int[] elements){
      int steps = 0;
      for (int j = 0; j < elements.length - 1; j++){
         int minIndex = j;
         for (int k = j + 1; k < elements.length; k++){
            if (elements[k] < elements[minIndex]){
               minIndex = k;
            }
            steps++;
            //System.out.println("Step "+steps+ ": "+Arrays.toString(elements));
         }
         int temp = elements[j];
         elements[j] = elements[minIndex];
         elements[minIndex] = temp;
       }
      System.out.println("Number of steps taken: "+steps);
      return elements;
   }
   //INSERTION SORT
   public static int[] insertionSort(int[] elements){
	  int steps = 0;
	  int whileCount = 0;
      for (int j = 1; j < elements.length; j++){
         int temp = elements[j];
         int possibleIndex = j;
         while (possibleIndex > 0 && temp < elements[possibleIndex - 1]){
        	whileCount++;
            elements[possibleIndex] = elements[possibleIndex - 1];
            possibleIndex--;
         }
         steps++;
         elements[possibleIndex] = temp;
         //System.out.println("Step "+steps+ ": "+Arrays.toString(elements));
      }
      System.out.println("Number of steps taken: "+(steps+whileCount));
      return elements;
    }
   /******MERGE SORT*******/
   public static void mergeSort(int[] elements){
      int n = elements.length;
      int[] temp = new int[n];
      mergeSortHelper(elements, 0, n - 1, temp);
      System.out.println("Number of steps taken: "+mergeStep);
   }
   private static void mergeSortHelper(int[] elements,int from, int to, int[] temp){
       if (from < to){
          int middle = (from + to) / 2;
          mergeSortHelper(elements, from, middle, temp);
          mergeSortHelper(elements, middle + 1, to, temp);
          merge(elements, from, middle, to, temp);
       }
   }
   private static void merge(int[] elements, int from,int mid, int to, int[] temp){
      int i = from;
      int j = mid + 1;
      int k = from;

      while (i <= mid && j <= to){
    	 mergeStep++;
         if (elements[i] < elements[j]){
            temp[k] = elements[i];
            i++;
         }else{
            temp[k] = elements[j];
            j++;
         }
         k++;
         //System.out.println("Step "+mergeStep+ ": "+Arrays.toString(elements));
      }
      while (i <= mid){
         temp[k] = elements[i];
         i++;
         k++;
      }
      while (j <= to){
         temp[k] = elements[j];
         j++;
         k++;
      }
      for (k = from; k <= to; k++){
         elements[k] = temp[k];
      }
   }
}