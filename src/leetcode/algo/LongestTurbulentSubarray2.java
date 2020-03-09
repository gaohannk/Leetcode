package leetcode.algo;

public class LongestTurbulentSubarray2 {
    public int maxTurbulenceSize(int[] A) {
        int res = 1;
        int start = 0;

        for (int i = 1; i < A.length; i++) {
            int flag = Integer.compare(A[i-1], A[i]);
            if (flag == 0) {
                start = i;
            } else if (i == A.length - 1 || flag * Integer.compare(A[i], A[i+1]) != -1) {
                res = Math.max(res, i - start + 1);
                start = i;
            }
        }

        return res;
    }
}
