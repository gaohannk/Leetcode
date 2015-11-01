package leetcode;

/* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Searcha2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		int startx = 0;
		int starty = 0;
		int endx = matrix.length-1;
		int endy = matrix[0].length-1;
		return helper(matrix, startx, starty, endx, endy, target);
	}

	private boolean helper(int[][] matrix, int startx, int starty, int endx, int endy, int target) {
		if (startx == endx - 1 || starty == endy - 1 || startx == endx || starty == endy) {
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i][endy] == target)
					return true;
				if (endy - 1 >= 0 && matrix[i][endy - 1] == target)
					return true;
			}
			for (int i = 0; i < matrix[0].length; i++) {
				if (matrix[endx][i] == target)
					return true;
				if (endx - 1 >= 0 && matrix[endx - 1][i] == target)
					return true;
			}
			return false;
		}
		int midx = (startx + endx) / 2;
		int midy = (starty + endy) / 2;
		if (matrix[midx][midy] == target)
			return true;
		else if (matrix[midx][midy] > target) {
			endx = midx;
			endy = midy;
			return helper(matrix, startx, starty, endx, endy, target);
		} else {
			startx = midx;
			starty = midy;
			return helper(matrix, startx, starty, endx, endy, target);
		}
	}
}
