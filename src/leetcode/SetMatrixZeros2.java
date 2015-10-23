package leetcode;
/* Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * click to show follow up.
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
/* 利用额外空间记录元素为0的行数和列数，空间复杂度O(m+n)
 */
public class SetMatrixZeros2 {
	public void setZeroes(int[][] matrix) {
		int row = matrix.length;
		if (row < 1)
			return;
		int col = matrix[0].length;
		boolean[] colRecorder = new boolean[col];
		boolean[] rowRecorder = new boolean[row];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					rowRecorder[i] = true;
					colRecorder[j] = true;
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (rowRecorder[i])
					matrix[i][j] = 0;
				else if (colRecorder[j])
					matrix[i][j] = 0;
			}
		}
	}
}
