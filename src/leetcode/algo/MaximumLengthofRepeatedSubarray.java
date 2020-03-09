package leetcode.algo;

import java.util.Arrays;
// TODO
public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        dp[A.length - 1][B.length - 1] = A[A.length - 1] == B[B.length - 1] ? 1 : 0;
        for (int i = A.length - 2; i >= 0; i--) {
            dp[i][B.length - 1] = A[i] == B[B.length - 1] ? 1 : 0;
            dp[i][B.length - 1] = Math.max(dp[i][B.length - 1], dp[i + 1][B.length - 1]);
        }

        for (int j = B.length - 2; j >= 0; j--) {
            dp[A.length - 1][j] = A[A.length - 1] == B[j] ? 1 : 0;
            dp[A.length - 1][j] = Math.max(dp[A.length - 1][j], dp[A.length - 1][j + 1]);
        }
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = B.length - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j + 1] + A[i] == B[j] ? 1 : 0;
                dp[i][j] = Math.max(Math.max(dp[i][j], dp[i + 1][j]), dp[i][j + 1]);
            }
        }
        for(int[] d: dp){
            System.out.println(Arrays.toString(d));
        }
        return dp[0][0];
    }
}
