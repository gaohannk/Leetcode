package company.qualtric;

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
public class LongestIncreasingPathinaMatrix3 {

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] memo = new int[row][col];
        int res = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                res = Math.max(res, dfs(matrix, i, j, memo));
                memo[i][j] = res;
            }
        }
        return res;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] memo) {
        // memory
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, x, y, memo));
            }
        }
        return ++memo[i][j];
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
