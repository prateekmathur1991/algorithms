package com.algo;

// A Super Lame Experiment
// Given a list of numbers (array), check if the list is sorted
// (Turns out the experiment is not so lame)

public class CheckSort	{
	public static void main(String [] args)	{
		int [] nums = {1, 3, 2, 8, 9, 10, 12, -1, 445};
		for (int i = 0; i < nums.length - 1; i++)	{
			if (nums[i] > nums[i + 1])	{
				System.err.println("Oops! Not sorted");
				System.exit(0);
			}
		}

		System.out.println("That's sorted");
	}
}
