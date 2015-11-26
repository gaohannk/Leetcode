package leetcode;

/* After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention.
 * This time, all houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one.
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */

public class HouseRobberII {
	public int rob(int[] num) {
		if (num == null || num.length == 0)
			return 0;
		int len = num.length;
		if (len == 1)
			return num[0];
		if (len == 2)
			return Math.max(num[0], num[1]);
		int[] dp = new int[len];
		dp[0] = num[0];
		dp[1] = num[0];
		dp[2] = dp[0] + num[2];
		for (int i = 3; i < len - 1; i++) {
			int temp = Math.max(dp[i - 3] + num[i], dp[i - 2] + num[i]);
			dp[i] = Math.max(temp, dp[i - 1]);
		}
		int res1 = dp[len - 2];
		dp[0] = 0;
		dp[1] = num[1];
		dp[2] = Math.max(num[1], num[2]);
		for (int i = 3; i < len - 1; i++) {
			int temp = Math.max(dp[i - 3] + num[i], dp[i - 2] + num[i]);
			dp[i] = Math.max(temp, dp[i - 1]);
		}
		int res2 = dp[len - 1];
		return Math.max(res1, res2);
	}
}
