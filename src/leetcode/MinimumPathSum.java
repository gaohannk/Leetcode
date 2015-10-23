package leetcode;
/* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which mindistimizes the
 * sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
/* 设dp[i][j]表示从左上角到grid[i][j]的最小路径和。那么dp[i][j] = grid[i][j] + min( dp[i-1][j], dp[i][j-1] );
 */
public class MinimumPathSum {
	public int mindistPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int[][] mindist = new int[row][col];
		mindist[0][0] = grid[0][0];
		for (int i = 1; i < row; i++) {
			mindist[i][0] = mindist[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < col; i++) {
			mindist[0][i] = mindist[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				mindist[i][j] = Math.min(mindist[i - 1][j], mindist[i][j - 1]) + grid[i][j];
			}
		}
		return mindist[row - 1][col - 1];
	}
}
