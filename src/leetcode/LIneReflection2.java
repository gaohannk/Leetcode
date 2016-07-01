package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/* Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.
 * Example 1:
 * Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?

Hint:

Find the smallest and largest x-value for all points.
If there is a line then it should be at y = (minX + maxX) / 2.
For each point, make sure that it has a reflected point in the opposite side.
*/
public class LIneReflection2 {
	public boolean isReflected(int[][] points) {
		if (points == null)
			return true;
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		double mid = 0;
		for (int i = 0; i < points.length; i++) {
			if (!map.containsKey(points[i][0]))
				map.put(points[i][0], new HashSet<Integer>(points[i][1]));
			else
				map.get(points[i][0]).add(points[i][1]);
			mid += points[i][0];
		}
		mid /= points.length;
		for (int i = 0; i < points.length; i++) {
			int reflect = (int) Math.round((mid * 2 - points[i][0]));
			if (!map.containsKey(reflect) || map.get(reflect).contains(points[i][1]))
				return false;
		}
		return true;
	}
}
