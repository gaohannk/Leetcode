package leetcode;

/* Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		
		int curMax = A[0];
		int curMin = A[0];
		int max = A[0];

		for (int i = 1; i < A.length; i++) {
			int temp = curMax * A[i];
			curMax = Math.max(A[i], Math.max(curMax * A[i], curMin * A[i]));
			curMin = Math.min(A[i], Math.min(temp, curMin * A[i]));
			max = Math.max(curMax, max);
		}
		return max;
	}
}
