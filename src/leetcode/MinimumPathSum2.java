package leetcode;
/* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which mindistimizes the
 * sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
/* f[i][j]=mindist(f[i-1][j],f[i][j-1])+grid[i][j]
 * 注意到dp[i][j] 只和上一行的dp[i-1][j]和上一列的dp[i][j-1]有关，因此空间复杂度可以是O（min（row,col））
 */
public class MinimumPathSum2 {
	public int minPathSum(int[][] grid) {
	int row = grid.length;
	int col = grid[0].length;
	int[] mindist = new int[col];
	mindist[0] = grid[0][0];
	for (int i = 1; i < col; i++) {
		mindist[i] = mindist[i - 1] + grid[0][i];
	}

	for (int i = 1; i < row; i++) {
		mindist[0]=mindist[0]+grid[i][0];
		for (int j = 1; j < col; j++) {
			mindist[j] = Math.min(mindist[j - 1], mindist[j]) + grid[i][j];
		}
	}
	return mindist[col - 1];
	}
}
