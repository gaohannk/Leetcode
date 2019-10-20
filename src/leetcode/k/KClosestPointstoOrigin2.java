package leetcode.k;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class KClosestPointstoOrigin2 {

    public int[][] kClosest(int[][] points, int K) {
        //create priorityQueue in descending order n2-n1
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> dist(n2) - dist(n1));
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > K)
                pq.poll();
        }

        //convert pq to array
        int[][] res = new int[K][2];
        int index = 0;
        while (!pq.isEmpty()) {
            res[index] = pq.poll();
            index++;
        }

        return res;

    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
