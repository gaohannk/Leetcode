package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/* Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int height[] = new int[matrix[0].length];
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1')
					height[j]++;
				else {
					height[j] = 0;
				}
			}
			for (int k = i + 1; k > 0; k--) {
				for (int j = 0; j < matrix[0].length - k; j++) {
					boolean flag = true;
					for (int m = j; m < j + k; m++) {
						if (height[m] < k) {
							flag = false;
						}
					}
					if (flag) {
						int area = k * k;
						res = res > area ? res : area;
					}
				}
			}
		}
		return res;
	}

}
