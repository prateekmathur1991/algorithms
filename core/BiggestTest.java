package core;

// An alebit simple program to find the maximum and minimum element in an array
// using pair-wise comparision

public class BiggestTest {
	public static void main(String[] args) {
		int[] nums = { 5, 12, 2, 4, 6, 18, 91, 22, 23, 336 };
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, start = 0;
		// int comps = 0;I use this 'comps' variable for the sole purpose of
		// counting comparisions

		if ((nums.length % 2) == 0) {
			start = 1;
		}

		for (int i = start; i < nums.length; i += 2) {
			int j = i;
			int tempMax = 0, tempMin = 0;
			if (i == nums.length - 1) {
				tempMin = tempMax = nums[i];
			} else {
				// comps++;
				tempMax = nums[i] > nums[j++] ? nums[i] : nums[j];
				tempMin = nums[i] < nums[j] ? nums[i] : nums[j];
			}
			// comps++;
			max = tempMax > max ? tempMax : max;
			min = tempMin < min ? tempMin : min;
		}

		System.out.println("Got maximum number:: " + max + " Got minimum number:: " + min);
	}
}
