package leetcode;
/* Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
//TLE
public class MaximalRectangle2 {
	public int maximalRectangle(char[][] matrix) {
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
				for (int l = matrix[0].length - 1; l > 0; l--) {
					for (int j = 0; j < matrix[0].length - l; j++) {
						boolean flag = true;
						for (int m = j; m < j + l; m++) {
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
		}
		return res;
	}
}
