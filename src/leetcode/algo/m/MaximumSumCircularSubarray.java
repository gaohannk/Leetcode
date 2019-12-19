package leetcode.algo.m;

/**
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 * <p>
 * Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 * <p>
 * Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 * Example 2:
 * <p>
 * Input: [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 * Example 3:
 * <p>
 * Input: [3,-1,2,-1]
 * Output: 4
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 * Example 4:
 * <p>
 * Input: [3,-2,2,-3]
 * Output: 3
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 * Example 5:
 * <p>
 * Input: [-2,-3,-1]
 * Output: -1
 * Explanation: Subarray [-1] has maximum sum -1
 */

/**
 * For example, if A = [0, 1, 2, 3, 4, 5, 6] is the underlying buffer of our circular array,
 * we could represent the subarray [2, 3, 4] as one interval [2, 4][2,4],
 * but we would represent the subarray [5, 6, 0, 1] as two intervals [5, 6], [0, 1][5,6],[0,1].
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int N = A.length;

        int ans = A[0], cur = A[0];
        for (int i = 1; i < N; ++i) {
            cur = A[i] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }

        /**
         * ans is the answer for 1-interval subarrays.
         * Now, let's consider all 2-interval subarrays.
         *For each i, we want to know
         *the maximum of sum(A[j:]) with j >= i+2
         */
        // rightsums[i] = A[i] + A[i+1] + ... + A[N-1]
        int[] rightsums = new int[N];
        rightsums[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; --i)
            rightsums[i] = rightsums[i + 1] + A[i];

        // maxright[i] = max_{j} rightsums[j] for j>=i
        int[] maxright = new int[N];
        maxright[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; --i)
            maxright[i] = Math.max(maxright[i + 1], rightsums[i]);

        int leftsum = 0;
        for (int i = 0; i < N - 2; ++i) {
            leftsum += A[i];
            ans = Math.max(ans, leftsum + maxright[i + 2]);
        }

        return ans;
    }
}
