package leetcode;

/*Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/
public class SumofTwoIntegers {
	public int getSum(int a, int b) {
		int res = 0;
		int count = 0;
		int xor = 1;
		while (a != 0 || b != 0 || count != 0) {
			if ((a & 1) == 1 && (b & 1) == 1) {
				res = count == 0 ? res ^ 0 : res ^ xor;
				count = 1;
			}
			if ((a & 1) == 0 && (b & 1) == 0) {
				res = count == 0 ? res ^ 0 : res ^ xor;
				count = 0;
			} else {
				res = count == 0 ? res ^ xor : res ^ 0;
			}
			xor <<= 1;
			a >>>= 1;
			b >>>= 1;
		}
		return res;
	}
}
