package leetcode.algo.p;

/*
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 * Note:
 * n and k are non-negative integers.
 */
/*-- Define two DP arrays, diff[n] and same[i]. Where diff[i] means the number of ways for the fence i which has different color with fence i -1. same[i] means the number of ways if fence i has the same color with fence i - 1. 
  -- Initialization same[0] = 0, diff[0] = k.
  -- same[i] = diff[i - 1] * 1;  i and i -1 has "same" color
  -- diff[i] = (same[i - 1] + diff[i - 1]) * (k - 1); i and i-1 has "different" color
  -- Final state: same[n - 1] + diff[n - 1]. 
 */
public class PaintFence {
	public static int numWays(int n, int k) {
		if (n <= 0 || k <= 0)
			return 0;
		// i - 1 and i - 2 with the same color
		int[] same = new int[n];
		// i - 1 and i - 2 with diff. color
		int[] diff = new int[n];

		// Initialization
		same[0] = 0;
		diff[0] = k;
		for (int i = 1; i < n; i++) {
			same[i] = diff[i - 1];
			diff[i] = (k - 1) * (same[i - 1] + diff[i - 1]);
		}

		// Final state
		return same[n - 1] + diff[n - 1];
	}

	public static void main(String[] args){
		System.out.println(numWays(4, 5));
	}
}
