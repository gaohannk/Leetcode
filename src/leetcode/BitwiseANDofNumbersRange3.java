package leetcode;
/* Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 */
public class BitwiseANDofNumbersRange3 {
	public int rangeBitwiseAnd(int m, int n) {
		int r = Integer.MAX_VALUE;
		while ((m & r) != (n & r))
			r = r << 1;
		return n & r;
	}
}
