package leetcode;

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
import java.util.HashMap;
import java.util.HashSet;

public class FractiontoRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		String res = "";
		if (numerator < 0 ^ denominator < 0) 
			res += "-";
		denominator = Math.abs(denominator);
		numerator = Math.abs(numerator);
		int beforedot = numerator / denominator;
		res += beforedot;
		int residue = numerator - beforedot * denominator;
		if (residue == 0)
			return res;
		res = res + '.';
		
		int index = 1;
		boolean isrepeat = false;
		int quo=0;
		while (residue != 0) {
			residue *= 10;
			 quo = residue / denominator;
			residue = residue - residue / denominator * denominator;
			if (map.containsKey(residue)) {
				isrepeat = true;
				break;
			}
			set.add(quo);
			map.put(residue, index);
			index++;
			res = res + quo;
		}
		if (isrepeat) {
			res = res + quo;
			res = res.substring(0, res.length() - index + map.get(residue)) + "("
					+ res.substring(res.length() - index + map.get(residue));
			res += ")";
		}
		return res;
	}

	public static void main(String[] args) {
		int a = 1;
		int b = 7;
		System.out.println(Double.toString((double) a / b));
		System.out.println(fractionToDecimal(a, b));
		System.out.println(Math.abs((long)Integer.MIN_VALUE));
	}
}
