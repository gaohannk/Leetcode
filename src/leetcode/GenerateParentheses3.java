package leetcode;
/* Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses3 {
	public List<String> generateParenthesis(int n) {
		return generateParenthesis(n, n, n);
	}

	public List<String> generateParenthesis(int left, int right, int n) {
		List<String> prev = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		if (left == 0 && right == 0)
			result.add("");
		if (left > 0) {
			prev = generateParenthesis(left - 1, right, n);
			for (String s : prev) {
				s = "(" + s;
				result.add(s);
			}
		}
		if (right > left) {
			prev = generateParenthesis(left, right - 1, n);
			for (String s : prev) {
				s = ")" + s;
				result.add(s);
			}
		}
		return result;
	}
}
