package leetcode;
/* Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 */
/* dp[m][n] = dp[m][n-1] + dp[m-1][n]  if the cell at the position (m, n) is empty
 * dp[m][n] = 0 if the cell at the position (m, n) is occupied by an obstacle
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] res = new int[m][n];
		if (obstacleGrid[m - 1][n - 1] == 1)
			return 0;
		int i,j;
		for (i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1)
				break;
			res[i][0] = 1;
		}
		for (; i < m; i++) 
			res[i][0] = 0;
		for (j = 0; j < n; j++) {
			if (obstacleGrid[0][j] == 1)
				break;
			res[0][j] = 1;
		}
		for (; j < n; j++) 
			res[0][j] = 0;
		// add values
		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				if (obstacleGrid[i - 1][j] == 1)
					res[i - 1][j] = 0;
				if (obstacleGrid[i][j - 1] == 1)
					res[i][j - 1] = 0;
				res[i][j] = res[i - 1][j] + res[i][j - 1];
			}
		}
		return res[m - 1][n - 1];
	}
}
