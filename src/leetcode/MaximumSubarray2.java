package leetcode;

/* Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */

public class MaximumSubarray2 {
	public int maxSubArray(int[] A) {
		int max = A[0];
		int maxEndHere = A[0];
		for (int i = 1; i < A.length; i++) {
			maxEndHere = Math.max(A[i], maxEndHere + A[i]);
			max = Math.max(max, maxEndHere);
		}
		return max;
	}

}
