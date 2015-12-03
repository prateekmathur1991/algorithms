// Prateek Mathur

// Java program to test a Queue

import java.util.Arrays;

public class QTest	{
	public static void main(String [] args)	{
		int [] nums = {10, 15, 14, 12, 4, 17, 22};
		System.out.println(Arrays.toString(nums));
		Queue queue = new Queue(nums.length);

		for (int num : nums) {
			queue.enqueue(num);
		}

		queue.printQueue();
		System.out.println();	
	}
}
