package leetcode;

import java.util.LinkedList;
import java.util.List;

/*Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/
//Memory Limit Exceeded
public class RemoveKDigits2 {
	public static String removeKdigits(String num, int k) {
		StringBuilder sb = new StringBuilder(num);
		String min[] = new String[1];
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < 10000000; i++) {
			temp.append("9");
		}
		min[0]= temp.toString();
		helper(k, 0, sb, min);
		return min[0];
	}

	private static void helper(int k, int start, StringBuilder cur, String[] min) {
		if (k == 0) {
			cur = getDeleteNum(cur);
			String value = cur.toString().equals("") ? "0" : cur.toString();
			min[0] = getMin(value, min[0]);
			return;
		}
		for (int i = start; i < cur.toString().length(); i++) {
			String digit = cur.charAt(i) + "";
			cur.replace(i, i + 1, "#");
			System.out.println(cur.toString());
			helper(k - 1, i + 1, cur, min);
			cur.replace(i, i + 1, digit);
		}
	}

	private static String getMin(String value, String min) {
		if (value.length() < min.length())
			return value;
		else if (value.length() > min.length())
			return min;
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) < min.charAt(i))
				return value;
			else if (value.charAt(i) > min.charAt(i))
				return min;
		}
		return value;
	}

	private static StringBuilder getDeleteNum(StringBuilder cur) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < cur.length(); i++) {
			if (cur.charAt(i) != '#')
				str.append(cur.charAt(i));
		}
		return str;
	}

	public static void main(String[] args) {
		String num = "10200";
		int k = 1;
		System.out.println(removeKdigits(num, k));
	}
}
