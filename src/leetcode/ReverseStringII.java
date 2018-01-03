package leetcode;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        String res = "";
        if (s.length() < k)
            return new StringBuilder(s).reverse().toString();
        int len = s.length();
        for (int i = 0; i < s.length(); i += 2 * k) {
            if (i + k < len)
                res += new StringBuilder(s.substring(i, i + k)).reverse() + s.substring(i + k, Math.min(i + 2 * k, len));
            else
                res += new StringBuilder(s.substring(i, len)).reverse();
        }
        return res;
    }
}
