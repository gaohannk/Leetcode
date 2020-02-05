package company.linkedin;

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

public class RegularExpressionMatching4 {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // match zero previous || use * match the following text
            return isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern));
        } else {
            // a match a or a match .
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
