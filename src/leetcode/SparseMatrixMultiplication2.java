package leetcode;

import java.util.ArrayList;

/* Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 * Example:
 * A = [
 *  [ 1, 0, 0],
 *  [-1, 0, 3]
 * ]
 * B = [
 *  [ 7, 0, 0 ],
 *  [ 0, 0, 0 ],
 *  [ 0, 0, 1 ]
 * ]
 *         |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 *    AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                      | 0 0 1 |
 */
public class SparseMatrixMultiplication2 {
	public int[][] multiply(int[][] A, int[][] B) {
		int res[][] = new int[A.length][B[0].length];
		ArrayList[] rowA = new ArrayList[A.length];
		for (int i = 0; i < A.length; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] != 0) {
					list.add(j);
					list.add(A[i][j]);
				}
			}
			rowA[i] = list;
		}
		for (int i = 0; i < A.length; i++) {
			ArrayList<Integer> list = rowA[i];
			for (int p = 0; p < list.size(); p += 2) {
				int colA = list.get(p);
				int valA = list.get(p + 1);
				for (int j = 0; j < B[0].length; i++) {
					res[i][j] += valA * B[colA][j];
				}
			}
		}
		return res;
	}
}
