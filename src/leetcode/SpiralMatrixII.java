package leetcode;
/* Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int startx = 0;
		int starty = 0;
		int endx = n - 1;
		int endy = n - 1;
		int num = 1;
		while (startx <= endx && starty <= endy) {
			for (int i = starty; i <= endy; i++) {
				matrix[startx][i] = num;
				num++;
			}
			for (int i = startx + 1; i <= endx; i++) {
				matrix[i][endy] = num;
				num++;
			}
			if (startx != endx) {
				for (int i = endy - 1; i >= starty; i--) {
					matrix[endx][i] = num;
					num++;
				}
			}
			if (starty != endy) {
				for (int i = endx - 1; i > startx; i--) {
					matrix[i][starty] = num;
					num++;
				}
			}
			startx++;
			endx--;
			starty++;
			endy--;
		}
		return matrix;
	}
}
