package leetcode;
/* Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
import java.util.*;

public class GenerateParentheses2 {
	public class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> list = new ArrayList<String>();
			String str = "";
			generateParenthesis(1, 0, n, str + "(", list);
			return list;
		}
		public void generateParenthesis(int left, int right, int n, String str,
				List<String> list) {
			if (left + right == 2 * n)
				list.add(str);
			if (left < n) 
				generateParenthesis(left + 1, right, n, str + "(", list);			
			if (right < left) 
				generateParenthesis(left, right + 1, n, str + ")", list);
		}
	}
}
