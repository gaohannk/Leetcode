package leetcode;
/* Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
/* generate well-formed parentheses with n pairs from n-1 pairs
 */
import java.util.*;

public class GenerateParentheses {
	public class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> list = new ArrayList<String>();
			if (n == 0)
				list.add("");
			else if (n == 1)
				list.add("()");
			else {
				List<String> prev = generateParenthesis(n - 1);
				for (String s : prev) {
					for (int i = 0; i < s.length(); i++) {
						if (s.charAt(i) == '(')
							s = insertInside(s, i);
						if (!list.contains(s))
							list.add(s);
					}
					if (!list.contains(s))
						list.add("()" + s);
				}
			}
			return list;
		}

		public String insertInside(String s, int i) {
			String left = s.substring(0, i+1);
			String right = s.substring(i+1);
			return left + "()" + right;
		}
	}
}
