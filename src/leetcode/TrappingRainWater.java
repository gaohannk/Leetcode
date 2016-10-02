package leetcode;
/* Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
/* 核心思想是：考虑每一个i能trap的water, 对某个值A[i]来说，能trapped的最多的water取决于在左边i右边的最高的值
 * 如果min(left,right) > A[i]，那么在i这个位置上能trapped的water就是min(left,right) – A[i]。
 */
public class TrappingRainWater {
	public int trap(int[] A) {
		int max = 0;
		int[] max_left = new int[A.length];
		int[] max_right = new int[A.length];
		int contain = 0;
		for (int i = 0; i < A.length; i++) {
			if (max < A[i])
				max = A[i];
			max_left[i] = max;
		}
		max = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			if (max < A[i])
				max = A[i];
			max_right[i] = max;
			contain += Math.min(max_left[i], max_right[i]) - A[i];
		}
		return contain;
	}
}
