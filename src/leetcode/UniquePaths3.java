package leetcode;
/* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right 
 * corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
/* dp[m][n] = dp[m][n-1] + dp[m-1][n] where dp[m][n] denotes the number of unique paths
 * O(n^2) space & time
 */
public class UniquePaths3 {
	public int uniquePaths(int m, int n) {
		int[][] res = new int[m][n];
		// init left
		for (int i = 0; i < m; i++) {
			res[i][0] = 1;
		}
		// init top
		for (int j = 0; j < n; j++) {
			res[0][j] = 1;
		}
		// add values
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[i][j] = res[i - 1][j] + res[i][j - 1];
			}
		}
		return res[m - 1][n - 1];
	}
}
