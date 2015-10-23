package leetcode;
/* Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * click to show follow up.
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
/* 1.先确定第一行和第一列是否有零，即是否需要清零，用两个标志位记录。
 * 2.扫描剩下的矩阵元素，如果遇到了0，就将对应的第一行和第一列上的元素赋值为0，这里不用担心会将本来第一行或第一列的1改成了0，因为这些值最后注定要成为0的。
 * 3.根据第一行和第一列的信息，已经可以将剩下的矩阵元素赋值为结果所需的值了。即，拿第一行为例，如果扫描到一个0，就将这一列都清0.
 * 4.根据1中确定的状态，处理第一行和第一列。如果最开始得到的第一行中有0的话，就整行清零。同理对列进行处理。
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		// using first row and col as storage
		// 1.search zero in first row and column to determine it's own status
		boolean firstzerorow = false;
		boolean firstzerocol = false;
		for (int ci = 0; ci < cols; ++ci) {
			if (matrix[0][ci] == 0) {
				firstzerorow = true;
				break;
			}
		}
		for (int ri = 0; ri < rows; ++ri) {
			if (matrix[ri][0] == 0) {
				firstzerocol = true;
				break;
			}
		}
		// 2.search zeros in other position to sign the first row and col
		for (int ri = 1; ri < rows; ++ri) {
			for (int ci = 1; ci < cols; ++ci) {
				if (matrix[ri][ci] == 0) {
					matrix[0][ci] = 0;
					matrix[ri][0] = 0;
				}
			}
		}
		// 3.set zeroes in other positions according to first col and row
		for (int ri = 1; ri < rows; ++ri) {
			for (int ci = 1; ci < cols; ++ci) {
				if (matrix[0][ci] == 0 || matrix[ri][0] == 0) {
					matrix[ri][ci] = 0;
				}
			}
		}
		// 4.set zeroes for first row and col
		if (firstzerorow) {
			for (int ci = 0; ci < cols; ++ci) {
				matrix[0][ci] = 0;
			}
		}
		if (firstzerocol) {
			for (int ri = 0; ri < rows; ++ri) {
				matrix[ri][0] = 0;
			}
		}
	}
}
