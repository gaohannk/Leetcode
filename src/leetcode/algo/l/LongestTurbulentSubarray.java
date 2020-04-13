package leetcode.algo.l;

public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int start = 0, end = 1;
        int res = 1;
        while (end < A.length) {
            // Pass same value
            while (end < A.length && A[end] == A[end - 1]) {
                end++;
            }
            if (end == A.length) {
                break;
            }
            start = end - 1;
            int flag = A[start] < A[end] ? 1 : -1;
            end++;
            while (end < A.length) {
                if (flag == 1 && A[end - 1] > A[end]) {
                    flag = -1;
                    end++;
                } else if (flag == -1 && A[end - 1] < A[end]) {
                    flag = 1;
                    end++;
                } else {
                    break;
                }
            }
            res = Math.max(res, end - start);
        }
        return res;
    }
}
