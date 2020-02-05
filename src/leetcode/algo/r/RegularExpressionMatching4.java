package leetcode.algo.r;

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
public class RegularExpressionMatching4 {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
