package leetcode.algo.t;

import java.util.Arrays;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        if (A.length < 2)
            return -1;
        int res = Integer.MIN_VALUE;
        Arrays.sort(A);

        int low = 0;
        int high = A.length - 1;

        while (low < high) {
            int sum = A[low] + A[high];
            if (sum < K) {
                res = Math.max(res, sum);
                low++;
            } else {
                high--;
            }
        }
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
