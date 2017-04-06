package core.sorting;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String [] args) {
		
		int [] arr = {10, 5, 11, 0, 3, 6, 2, 1, 8, 9};
		
		System.out.println(Arrays.toString(arr));
		
		insertionSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void insertionSort(int [] arr) {
		
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j - 1;
			
			while (i >= 0 && arr[i] > key) {
				
				arr[i+1] = arr[i];
				i--;
			}
			
			arr[i+1] = key;
		}
	}
}