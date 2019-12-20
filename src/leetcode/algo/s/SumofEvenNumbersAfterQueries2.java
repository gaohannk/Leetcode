package leetcode.algo.s;


import java.util.Arrays;

public class SumofEvenNumbersAfterQueries2 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int S = Arrays.stream(A).filter(x-> x%2==0).sum();
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0) S -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) S += A[index];
            ans[i] = S;
        }

        return ans;
    }
}
