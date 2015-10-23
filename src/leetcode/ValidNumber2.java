package leetcode;
/* Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 */
/* 根据以下规则：
 * AeB代表A * 10 ^ B
 * e出现，A,B就必须同时存在，即e不可以在首位和末尾
 * A可以是小数也可以是整数，可以带正负号，B必须是整数，可以带正负号
 * .35, 00. valid小数，单独一个'.' invalid
 */
public class ValidNumber2 {
	public boolean isNumber(String s) {
		s = s.trim();
		if (s.length() > 0 && s.charAt(s.length() - 1) == 'e')
			return false;
		String[] t = s.split("e");
		if (t.length > 2)
			return false;
		boolean res = valid(t[0], false);
		if (t.length == 2)
			res = res && valid(t[1], true);
		return res;
	}
	private boolean valid(String s, boolean hasDot) {
		if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-'))
			s = s.substring(1);

		if (s.length() == 0 || s.equals("."))
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.') {
				if (hasDot)
					return false;
				hasDot = true;
			} else if (!('0' <= s.charAt(i) && s.charAt(i) <= '9')) {
				return false;
			}
		}
		return true;
	}
}
