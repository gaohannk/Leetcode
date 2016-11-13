package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class NumberofBoomerangs2 {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Long, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    long d = distanceSquare(points[i], points[j]);
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
            }
            for (int v : map.values()) {
                if (v > 1) {
                    count += v * (v - 1);
                }
            }
        }
        return count;
    }

    private long distanceSquare(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}
