// Prateek Mathur

// Java program to test a queue

import java.util.Arrays;

public class QTest	{
	public static void main(String [] args)	{
		int [] nums = {18, 2, 15, 12, 7, 20};
		System.out.println(Arrays.toString(nums));

		Queue queue = new Queue(nums.length);

		System.out.println(queue);
		
		for (int num : nums) {
			queue.enqueue(num);
		}

		System.out.println(queue);
	}
}
