// Prateek Mathur

// Merge Sort Implementation in Java

import java.util.Arrays;

class MergeSortDemo	{
	public void mergeSort(int [] nums, int low, int high)	{
		while (low < high)	{
			int mid = (low + high)/2;
			mergeSort(nums, mid, high);
			mergeSort(nums, mid + 1, high);
		}
	}

	public void merge(int [] nums, int low, int mid1, int mid2, int high)	{
		
	}
}

class MergeSort	{
	public static void main(String [] args)	{	
		MergeSortDemo demo = new MergeSortDemo();

		int [] nums = {5, 12, 4, 23, 78, 1, 6, 7, 16, 2};
		System.out.println(Arrays.toString(nums));

		int mid = (nums.length)/2;
		demo.mergeSort(nums, 0, mid);
		demo.mergeSort(nums, mid + 1, nums.length);
		demo.merge(nums, 0, mid, mid + 1, nums.length);

		System.out.println(Arrays.toString(nums));
	}
}
