package leetcode;

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

/**
 * Preprocess: arr[] contains max char right hand side from i. e.g. 91837 -> arr: {9.8,8,7,7}
 * <p>
 * Main: swap with the biggest number on c[i]'s right side, and the biggest number from right to left, and do the swap and return.
 * <p>
 * There are two greedy ideas in this:
 * <p>
 * Scan c[] from left to right, and do swap as soon as we find such a c[i] with larger number on its right.
 * When searching for larger number, search from right side, to result in smallest new number, in case there are multiple such larger number.
 */
public class MaximumSwap3 {
    public int maximumSwap(int num) {
        char[] c = String.valueOf(num).toCharArray();
        int[] rightLargest = new int[c.length];
        int max = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            max = Math.max(max, c[i] - '0');
            rightLargest[i] = max;
        }

        for (int i = 0; i < c.length - 1; ++i) {
            if (c[i] - '0' < rightLargest[i + 1]) {
                for (int j = c.length - 1; j >= i + 1; --j) {
                    if (c[j] - '0' == rightLargest[i + 1]) {
                        c[j] = c[i];
                        c[i] = (char) (rightLargest[i + 1] + '0');
                        return Integer.valueOf(String.valueOf(c));
                    }
                }
            }
        }
        return num;
    }
}
