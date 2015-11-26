package leetcode;

import java.util.HashMap;
import java.util.Map;

/* Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
/*
 * The stop condition is 出现重复余数 && 商也同样出现过
 * Note : 负数 和 整数
 */
public class FractiontoRecurringDecimal2 {
	public String fractionToDecimal(int numerator, int denominator) {
		StringBuffer ans = new StringBuffer();
		Map<Long, Integer> map = new HashMap<>();
		String sign;
		if ((numerator == 0) || (numerator >= 0 && denominator > 0) || (numerator < 0 && denominator < 0)) {
			sign = "";
		} else {
			sign = "-";
		}
		ans.append(sign);
		long lnumerator = Math.abs((long) numerator);
		long ldenominator = Math.abs((long) denominator);

		ans.append(lnumerator / ldenominator);
		long r = lnumerator % ldenominator;
		if (r > 0) {
			ans.append(".");
		} else {
			return ans.toString();
		}

		while (!map.containsKey(r) && r > 0) {
			map.put(r, ans.length());
			ans.append(10 * r / ldenominator);
			r = (10 * r % ldenominator);
		}
		if (r > 0) {
			long len = map.get(r);
			ans.insert((int) len, "(");
			ans.append(")");
		}

		return ans.toString();

	}
}
