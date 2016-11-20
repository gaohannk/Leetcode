package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
//Brute Force
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        HashMap<Integer, Integer> map = new HashMap();
        HashMap<Integer, Integer> map2 = new HashMap();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                int sum2 = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                map2.put(sum2, map2.getOrDefault(sum2, 0) + 1);

            }
        }

        for (Integer i : map.keySet()) {
            if (!map2.containsKey(-i))
                continue;
            res += map.get(i) * map2.get(-i);
        }
        return res;
    }
}
