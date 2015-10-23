package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on 
 * the row below.
 * For example, given the following triangle
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle.size() == 0)
			return 0;
		int[][] min = new int[triangle.size()][];
		for (int i = 0; i < triangle.size(); i++) {
			ArrayList<Integer> curr = triangle.get(i);
			for (int j = 0; j < curr.size(); j++) {
				if (j == 0 || j == curr.size() - 1)
					min[i][j] = min[i - 1][j] + curr.get(j);
				else if (j == curr.size() - 1)
					min[i][j] = min[i - 1][j - 1] + curr.get(j);
				else
					min[i][j] = curr.get(j) + Math.min(min[i - 1][j - 1], min[i - 1][j]);
			}
		}
		Arrays.sort(min[min.length - 1]);
		return min[min.length - 1][0];
	}
	
}
