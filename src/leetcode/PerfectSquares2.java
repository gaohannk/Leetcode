package leetcode;

/* Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */

public class PerfectSquares2 {
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		return helper(n, dp);
	}

	private int helper(int n, int[] dp) {
		int sqrt = (int) Math.sqrt(n);
		if (sqrt == 0)
			return 0;
		int count = 0;
		int min = Integer.MAX_VALUE;
		for (int i = sqrt; i >= 1; i--) {
			if (dp[n - i * i] == 0)
				count = 1 + helper(n - i * i, dp);
			else
				count = 1 + dp[n - i * i];
			if (count < min)
				min = count;
		}
		dp[n]=min;
		return min;
	}
}
