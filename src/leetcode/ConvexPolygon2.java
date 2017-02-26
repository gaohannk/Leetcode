package leetcode;

/**
 * Given a list of points that form a polygon when joined sequentially, find if this polygon is convex (Convex polygon definition).
 * <p>
 * Note:
 * <p>
 * There are at least 3 and at most 10,000 points.
 * Coordinates are in the range -10,000 to 10,000.
 * You may assume the polygon formed by given points is always a simple polygon (Simple polygon definition). In other words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise don't intersect each other.
 * Example 1:
 * <p>
 * [[0,0],[0,1],[1,1],[1,0]]
 * <p>
 * Answer: True
 * <p>
 * Explanation:
 * Example 2:
 * <p>
 * [[0,0],[0,10],[10,10],[10,0],[5,5]]
 * <p>
 * Answer: False
 * <p>
 * Explanation:
 */
public class ConvexPolygon2 {
    public int crossProduct(int[] p0, int[] p1, int[] p2) {
        return (p2[0] - p0[0]) * (p1[1] - p0[1]) - (p1[0] - p0[0]) * (p2[1] - p0[1]);
    }

    public boolean isConvex(int[][] points) {
        int n = points.length;
        int last = 0;
        for (int i = 0; i < n; i++) {
            int[] p0 = points[i];
            int[] p1 = points[(i + 1) % n];
            int[] p2 = points[(i + 2) % n];
            int p = crossProduct(p0, p1, p2);
            if (p * last < 0)
                return false;
            last = p;
        }
        return true;
    }
}
