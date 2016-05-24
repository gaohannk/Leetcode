package leetcode;

/* Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne2 {
	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += carry;
				return digits;
			} else {
				digits[i] = 0;
				carry = 1;
			}
		}
		// case digits = 999
		if (carry == 1) {
			int res[] = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}
		return digits;
	}
}
