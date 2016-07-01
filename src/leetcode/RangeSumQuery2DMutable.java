package leetcode;

import leetcode.RangeSumQuery2DMutable2.NumMatrix;

/* Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DMutable {
	public static class NumMatrix {
		private int[][] dp;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
				return;
			}
			int m = matrix.length;
			int n = matrix[0].length;

			dp = new int[m + 1][n + 1];
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
				}
			}
		}

		public void update(int row, int col, int val) {
			int oldValue = dp[row + 1][col + 1] - dp[row + 1][col] - dp[row][col + 1] + dp[row][col];
			for (int i = row + 1; i < dp.length; i++) {
				for (int j = col + 1; j < dp[0].length; j++) {
					dp[i][j] = dp[i][j] - oldValue + val;
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int iMin = Math.min(row1, row2);
			int iMax = Math.max(row1, row2);
			int jMin = Math.min(col1, col2);
			int jMax = Math.max(col1, col2);
			return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];
		}

		public void print(int[][] mat) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[0].length; j++) {
					System.out.print(mat[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		NumMatrix numMatrix = new NumMatrix(matrix);
		System.out.println(numMatrix.sumRegion(0, 0, 2, 2));
		numMatrix.print(numMatrix.dp);
		numMatrix.update(1, 1, 1);
		numMatrix.print(numMatrix.dp);

		// numMatrix.update(1, 10);
	}

	// Your NumMatrix object will be instantiated and called as such:
	// NumMatrix numMatrix = new NumMatrix(matrix);
	// numMatrix.sumRegion(0, 1, 2, 3);
	// numMatrix.sumRegion(1, 2, 3, 4);

}
