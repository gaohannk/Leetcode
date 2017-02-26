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
public class ConvexPolygon {
    public int judge_side(int[] a, int[] b, int[] c){
        int ans = (a[1] - b[1]) * c[0] - c[1] * (a[0] - b[0]) + a[0] * b[1] - a[1] * b[0];
        return ans == 0 ? 0 : ans < 0 ? -1 : 1;
    }

    public boolean isConvex(int[][] points) {
        int n = points.length;
        int i;
        int turn = 0, next = 0;
        for (i = 0; i < n; i++) {
            next = judge_side(points[i], points[(i + 1) % n], points[(i + 2) % n]);
            if (next != turn)
                return false;
            turn = next;
        }
        return true;
    }
}
