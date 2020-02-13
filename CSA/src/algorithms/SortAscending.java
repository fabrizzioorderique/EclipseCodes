package algorithms;
/*
 * Sorts int arrays in decending order!
 */
import java.util.Arrays;
public class SortAscending{
   //SELECTION SORT -- n(n - 1) / 2 comparisons no matter what
    public static int[] selectionSort(int[] elements){
      for (int j = 0; j < elements.length - 1; j++){
         int minIndex = j;
         for (int k = j + 1; k < elements.length; k++){
            if (elements[k] > elements[minIndex]){
               minIndex = k;
            }
         }
         int temp = elements[j];
         elements[j] = elements[minIndex];
         elements[minIndex] = temp;
       }
      return elements;
   }
   //INSERTION SORT
   public static int[] insertionSort(int[] elements){
      for (int j = 1; j < elements.length; j++){
         int temp = elements[j];
         int possibleIndex = j;
         while (possibleIndex > 0 && temp > elements[possibleIndex - 1]){
            elements[possibleIndex] = elements[possibleIndex - 1];
            possibleIndex--;
         }
         elements[possibleIndex] = temp;
      }
      return elements;
    }
   /******MERGE SORT*******/
   public static void mergeSort(int[] elements){
      int n = elements.length;
      int[] temp = new int[n];
      mergeSortHelper(elements, 0, n - 1, temp);
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
         if (elements[i] > elements[j]){
            temp[k] = elements[i];
            i++;
         }else{
            temp[k] = elements[j];
            j++;
         }
         k++;
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