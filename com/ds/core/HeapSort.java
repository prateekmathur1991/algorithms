package com.ds.core;
// Prateek Mathur

// Java code to create a heap and perform heap sort on it

// 25 November 2015- This is not working

import java.util.Arrays;

public class HeapSort	{
	public static void main(String [] args)	{
		int [] nums = {10, 15, 23, 2, 11, 67, 32, 81, 67};
		System.out.println(Arrays.toString(nums));

		// Build a heap of our list
		heapify(nums);

		// Print out the heap
		System.out.println(Arrays.toString(nums));
	}

	public static void heapify(int [] nums)	{
		// The basic idea around building the heap is this-
		// We iterate over the whole list of ours, and see
		// if the element at that position is at its correct
		// position in a heap

		// An element is at its right position if it satisfies
		// the max-heap property-
		// Every element must be greater than or equal to its children
		for (int i = 0; i < (nums.length - 1)/2; i++)	{
			maxHeap(nums, i);
		}
	}

	public static void maxHeap(int [] nums, int i)	{	
		// Since Java arrays are zero based, the logic required is a bit different
		int parent = i/2, left = 2*i + 1, right = 2*i + 2;

		System.out.println("i:: " + i + " parent:: " + parent + " left:: " + left + " right:: " + right);
		System.out.println("nums[parent]:: " + nums[parent] + " nums[left]:: " + nums[left] + " nums[right]:: " + nums[right]);	
		
		int largestIndex = 0;
		if (left < nums.length && nums[left] > nums[i])	{
			largestIndex = left;
		} else {
			largestIndex = i;
		}
	
		if (right < nums.length && nums[right] > nums[i])	{
			largestIndex = right;
		}

		if (largestIndex != i)	{
			int temp = nums[largestIndex];
			nums[largestIndex] = nums[i];
			nums[i] = temp;

			maxHeap(nums, largestIndex);
		}

		/* if (nums[parent] < nums[i])	{
			System.out.println("parent less than current element");
			int temp = nums[parent];
			nums[parent] = nums[i];
			nums[i] = temp;
		} else if (nums[i] < nums[left])	{	
			System.out.println("element less than left child");
			int temp = nums[left];
			nums[left] = nums[i];
			nums[i] = temp;
		} else if (nums[i] < nums[right])	{	
			System.out.println("element less than right child");
			int temp = nums[right];
			nums[right] = nums[i];
			nums[i] = temp;
		} */
	}
}
