package com.ds.core;
// Prateek Mathur

// Java implementation for Quick Sort (using last element as pivot)

import java.util.Arrays;

public class QuickSort	{
	public static void main(String [] args)	{
		int [] nums = {13, 9, 23, 56, 71, 23, 89, 887, 12};
		System.out.println(Arrays.toString(nums));
		
		quickSort(nums, 0, nums.length - 1);	
			
		System.out.println(Arrays.toString(nums));
	}

	public static void quickSort(int [] nums, int low, int high)	{
		if (low < high)	{
			int p = partition(nums, low, high);
			quickSort(nums, low, p - 1);
			quickSort(nums, p + 1, high);
		}
	}

	public static int partition(int [] nums, int low, int high)	{
		// Lets choose the last element as pivot
		int pivot = nums[high];
		int lowestIndex = low - 1;
		
		for (int i = low; i <= (high - 1); i++)	{
			if (nums[i] <= pivot)	{
				lowestIndex = lowestIndex + 1;
				int temp = nums[i];
				nums[i] = nums[lowestIndex];
				nums[lowestIndex] = temp;
				
			}
		}

		int temp = nums[lowestIndex + 1];
		nums[lowestIndex + 1] = nums[high];
		nums[high] = temp;

		return lowestIndex + 1;
	}
}
