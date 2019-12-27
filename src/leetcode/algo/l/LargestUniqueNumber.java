package leetcode.algo.l;

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (int value : map.keySet()) {
            if (map.get(value) == 1) {
                max = Math.max(value, max);
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}
