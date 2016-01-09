package leetcode;

import java.util.Arrays;

/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 */
/* Binary Search
 * 
 */
public class MissingNumber3 {
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		int low = 0;
		int high = nums.length-1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] != mid)
				high = mid;
			else
				low = mid;
		}

		if (nums[low] != low) {
			return low;
		}

		if (nums[high] != high) {
			return high;
		}
		return high + 1;
	}
}
