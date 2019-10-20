package leetcode.n;

/**
 * We are given an array A of positive integers, and two positive integers L and R (L <= R).
 * <p>
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R.
 * <p>
 * Example :
 * Input:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 * Note:
 * <p>
 * L, R  and A[i] will be an integer in the range [0, 10^9].
 * The length of A will be in the range of [1, 50000].
 */
public class NumberofSubarrayswithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res = 0;
        int i = 0;
        while (i < A.length) {
            int max = A[i];
            int j = i;
            for (; j < A.length; j++) {
                max = max > A[j] ? max : A[j];
                if (max > R) {
                    break;
                }
                if (max < L) {
                    continue;
                }
                res++;
//                System.out.println("start is " + i + " end is " + j);
            }
            i++;
        }
        return res;
    }
}
