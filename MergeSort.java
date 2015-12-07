// Prateek Mathur

// Merge Sort Implementation in Java

import java.util.Arrays;

class MergeSortDemo	{
	public void mergeSort(int [] nums, int low, int high)	{
		if (low < high)	{
			int mid = low + (high - low)/2;
			mergeSort(nums, low, mid);
			mergeSort(nums, mid + 1, high);
			merge(nums, low, mid, high);
		}
	}

	public void merge(int [] nums, int low, int mid, int high)	{
		int [] helper = new int[nums.length];

		for (int i = 0; i < nums.length; i++)	{
			helper[i] = nums[i];
		}
		
		int i = low;
		int j = mid + 1;
		int k = low;

		while (i <= mid && j <= high)	{
			if (helper[i] <= helper[j]) {
				nums[k] = helper[i];
				i++;
			} else {
				nums[k] = helper[j];
				j++;
			}

			k++;
		}

		while (i <= mid) {
			nums[k] = helper[i];
			k++;
			i++;
		}
	}
}

class MergeSort	{
	public static void main(String [] args)	{	
		MergeSortDemo demo = new MergeSortDemo();

		int [] nums = {5, 12, 4, 23, 78, 1, 6, 7, 16, 2};
		System.out.println(Arrays.toString(nums));

		demo.mergeSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}
}
