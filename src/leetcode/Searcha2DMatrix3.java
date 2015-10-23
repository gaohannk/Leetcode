package leetcode;
/* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class Searcha2DMatrix3 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null)
			return false;
		return searchMatrix(matrix, 0, matrix.length, 0, matrix[0].length,
				target);
	}
	public boolean searchMatrix(int[][] matrix, int rows, int rowe, int cs,
			int ce, int target) {
		if (rows >= rowe || cs >= ce)
			return false;
		if (target == matrix[rows][ce - 1])
			return true;
		else if (target < matrix[rows][ce - 1])
			return searchMatrix(matrix, rows, rowe, cs, ce - 1, target);
		else
			return searchMatrix(matrix, rows + 1, rowe, cs, ce, target);
	}
}
