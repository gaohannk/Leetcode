package leetcode;

import java.util.Arrays;

/* Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class RotateArray3 {
	public static void rotate(int[] nums, int k) {
		int len = nums.length;
		Reverse(nums, 0, len - k - 1);
		Reverse(nums, len - k, len - 1);
		Reverse(nums, 0, len - 1);
	}

	// we first define the basic swap function
	public static void swap(int[] num, int a, int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}

	public static void Reverse(int[] num, int start, int end) {
		for (int i = start; i <= (start + end) / 2; i++) {
			swap(num, i, end + start - i);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}

}
