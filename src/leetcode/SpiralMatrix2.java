package leetcode;

import java.util.ArrayList;

/* For example,
 * Given the following matrix:
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix2 {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		int minX, minY, maxX, maxY, x, y;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// special case
		if (matrix == null || matrix.length == 0)
			return list;
		// initial variable
		minX = minY = 0;
		maxX = matrix.length - 1;
		maxY = matrix[0].length - 1;

		for (; minX <= maxX && minY <= maxY; minX++, minY++, maxX--, maxY--) {
			x = minX;
			y = minY;
			list.add(matrix[x][y]);

			// only a row
			if (minX == maxX) {
				for (y += 1; y <= maxY; y++) {
					list.add(matrix[x][y]);
				}
				break;
			}
			// only a column
			if (minY == maxY) {
				for (x += 1; x <= maxX; x++) {
					list.add(matrix[x][y]);
				}
				break;
			}
			// a square
			for (y += 1; y <= maxY; y++) { // top
				list.add(matrix[x][y]);
				if (y == maxY)
					break;
			}
			for (x += 1; x <= maxX; x++) { // right
				list.add(matrix[x][y]);
				if (x == maxX)
					break;
			}
			for (y -= 1; y >= minY; y--) { // bottom
				list.add(matrix[x][y]);
				if (y == minY)
					break;
			}
			for (x -= 1; x > minX; x--) { // left
				list.add(matrix[x][y]);
				if (x == minX + 1)
					break;
			}
		}
		return list;
	}
}
