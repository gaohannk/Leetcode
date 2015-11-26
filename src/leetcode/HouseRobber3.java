package leetcode;

/* You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber3 {
	public int rob(int[] nums) {
		if (nums.length < 1)
			return 0;
		else if (nums.length < 2)
			return nums[0];
		int beforePrevious = nums[0], previous = Math.max(beforePrevious, nums[1]);
		for (int i = 2; i < nums.length; i++) {
			if (previous > beforePrevious + nums[i]) {
				beforePrevious = previous;
			} else {
				int temp = previous;
				previous = beforePrevious + nums[i];
				beforePrevious = temp;
			}
		}
		return Math.max(previous, beforePrevious);
	}
}
