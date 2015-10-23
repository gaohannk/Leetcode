package leetcode;

/* You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
//TLE
public class HouseRobber {
	public int rob(int[] num) {
		if (num == null || num.length == 0)
			return 0;
		if (num.length == 1)
			return num[0];
		if (num.length == 2)
			return Math.max(num[0], num[1]);
		return helper(num, 0, num.length - 1);
	}

	public static int helper(int[] num, int start, int end) {
		if (start > end)
			return 0;
		if (start == end)
			return num[end];
		if (start + 1 == end)
			return num[end - 1];
		int temp1 = helper(num, start + 2, end);
		int temp2 = helper(num, start + 3, end);
		return Math.max(temp1, temp2) + num[start];
	}
}
