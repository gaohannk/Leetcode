package leetcode;
/* Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
import java.util.*;


public class GenerateParentheses4 {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		if (n == 0) {
			result.add("");
		} else if (n == 1) {
			result.add("()");
		} else {
			for (int i = 1; i <= n - 1; i++) {
				List<String> left = generateParenthesis(i);
				List<String> right = generateParenthesis(n - i);
				for (String leftstr : left) {
					for (String rightstr : right) {
						if (!result.contains(leftstr + rightstr))
							result.add(leftstr + rightstr);
					}
				}
			}
			for (int i = 1; i <= n - 1; i++) {
				List<String> left = generateParenthesis(i);
				List<String> right = generateParenthesis(n - i - 1);
				for (String leftstr : left) {
					for (String rightstr : right) {
						if (!result.contains("(" + leftstr + rightstr + ")"))
							result.add("(" + leftstr + rightstr + ")");
					}
				}
			}
		}
		return result;
	}
}
