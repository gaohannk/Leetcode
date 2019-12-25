package leetcode.algo.m;

/**
 * Given an array arr of positive integers, consider all binary trees such that:
 *
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
 * The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
 * Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.
 *
 *     24            24
 *    /  \          /  \
 *   12   4        6    8
 *  /  \               / \
 * 6    2             2   4
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * It is guaranteed that the answer fits into a 32-bit signed integer (ie. it is less than 2^31).
 */

/**
 *       30
 *     /    \
 *   24      5
 * /    \
 * 12    12
 * /  \   / \
 * 6  2  4  3
 * <p>
 * <p>
 *       30
 *    /     \
 *   24       15
 * /   \    /  \
 * 12    4  3    5
 * /  \
 * 6    2
 */
public class MinimumCostTreeFromLeafValues {
    public static int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        int[][] max = new int[len][len];
        for (int i = 0; i < len; i++) {
            max[i][i] = arr[i];
            for (int j = i + 1; j < len; j++) {
                max[i][j] = Math.max(arr[j], max[i][j - 1]);
            }
        }
        Integer[][] dp = new Integer[len][len];
        return helper(0, len - 1, arr, dp, max);
    }

    public static int helper(int start, int end, int[] arr, Integer[][] dp, int[][] max) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            res = Math.min(res, max[start][i] * max[i + 1][end] + helper(start, i, arr, dp, max) + helper(i + 1, end, arr, dp, max));
        }
        dp[start][end] = res;
        return res;
    }
}
