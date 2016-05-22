package leetcode;

/* Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: you may assume that n is not less than 2.
 * Hint:
 * There is a simple O(n) solution to this problem.
 * You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 * */
// dynamic programming
//	h[n]=max(h[n-4]*4, h[n-3]*3, h[n-2]*2)
//TLE
public class IntegerBreak3 {
	public int integerBreak(int n) {
		return helper(n, false);
	}

	private int helper(int n, boolean b) {

		if (b == false) {
			if (n == 2)
				return 1;
			if (n == 3)
				return 2;
			if (n == 4)
				return 4;
		} else {
			if (n == 1)
				return 1;
			if (n == 2)
				return 2;
			if (n == 3)
				return 3;
			if (n == 4)
				return 4;
		}
		int res = 0;
		for (int i = n - 4; i < n - 1; i++) {
			if (helper(i, true) * (n - i) > res)
				res = helper(i, true) * (n - i);
		}
		return res;
	}
}
