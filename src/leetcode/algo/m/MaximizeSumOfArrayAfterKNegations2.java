package leetcode.algo.m;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)
 *
 * Return the largest possible sum of the array after modifying it in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [4,2,3], K = 1
 * Output: 5
 * Explanation: Choose indices (1,) and A becomes [4,-2,3].
 * Example 2:
 *
 * Input: A = [3,-1,0,2], K = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 * Example 3:
 *
 * Input: A = [2,-3,-1,5,-4], K = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 */
public class MaximizeSumOfArrayAfterKNegations2 {
    public int largestSumAfterKNegations(int[] A, int k) {
        Arrays.sort(A);
        // keep fliping the negative values in the array, untilthere is no more negative values or k reaches zero or we are at the end of the array
        int idx = 0;
        for (; idx < A.length; ++idx) {
            if (k > 0 && A[idx] < 0) {
                k--;
                A[idx] = -A[idx];
            } else {
                break;
            }
        }

        /**
         at this stage, if k is even, we just skip this step and calculate the sum
         if k is odd,
         if idx is zero, which means whole array are all positive numbers at the begining, we simply flip the first value
         if idx >= A.length, we are at the end of the array, flip the last value in the array
         if A[idx] >= A[idx - 1], we are at middle of the array, and we want to flip the smallest value in the array
         which is either A[idx], or A[idx - 1], so we compare them and flip the smaller one
         **/
        if (k % 2 != 0) {
            if (idx == 0) // at the start
                A[idx] = -A[idx];
            else if (idx >= A.length || A[idx] >= A[idx - 1]) // at the end or middle
                A[idx - 1] = -A[idx - 1];
            else // at the middle
                A[idx] = -A[idx];
        }

        return Arrays.stream(A).sum();
    }
}
