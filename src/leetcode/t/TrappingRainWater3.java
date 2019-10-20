package leetcode.t;
/* Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
// Brute Force
public class TrappingRainWater3 {
	public int trap(int[] A) {
		int ans = 0;
		for (int i = 1; i < A.length - 1; i++) {
			int max_left = 0, max_right = 0;
			for (int j = i; j >= 0; j--) { //Search the left part for max bar size
				max_left = Math.max(max_left, A[j]);
			}
			for (int j = i; j < A.length; j++) { //Search the right part for max bar size
				max_right = Math.max(max_right, A[j]);
			}
			ans += Math.min(max_left, max_right) - A[i];
		}
		return ans;
	}
}
