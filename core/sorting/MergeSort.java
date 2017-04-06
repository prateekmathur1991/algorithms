package core.sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String [] args) {
		
		int [] arr = {22, 0, 9, 1, 6, 3, 21, 4, 7, 2, 11};
		
		System.out.println(Arrays.toString(arr));
		
		mergeSort(arr, 0, arr.length - 1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int [] arr, int lowestIndex, int highestIndex) {
		if (lowestIndex < highestIndex) {
			int mid = (lowestIndex + highestIndex)/2;
			mergeSort(arr, lowestIndex, mid);
			mergeSort(arr, mid + 1, highestIndex);
			merge(arr, lowestIndex, mid, highestIndex);
		}
	}
	
	public static void merge(int [] arr, int lowestIndex, int middleIndex, int highestIndex) {
		
		int [] helper = new int[arr.length];
		System.arraycopy(arr, 0, helper, 0, arr.length);
		
		int i = lowestIndex;
		int j = middleIndex + 1;
		int k = lowestIndex;
		
		while (i <= middleIndex && j <= highestIndex) {
			if (helper[i] <= helper[j]) {
				arr[k] = helper[i];
				k = k + 1;
				i = i + 1;
			} else {
				arr[k] = helper[j];
				k = k + 1;
				j = j + 1;
			}
		}
		
		if (i <= middleIndex) {
			while (i <= middleIndex) { 
				arr[k] = helper[i];
				k = k + 1;
				i = i + 1;
			}
		} else if (j <= highestIndex) {
			while (j <= highestIndex) {
				arr[k] = helper[j];
				k = k + 1;
				j = j + 1;
			}
		}
	} 
}