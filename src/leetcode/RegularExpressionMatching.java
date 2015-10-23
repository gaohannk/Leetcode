package leetcode;
/* Implement regular expression matching with support for '.' 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
/* 假设现在走到s的i位置，p的j位置，情况分为下列两种： 
 * (1)p[j+1]不是'*'。
 * 情况比较简单，只要判断当前s的i和p的j上的字符是否一样（p在j上的字符是'.',也是相同），如果不同，返回false，否则，递归下一层i+1，j+1; 
 * (2)p[j+1]是'*'。
 * 那么此时看从s[i]开始的子串，假设s[i],s[i+1],...s[i+k]都等于p[j]那么意味着这些都有可能是合适的匹配，
 * 那么递归对于剩下的(i,j+2),(i+1,j+2),...,(i+k,j+2)都要尝试（j+2是因为跳过当前和下一个'*'字符）。 
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		return helper(s, p, 0, 0);
	}

	private boolean helper(String s, String p, int i, int j) {
		if (j == p.length())
			return i == s.length();
		// p.charAt(j+1)!='*'
		if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
			if (i == s.length() || s.charAt(i) != p.charAt(j) && p.charAt(j) != '.')
				return false;
			else
				return helper(s, p, i + 1, j + 1);
		}
		// p.charAt(j+1)=='*'
		while (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
			if (helper(s, p, i, j + 2))
				return true;
			i++;
		}
		return helper(s, p, i, j + 2);
	}
}
