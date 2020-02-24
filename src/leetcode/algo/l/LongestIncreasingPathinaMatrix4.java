package leetcode.algo.l;

import java.util.Arrays;

/* Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * Example 1:
 * nums = [
 * 	[9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/
// DFS Solution memory
public class LongestIncreasingPathinaMatrix4 {

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        // Init value
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], 1);
        }
        int ret = 0;
        int oldvalue;
        boolean updating;
        while (true) {
            updating = false;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    oldvalue = dp[i][j];
                    if (i >= 1 && matrix[i - 1][j] < matrix[i][j]) {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i][j]);
                    }
                    if (j >= 1 && matrix[i][j - 1] < matrix[i][j]) {
                        dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i][j]);
                    }
                    if (oldvalue != dp[i][j]) {
                        updating = true;
                    }
                    ret = Math.max(ret, dp[i][j]);
                }
            }
            for (int i = row - 1; i >= 0; i--) {
                for (int j = col - 1; j >= 0; j--) {
                    oldvalue = dp[i][j];
                    if (i < row - 1 && matrix[i + 1][j] < matrix[i][j]) {
                        dp[i][j] = Math.max(dp[i + 1][j] + 1, dp[i][j]);
                    }
                    if (j < col - 1 && matrix[i][j + 1] < matrix[i][j]) {
                        dp[i][j] = Math.max(dp[i][j + 1] + 1, dp[i][j]);
                    }
                    if (oldvalue != dp[i][j]) {
                        updating = true;
                    }
                    ret = Math.max(ret, dp[i][j]);
                }
            }
            if (!updating) {
                break;
            }
        }
        return ret + 1;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(longestIncreasingPath(nums));
    }
}
