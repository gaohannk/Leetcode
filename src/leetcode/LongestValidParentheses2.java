package leetcode;

/* Given a string containing just the characters '(' and ')',  * find the length of the longest 
 * valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
// d[i] means max valid length starts with i
public class LongestValidParentheses2 {
	public int longestValidParentheses(String s) {
		if (s.length() == 0)
			return 0;
		int maxLen = 0;
		int[] d = new int[s.length()];
		d[s.length() - 1] = 0;
		for (int i = s.length() - 2; i >= 0; i--) {
			if (s.charAt(i) == ')')
				d[i] = 0;
			else {
				int j = (i + 1) + d[i + 1];
				if (j < s.length() && s.charAt(j) == ')') {
					d[i] = d[i + 1] + 2; // (()())的外包情况
					if (j + 1 < s.length())
						d[i] += d[j + 1];// ()()的后面还有的情况
				} else
					d[i] = 0;
			}
			maxLen = Math.max(maxLen, d[i]);
		}
		return maxLen;
	}
}
