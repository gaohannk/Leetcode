package company.amazon.oa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumLessThanK {
    public static int[] twoSumLessThanK(int[] A, int K) {
        if (A.length < 2)
            return new int[]{-1, -1};
        // Save original index
        Map<Integer, Integer> idMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            idMap.put(A[i], i);
        }
        Arrays.sort(A);

        int low = 0;
        int high = A.length - 1;
        int res = Integer.MIN_VALUE;
        int[] ret = new int[2];
        while (low < high) {
            int sum = A[low] + A[high];
            if (sum < K) {
                if (sum > res) {
                    res = sum;
                    ret[0] = idMap.get(A[low]);
                    ret[1] = idMap.get(A[high]);
                }
                low++;
            } else {
                high--;
            }
        }
        return res == Integer.MIN_VALUE ? new int[]{-1, -1} : ret;
    }

    public static void main(String[] args) {
        int[] A = new int[]{34, 23, 1, 24, 75, 33, 54, 8};
        int[] res = twoSumLessThanK(A, 60);
        System.out.println(res[0] + " " + res[1]);
    }
}
