package company.amazon.oa;

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
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        if (obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }

        int i, j;
        for (i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }
        for (; i < row; i++) {
            dp[i][0] = 0;
        }
        for (j = 0; j < col; j++) {
            if (obstacleGrid[0][j] == 1)
                break;
            dp[0][j] = 1;
        }
        for (; j < col; j++) {
            dp[0][j] = 0;
        }

        for (i = 1; i < row; i++) {
            for (j = 1; j < col; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }
}
