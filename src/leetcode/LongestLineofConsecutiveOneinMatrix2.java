package leetcode;

/**
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
 * Example:
 * Input:
 * [[0,1,1,0],
 * [0,1,1,0],
 * [0,0,0,1]]
 * Output: 3
 */
// Brute Force

/**
 * Time complexity : O(n^2) We traverse along the entire matrix 4 times.
 * Space complexity : O(1). Constant space is used.
 */
public class LongestLineofConsecutiveOneinMatrix2 {
    public int longestLine(int[][] M) {
        if (M.length == 0) {
            return 0;
        }
        int ones = 0;
        // horizontal
        for (int i = 0; i < M.length; i++) {
            int count = 0;
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    count++;
                    ones = Math.max(ones, count);
                } else {
                    count = 0;
                }
            }
        }
        // vertical
        for (int i = 0; i < M[0].length; i++) {
            int count = 0;
            for (int j = 0; j < M.length; j++) {
                if (M[j][i] == 1) {
                    count++;
                    ones = Math.max(ones, count);
                } else count = 0;
            }
        }
        // upper diagonal
        for (int i = 0; i < M[0].length || i < M.length; i++) {
            int count = 0;
            for (int x = 0, y = i; x < M.length && y < M[0].length; x++, y++) {
                if (M[x][y] == 1) {
                    count++;
                    ones = Math.max(ones, count);
                } else count = 0;
            }
        }
        // lower diagonal
        for (int i = 0; i < M[0].length || i < M.length; i++) {
            int count = 0;
            for (int x = i, y = 0; x < M.length && y < M[0].length; x++, y++) {
                if (M[x][y] == 1) {
                    count++;
                    ones = Math.max(ones, count);
                } else count = 0;
            }
        }
        // upper anti-diagonal
        for (int i = 0; i < M[0].length || i < M.length; i++) {
            int count = 0;
            for (int x = 0, y = M[0].length - i - 1; x < M.length && y >= 0; x++, y--) {
                if (M[x][y] == 1) {
                    count++;
                    ones = Math.max(ones, count);
                } else count = 0;
            }
        }
        // lower anti-diagonal
        for (int i = 0; i < M[0].length || i < M.length; i++) {
            int count = 0;
            for (int x = i, y = M[0].length - 1; x < M.length && y >= 0; x++, y--) {
                // System.out.println(x+" "+y);
                if (M[x][y] == 1) {
                    count++;
                    ones = Math.max(ones, count);
                } else count = 0;
            }
        }
        return ones;
    }
}
