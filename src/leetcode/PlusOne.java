package leetcode;
/* Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length; i >= 0; i--) {
			int sum = digits[i] + carry;
			digits[i] = sum % 10;
			carry = sum / 10;
		}
		if (carry == 1) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			for (int i = 1; i < res.length; i++)
				res[i] = digits[i - 1];
			return res;
		}
		return digits;
	}
}
