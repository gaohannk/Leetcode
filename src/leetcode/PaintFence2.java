package leetcode;

public class PaintFence2 {
	public static int numWays(int n, int k) {
		if (n <= 0 || k <= 0)
			return 0;
		if (n == 1)
			return k;
		int[] dp = new int[n + 1];

		// Initializaiton
		dp[1] = k;
		// Note!!!!! If 2 posts and have same color, the choice is k not the (k-1)*dp[0]
		dp[2] = k * (k - 1) + k; 
		for (int i = 3; i <= n; i++) {
			dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
		}
		// Final state
		return dp[n];
	}
}
