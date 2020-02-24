package leetcode.algo.l;

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
// Naive DFS Solution
public class LongestIncreasingPathinaMatrix2 {

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //static int res = 0;

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[1];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                dfs(matrix, i, j, 1, res);
            }
        }
        return res[0];
    }

    private static void dfs(int[][] matrix, int i, int j, int len, int[] res) {
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                dfs(matrix, x, y, len + 1, res);
            }
        }
        res[0] = Math.max(res[0], len);
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
