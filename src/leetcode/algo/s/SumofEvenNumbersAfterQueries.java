package leetcode.algo.s;


import java.util.Arrays;

public class SumofEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = Arrays.stream(A).filter( x-> x%2==0).sum();

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0) {
                if (val % 2 == 0) {
                    sum += val;
                } else {
                    sum -= A[index];
                }
            } else {
                if (val % 2 == 0) {
                    ans[i] = sum;
                } else {
                    sum += A[index] + val;
                }
            }
            ans[i] = sum;
            A[index] += val;
        }

        return ans;
    }

}
