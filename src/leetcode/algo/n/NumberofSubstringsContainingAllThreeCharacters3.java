package leetcode.algo.n;

import java.util.LinkedList;
import java.util.Queue;

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
public class NumberofSubstringsContainingAllThreeCharacters3 {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int[] counter = new int[3];

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            counter[s.charAt(right) - 'a']++;
            while (containsABC(counter)) {
                res += s.length() - right;
                counter[s.charAt(left) - 'a']--;
                left++;
            }
            right++;

        }
        return res;
    }

    private boolean containsABC(int[] counter) {
        for (int c : counter) {
            if (c == 0) {
                return false;
            }
        }

        return true;
    }
}
