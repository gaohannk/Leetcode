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
public class RemoveKDigits {
	 public static String removeKdigits(String num, int k) {
			List<String> res = new LinkedList<>();
			StringBuilder sb = new StringBuilder(num);
			helper(k, 0, sb, res);
			int min = Integer.MAX_VALUE;
			for (String s : res) {
				min = min < Integer.parseInt(s) ? min : Integer.parseInt(s);
			}
			return String.valueOf(min);
		}

		private static void helper(int k, int start, StringBuilder cur, List<String> res) {
			if (k == 0) {
				cur = getDeleteNum(cur);
				res.add(cur.toString().equals("") ? "0" : cur.toString());
				return;
			}
			for (int i = start; i < cur.toString().length(); i++) {
				String digit = cur.charAt(i) + "";
				cur.replace(i, i + 1, "#");
				//System.out.println(cur.toString());
				helper(k - 1, i + 1, cur, res);
				cur.replace(i, i + 1, digit);
			}
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
		String num = "10";
		int k = 2;
		System.out.println(removeKdigits(num, k));
	}
}
