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
public class IntegerBreak2 {
	public int integerBreak(int n) {
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		if (n == 4)
			return 4;
		int res[] = new int[n + 1];
		res[2] = 2;
		res[3] = 3;
		for (int k = 2; k <= n; k++) {
			for (int i = k - 4; i < k-1; i++) {
				if (res[i] * (k - i) > res[k])
					res[k] = res[i] * (k - i);
			}
		}
		return res[n];
	}
}
