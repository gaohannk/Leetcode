package leetcode.algo.t;
/* Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
/* 核心思想是：考虑每一个i能trap的water, 对某个值A[i]来说，能trapped的最多的water取决于在左边i右边的最高的值
 * 如果min(left,right) > A[i]，那么在i这个位置上能trapped的water就是min(left,right) – A[i]。
 * minimum of maximum height of bars on both the sides minus its own height.
 * Time; O(n)
 * Space: O(n)
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		int len = height.length;
		if (height == null || len == 0) {
			return 0;
		}

		int[] maxLeft = new int[len];
		int[] maxRight = new int[len];
		maxLeft[0] = height[0];
		maxRight[len - 1] = height[len - 1];
		for (int i = 1; i < len; i++) {
			maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
		}
		for (int i = len - 2; i >= 0; i--) {
			maxRight[i] = Math.max(height[i], maxRight[i + 1]);
		}
		int sum = 0;
		for (int i = 1; i < len - 1; i++) {
			sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
		}
		return sum;
	}
}
