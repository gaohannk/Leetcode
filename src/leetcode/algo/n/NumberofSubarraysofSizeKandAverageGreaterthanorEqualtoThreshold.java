package leetcode.algo.n;

public class NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int total = k * threshold;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= total) {
            res++;
        }
        for (int i = k; i < arr.length; i++) {
            sum -= arr[i - k];
            sum += arr[i];
            System.out.println(sum);
            if (sum >= total) {
                res++;
            }
        }
        return res;
    }
}
