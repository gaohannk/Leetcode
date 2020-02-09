package leetcode.algo;

public class NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold2 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int[] preSum = new int[arr.length + 1];
        int res = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        for (int i = k; i < preSum.length; i++) {
            if (preSum[i] - preSum[i - k] >= k * threshold)
                res++;
        }
        return res;
    }
}
