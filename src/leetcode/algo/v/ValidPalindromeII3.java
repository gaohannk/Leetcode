package leetcode.algo.v;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */

/**
 * Time O(n)
 * Space O(n)
 */
public class ValidPalindromeII3 {
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return isPalindromeRange(s, i + 1, j) ||
                        isPalindromeRange(s, i, j - 1);
            }
        }
        return true;
    }

    public boolean isPalindromeRange(String s, int start, int end) {
        for (int k = start; k <= start + (end - start) / 2; k++) {
            if (s.charAt(k) != s.charAt(end - k + start))
                return false;
        }
        return true;
    }
}
