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
/* 时间复杂度是O(logm+logn)，空间上只需两个辅助变量，是O(1)
 */
public class Searcha2DMatrix2 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int l = 0;
		int r = matrix.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (matrix[mid][0] == target)
				return true;
			if (matrix[mid][0] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		int targetrow = r;
		if (targetrow < 0)
			return false;
		l = 0;
		r = matrix[0].length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (matrix[targetrow][mid] == target)
				return true;
			if (matrix[targetrow][mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return false;
	}
}
