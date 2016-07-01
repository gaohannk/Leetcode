package leetcode;


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
 * 	// Your NumMatrix object will be instantiated and called as such:
	// NumMatrix numMatrix = new NumMatrix(matrix);
	// numMatrix.sumRegion(0, 1, 2, 3);
	// numMatrix.sumRegion(1, 2, 3, 4);
 */
public class RangeSumQuery2DMutable2 {
	public static class NumMatrix {
		private int[][] arrs;
		private int[][] Bindex;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0)
				return;
			int row = matrix.length, col = matrix[0].length;
			this.arrs = new int[row][col];
			this.Bindex = new int[row + 1][col + 1];

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					update(i, j, matrix[i][j]);
					arrs[i][j] = matrix[i][j];
				}
			}
		}

		public void update(int row, int col, int val) {
			int diff = val - arrs[row][col];
			arrs[row][col] = val;
			for (int i = row + 1; i < Bindex.length; i += (i & -i)) {
				for (int j = col + 1; j < Bindex[0].length; j += (j & -j)) {
					Bindex[i][j] += diff;
				}
			}
		}

		public int getSum(int row, int col) {
			int sum = 0;
			for (int i = row + 1; i > 0; i -= (i & -i)) {
				for (int j = col + 1; j > 0; j -= (j & -j)) {
					sum += Bindex[i][j];
				}
			}
			return sum;
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			return getSum(row2, col2) - getSum(row1 - 1, col2) - getSum(row2, col1 - 1) + getSum(row1 - 1, col1 - 1);
		}

		public void print(int[][] mat) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[0].length; j++) {
					System.out.print(mat[i][j] + "  ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		NumMatrix numMatrix = new NumMatrix(matrix);
		System.out.println(numMatrix.sumRegion(0, 0, 2, 2));
		numMatrix.print(numMatrix.Bindex);
		numMatrix.update(1, 1, 0);
		System.out.println(numMatrix.sumRegion(0, 0, 2, 2));
		numMatrix.print(numMatrix.Bindex);

		// numMatrix.update(1, 10);
	}
}
