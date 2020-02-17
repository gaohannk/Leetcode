package leetcode.algo.l;

/**
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
 * Example:
 * Input:
 * [[0,1,1,0],
 * [0,1,1,0],
 * [0,0,0,1]]
 * Output: 3
 */

/**
 * Time complexity : O(mn). We traverse the entire matrix once only.
 *
 * Space complexity : O(mn). dpdp array of size 4mn4mn is used, where mm and nn are the number of rows ans coloumns of the matrix.
 */
public class LongestLineofConsecutiveOneinMatrix {
    public int longestLine(int[][] M) {
        if (M.length == 0) {
            return 0;
        }
        int max = 0;
        int[][][] dp = new int[M.length][M[0].length][4];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : 1;
                    dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : 1;
                    dp[i][j][2] = (i > 0 && j > 0) ? dp[i - 1][j - 1][2] + 1 : 1;
                    dp[i][j][3] = (i > 0 && j < M[0].length - 1) ? dp[i - 1][j + 1][3] + 1 : 1;
                    max = Math.max(max, Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
                }
            }
        }
        return max;
    }
}
