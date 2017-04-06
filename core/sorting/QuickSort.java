package core.sorting;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String [] args) {
		
		int [] arr = {1, 9, 2, 30, 6, 23, 98, 5, 11, 37, 21, 7, 4, 84, 39, 31};
		
		System.out.println(Arrays.toString(arr));
		
		quickSort(arr, 0, arr.length - 1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int [] arr, int low, int high) {
		
		if (low < high) {
			int mid = partition(arr, low, high);
			quickSort(arr, low, mid - 1);
			quickSort(arr, mid + 1, high);
		}
	}
	
	public static int partition(int [] arr, int low, int high) {
		
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i = i + 1;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		
		return (i + 1);
	}
}