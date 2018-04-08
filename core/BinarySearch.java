package core;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] nums = { 10, 12, 15, 16, 18, 28, 32, 45, 89 };
		System.out.println(Arrays.toString(nums));
		int num = 15;
		System.out.println(num + " " + binarySearch(nums, 0, nums.length - 1, num));
	}

	public static int binarySearch(int[] nums, int low, int high, int num) {
		int start = low, end = high;
		int mid = start + ((end - start) / 2);

		while (start <= end && nums[mid] != num) {
			if (num < nums[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

			mid = start + ((end - start) / 2);
		}

		if (nums[mid] == num) {
			return mid;
		} else {
			return -1;
		}

	}
}
