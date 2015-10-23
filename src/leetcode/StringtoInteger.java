package leetcode;
/* Implement atoi to convert a string to an integer.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 */
public class StringtoInteger {
	public int atoi(String s) {
		int i = 0;
		boolean sign = true;
		int num = 0;
		long sum = 0;
		boolean flag = false;
		if (s.length() == 0)
			return 0;
		while (i < s.length()) {
			if (s.charAt(i) == '+' && !flag) {
				sign = true;
				flag = true;
			} else if (s.charAt(i) == '-' && !flag) {
				sign = false;
				flag = true;
			} else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				num = s.charAt(i) - '0';
				flag = true;
			} else if (s.charAt(i) == ' ' && !flag) {
				;
			} else
				break;

			i++;
			sum = sum * 10 + num;
			if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
				return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		return sign ? (int) sum : (int) -sum;
	}
}
