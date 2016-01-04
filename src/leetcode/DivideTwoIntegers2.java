package leetcode;
/* Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers2 {
	public int divide(int dividend, int divisor) {
		boolean signA = dividend >= 0, signB = divisor > 0;
		long num = Math.abs((long) dividend), div = Math.abs((long) divisor), res = 0, curr = 0;
		// using Long division
		for (int idx = 31; idx >= 0; idx--) {
			curr <<= 1;
			curr |= ((num >> idx) & 1);
			res = res << 1;
			if (curr >= div) {
				curr -= div;
				res |= 1;
			}
		}
		if (signA ^ signB)
			return -(int) res;
		return (int) res;
	}
}
