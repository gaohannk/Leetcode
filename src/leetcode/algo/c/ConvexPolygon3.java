package leetcode.algo.c;

import java.util.List;

/**
 * For any triplet of ordered points in a convex polygon, their orientation should remain the same : counterclockwise, clockwise, or colinear.
 */
public class ConvexPolygon3 {

    public boolean isConvex(List<List<Integer>> points) {
        int sz = points.size();
        int flag = 0;
        for (int i = 0; i < points.size(); i++) {
            int ori = getOrientation(points.get(i % sz), points.get((i + 1) % sz), points.get((i + 2) % sz));
            if (ori == 0) { // cannot decide the result
                continue;
            }
            if (flag == 0) {
                flag = ori;
            } else {
                if (flag != ori) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Utility Method to get the orientation of 3 ordered points
     * @param p1
     * @param p2
     * @param p3
     * @return 0 if colinear, 1 if clockwise, 2 if counterclockwise
     */
    public int getOrientation(List<Integer> p1, List<Integer> p2, List<Integer> p3) {
        int val = (p3.get(0) - p2.get(0)) * (p2.get(1) - p1.get(1)) - (p2.get(0) - p1.get(0)) * (p3.get(1) - p2.get(1));
        if (val < 0) {
            return 2;
        }
        if (val == 0) {
            return 0;
        }
        return 1;
    }

}
