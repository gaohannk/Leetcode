package leetcode.algo.n;

import java.util.Arrays;

/**
 * Given a string s consisting only of characters a, b and c.
 *
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * Example 2:
 *
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 *
 * Input: s = "abc"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 */
// Brute Force TLE O(n^2)
public class NumberofSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int[] a = new int[s.length()];
        int[] b = new int[s.length()];
        int[] c = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            getFirstOccur(s, a, i, 'a');
            getFirstOccur(s, b, i, 'b');
            getFirstOccur(s, c, i, 'c');
        }

        for (int i = 0; i < s.length(); i++) {
            if (a[i] == -1 || b[i] == -1 || c[i] == -1) {
                break;
            }
            int max = Math.max(Math.max(a[i], b[i]), c[i]);
            res += s.length() - max;
        }
        return res;
    }

    private void getFirstOccur(String s, int[] a, int start, char c) {
        int idx = s.substring(start).indexOf(c);
        if (idx == -1) {
            a[start] = -1;
        } else {
            a[start] = idx + start;
        }
    }
}
