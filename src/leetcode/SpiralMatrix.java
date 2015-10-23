package leetcode;

import java.util.ArrayList;

/* For example,
 * Given the following matrix:
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)   
            return list;
		int startx = 0, endx = matrix.length - 1;
		int starty = 0, endy = matrix[0].length - 1;
		while (startx <= endx && starty <= endy) {
			for (int i = starty; i <= endy; i++)
				list.add(matrix[startx][i]);
			for (int i = startx + 1; i <= endx; i++)
				list.add(matrix[i][endy]);
			if (startx != endx) {
				for (int i = endy - 1; i >= starty; i--)
					list.add(matrix[endx][i]);

			}
			if (starty != endy) {
				for (int i = endx - 1; i > startx; i--)
					list.add(matrix[i][starty]);
			}
			startx++;
			endx--;
			starty++;
			endy--;
		}
		return list;
	}
}
