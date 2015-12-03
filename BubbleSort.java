// Prateek Mathur

// A Program to bubble sort an array

import java.util.Arrays;

public class BubbleSort	{
	public static void main(String [] args)	{
		int [] nums = {5, 2, 12, 7, 8, 9, 90, 6, 67, 32};
		
		System.out.println("Array Before Sort:: " + Arrays.toString(nums));		

		for (int i = 0; i < nums.length; i++)		{
			for (int j = 0; j < i; j++)	{
				if (nums[i] < nums[j])	{
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}

		System.out.println("Array After Sort:: " + Arrays.toString(nums));		
			
	}
}
