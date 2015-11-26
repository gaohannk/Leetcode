package leetcode;

import java.util.Arrays;

/* After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention.
 * This time, all houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one.
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII2 {
	public int subRob(int[] num) {
		num[num.length - 1] = num[num.length - 1];
		num[num.length - 2] = Math.max(num[num.length - 2], num[num.length - 1]);
		for (int i = num.length - 3; i >= 0; i--)
			num[i] = Math.max(num[i] + num[i + 2], num[i + 1]);
		return num[0];
	}

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		return Math.max(subRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
				subRob(Arrays.copyOfRange(nums, 1, nums.length)));
	}
}
