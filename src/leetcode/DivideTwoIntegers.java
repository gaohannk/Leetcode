package leetcode;

/*Divide two integers without using multiplication, division and mod operator.*/

public class DivideTwoIntegers {
	// 不符合题目要求，使用了乘法。
	public int divide(int dividend, int divisor) {
		long result = 0;
		boolean sign1 = dividend < 0 ? true : false;
		boolean sign2 = divisor < 0 ? true : false;
		long dividend_l = dividend, divisor_l = divisor;
		if (dividend_l < 0)
			dividend_l = 0 - dividend_l;
		if (divisor_l < 0)
			divisor_l = 0 - divisor_l;
		while (dividend_l >= divisor_l) {
			int multi = 1;
			while (divisor_l * multi <= (dividend_l >> 1)) {
				multi = multi << 1;
			}
			result += multi;
			dividend_l -= divisor_l * multi;
		}
		if (sign1 ^ sign2)
			return (int) -result;
		return (int) result;
	}
}
