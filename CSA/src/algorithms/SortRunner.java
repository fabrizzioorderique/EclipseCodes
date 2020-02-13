package algorithms;
import java.util.Arrays;

public class SortRunner{
   public static void main(String[] args){
      int[] arr1 = {3,86,-20,14,40,34};
      int[] arr2 = {-20,3,14,34,40,86};	//sorted descending
      int[] arr3 = {86,40,34,14,3,-20}; //sorted ascending
      //test(arr1);
      //test(arr2);
      test(arr2);
   }
   public static void test(int[] arr){
      System.out.println("Array Input: " + Arrays.toString(arr));
      Sort.mergeSort(arr);
      System.out.println("SORTED LIST: "+Arrays.toString(arr));
      System.out.println();
   }
}