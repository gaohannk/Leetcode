package leetcode.algo;

import java.util.Arrays;

/**
 * We have two integer sequences A and B of the same non-zero length.
 *
 * We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.
 *
 * At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
 *
 * Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
 *
 * Example:
 * Input: A = [1,3,5,4], B = [1,2,3,7]
 * Output: 1
 * Explanation:
 * Swap A[3] and B[3].  Then the sequences are:
 * A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
 * which are both strictly increasing.
 */
// Space (O(n))
public class MinimumSwapsToMakeSequencesIncreasing2 {
    public static int minSwap(int[] A, int[] B) {

        int n = A.length;
        int[] keep = new int[n], swap = new int[n];

        Arrays.fill(keep, Integer.MAX_VALUE);
        Arrays.fill(swap, Integer.MAX_VALUE);

        keep[0] = 0;
        swap[0] = 1;

        for (int i = 1; i < n; i++) {
            //from description: It is guaranteed that the given input always makes it possible.
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                //keep ? nothing do
                keep[i] = keep[i - 1];
                //since i-1 swap now swap again can make sure it follow the increasing rule
                swap[i] = swap[i - 1] + 1;
            }
            //happen together with the first if condition
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                // need swap but keep i ,so swap i-1,keep[i] could be keep[i-1] or +inf
                keep[i] = Math.min(keep[i], swap[i - 1]);
                //we do swap on i,so keep i-1 in original order if needed
                swap[i] = Math.min(swap[i], keep[i - 1] + 1);
            }
        }

        return Math.min(swap[n - 1], keep[n - 1]);
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 4};
        int[] B = {1, 2, 3, 7};
        System.out.println(minSwap(A, B));
    }
}
