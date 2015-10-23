package leetcode;
/* Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
	public String addBinary(String a, String b) {    
		if (a == null || a.length() == 0)
			return b;
		if (b == null || b.length() == 0)
			return a;
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		StringBuilder res = new StringBuilder();
		while (i >= 0 && j >= 0) {
			int digit = (int) (a.charAt(i) - '0' + b.charAt(j) - '0') + carry;
			carry = digit / 2;
			digit %= 2;
			res.insert(0, digit);
			i--;
			j--;
		}
		while (i >= 0) {
			int digit = (int) (a.charAt(i) - '0') + carry;
			carry = digit / 2;
			digit %= 2;
			res.insert(0, digit);
			i--;
		}
		while (j >= 0) {
			int digit = (int) (b.charAt(j) - '0') + carry;
			carry = digit / 2;
			digit %= 2;
			res.insert(0, digit);
			j--;
		}
		if (carry > 0) {
			res.insert(0, carry);
		}
		return res.toString();
	}
}
