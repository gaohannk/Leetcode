package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of distinct integers sorted in ascending order, return the smallest index i that satisfies A[i] == i.  Return -1 if no such i exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [-10,-5,0,3,7]
 * Output: 3
 * Explanation:
 * For the given array, A[0] = -10, A[1] = -5, A[2] = 0, A[3] = 3, thus the output is 3.
 * Example 2:
 * <p>
 * Input: [0,2,5,8,17]
 * Output: 0
 * Explanation:
 * A[0] = 0, thus the output is 0.
 * Example 3:
 * <p>
 * Input: [-10,-5,3,4,7,9]
 * Output: -1
 * Explanation:
 * There is no such i that A[i] = i, thus the output is -1.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length < 10^4
 * -10^9 <= A[i] <= 10^9
 */
public class FixedPoint {
    public int fixedPoint(int[] A) {
        int n = A.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (A[i] == i)
                return i;
        }

        return -1;
    }
}
