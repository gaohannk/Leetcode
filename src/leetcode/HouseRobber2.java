package leetcode;

/* You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber2 {
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
		dp[1] = Math.max(num[0], num[1]);
		dp[2] = Math.max(dp[0] + num[2], dp[1]);
		for (int i = 3; i < len; i++) {
			int temp = Math.max(dp[i - 3] + num[i], dp[i - 2] + num[i]);
			dp[i] = Math.max(temp, dp[i - 1]);
			// if temp<dp[i-1] which means robber i-1 and we update
			// dp[i]=dp[i-1], return Math.max(dp[len-2],dp[len-1]) is not
			// necessary

		}
		return dp[len - 1];
	}
}
