package company.microsoft.oa;

/**
 * You are given a string s of length n containing only characters a and b. A substring of s called a semi-alternating substring if it does not contain three identical consecutive characters. Return the length of the longest semi-alternating substring.
 *
 * Example 1:
 *
 * Input: "baaabbabbb"
 * Output: 7
 * Explanation: "aabbabb"
 * Example 2:
 *
 * Input: "abaaaa"
 * Output: 4
 * Explanation: "abaa"
 */
public class LongestSemiAlternatingSubstring {
    public static String findLongestSemiAlteringSubstring(String s) {
        char[] arr = s.toCharArray();
        if (arr.length < 3) {
            return s;
        }
        String res = "";
        int len = arr.length, a = 0, b = 0, left = 0, right = 0, max = 0;
        while (right < len) {
            char c = arr[right];
            if (c == 'a') {
                b = 0;
                a++;
            } else if (c == 'b') {
                a = 0;
                b++;
            }
            if (a < 3 && b < 3) {
                if (right - left + 1 > max) {
                    max = right - left + 1;
                    res = s.substring(left, right + 1);
                }
            } else {
                left = right - 1;
                if (a == 3) {
                    a = 2;
                } else if (b == 3) {
                    b = 2;
                }
            }
            right++;
        }
        return res;
    }

    private String findLongestSemiAlteringSubstring2(String s) {
        String res = "";
        int len = 0;
        if (s == null) {
            return null;
        }
        if (s.length() < 3) {
            return s;
        }
        int left = 0;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2))
                left = i - 1;
            if (i - left + 1 > len) {
                len = i - left + 1;
                res = s.substring(left, i + 1);
            }
        }
        return res;
    }
}
