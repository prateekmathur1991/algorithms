package core;
// Prateek Mathur

// Given a list of numbers, find the kth
// largest number.

import java.util.Arrays;
import java.util.Random;

public class KLargest	{
	public static void main(String [] args)	{
		int [] nums = {2, 16, 7, 13, 10, 15};
		int k = 3;
		System.out.println(Arrays.toString(nums));

		int klargest = findKLargest(nums, k);

		System.out.println(k + " " + klargest);
	}

	public static int findKLargest(int [] nums, int k)	{
		int low = 0;
		int high = nums.length - 1;

		while (low <= high)	{
			int p = partition(nums, low, high);
			if (p == k) {
				return nums[p];
			} else if (p < k) {
				low = p + 1;
			} else {
				high = p - 1;
			}
		}
		
		return 0;
	}

	public static int partition(int [] nums, int low, int high)	{
		int pivot = nums[high];
		int lowestIndex = low - 1;

		for (int i = low; i <= (high - 1); i++)	{
			if (nums[i] <= pivot)	{
				lowestIndex = lowestIndex + 1;
				int temp = nums[lowestIndex];
				nums[lowestIndex] = nums[i];
				nums[i] = temp;
			}
		}

		int temp = nums[lowestIndex + 1];
		nums[lowestIndex + 1] = nums[high];
		nums[high] = temp;

		return lowestIndex + 1;
		
	}
}
