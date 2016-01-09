package leetcode;

import java.util.Arrays;

/* Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
/* Time O(nlogn)
 * Space O(1)
 */
public class WiggleSort2 {
	public void wiggleSort(int[] nums) {
		// 先将数组排序
		Arrays.sort(nums);
		// 将数组中一对一对交换
		for (int i = 2; i < nums.length; i += 2) {
			int tmp = nums[i - 1];
			nums[i - 1] = nums[i];
			nums[i] = tmp;
		}
	}
}
