package leetcode.algo.m;

/**
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 * <p>
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 108]
 */
public class MaximumSwap2 {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        // 0-9 last time appear
        int[] lastAppear = new int[10];
        for (int i = 0; i < A.length; i++) {
            lastAppear[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (lastAppear[d] > i) {
                    char tmp = A[i];
                    A[i] = A[lastAppear[d]];
                    A[lastAppear[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
}
