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
/* Overall, there are 2 different cases: 1) the second char of pattern is "*" , and 2) the second char of pattern is not "*".
 * 1)if the first char of pattern is not ".", the first char of pattern and string should be the same. 
 * Then continue to match the left part.
 * 2)if the first char of pattern is "." or first char of pattern == the first i char of string, continue to match the left.
 */
public class RegularExpressionMatching3 {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0)
			return s.length() == 0;

		// length == 1 is the case that is easy to forget.
		// as p is subtracted 2 each time, so if original
		// p is odd, then finally it will face the length 1
		if (p.length() == 1)
			return (s.length() == 1) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

		// next char is not '*': must match current character
		if (p.charAt(1) != '*') {
			if (s.length() < 1)
				return false;
			else
				return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
		}
		// next char is *
		while (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s, p.substring(2)))
				return true;
			s = s.substring(1);
		}
		return isMatch(s, p.substring(2));
	}

}
