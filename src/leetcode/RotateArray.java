package leetcode;

/* Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k = k % len;
		int[] res = new int[len];
		int index = 0;
		for (int i = len - k; i < len; i++) {
			res[index++] = nums[i];
		}
		for (int i = 0; i < len - k; i++) {
			res[index++] = nums[i];
		}
		for (int i = 0; i < len; i++) {
			nums[i] = res[i];
		}
	}
}
