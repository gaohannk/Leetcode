package leetcode;

/* Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 */
public class BitwiseANDofNumbersRange {

	public static int rangeBitwiseAnd(int m, int n) {
		if (getNumofBit(n) > getNumofBit(m))
			return 0;
		int bit = getNumofBit(m);
		int res = 0;
		while (bit-- > 0) {
			if (((m >> bit) & 1) != 1 || ((n >> bit) & 1) != 1)
				break;
			if (((m >> bit) & 1) == 1 && ((n >> bit) & 1) == 1)
				res += Math.pow(2, bit);
		}
		return res;
	}

	private static int getNumofBit(int m) {
		int count = 0;
		while (m != 0) {
			count++;
			m = m >> 1;
		}
		return count;
	}
}
