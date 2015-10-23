package leetcode;
/* Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class TrappingRainWater2 {
	public int trap(int[] A) {
		int left = 0, right = A.length - 1;
		int curlevel = 0, contain = 0, block = 0;
		while (left <= right) {
			if (Math.min(A[left], A[right]) > curlevel) {
				contain += (Math.min(A[left], A[right]) - curlevel)
						* (right - left + 1);
				curlevel = Math.min(A[left], A[right]);
			}
			if (A[left] < A[right])
				block += A[left++];
			else
				block += A[right--];
		}
		return contain - block;
	}
}
