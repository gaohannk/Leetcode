package leetcode.algo;

/**
 * 30
 * /    \
 * 24     5
 * /    \
 * 12    12
 * /  \   / \
 * 6    2  4  3
 * <p>
 * <p>
 * 30
 * /     \
 * 24       15
 * /   \    /  \
 * 12    4  3    5
 * /  \
 * 6    2
 */
public class MinimumCostTreeFromLeafValues {
	public int mctFromLeafValues(int[] arr) {
		int dp[][] = new int[arr.length][arr.length];
		return helper(arr, 0, arr.length, dp);
	}

	public static int helper(int[] arr, int start, int end, int[][] dp) {
		if (start == end - 1) {
			return arr[start];
		}
		int min = Integer.MAX_VALUE;
		for (int k = start; k < end; k++) {
			int maxLeft = 0, maxRight = 0;
			for (int i = start; i <= k; i++) {
				maxLeft = Math.max(arr[i], maxLeft);
			}
			for (int i = k + 1; i < end; i++) {
				maxRight = Math.max(arr[i], maxRight);
			}
			min = Math.min(min, maxLeft * maxRight + helper(arr, start, k, dp) + helper(arr, k + 1, end, dp));
		}
		return min;
	}
}
