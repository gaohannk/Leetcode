package leetcode.f;

import java.util.HashMap;

/**
 * Given a matrix mat where every row is sorted in increasing order, return the smallest common element in all rows.
 * <p>
 * If there is no common element, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
 * Output: 5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= mat.length, mat[i].length <= 500
 * 1 <= mat[i][j] <= 10^4
 * mat[i] is sorted in increasing order.
 */
public class FindSmallestCommonElementinAllRows {
    public int smallestCommonElement(int[][] mat) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                // Has to be appear in the first, trim.
                if (i != 0) {
                    if (map.get(mat[i][j]) == null) {
                        continue;
                    } else {
                        map.put(mat[i][j], map.getOrDefault(mat[i][j], 0) + 1);
                    }
                } else {
                    map.put(mat[i][j], 1);
                }
            }
        }

        for (Integer x : map.keySet()) {
            if (map.get(x) == mat.length)

                return x;
        }
        return -1;
    }
}
