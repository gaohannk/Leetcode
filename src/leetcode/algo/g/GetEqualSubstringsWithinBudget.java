package leetcode.algo.g;

/**
 * You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.
 * <p>
 * You are also given an integer maxCost.
 * <p>
 * Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.
 * <p>
 * If there is no substring from s that can be changed to its corresponding substring from t, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcd", t = "bcdf", maxCost = 3
 * Output: 3
 * Explanation: "abc" of s can change to "bcd". That costs 3, so the maximum length is 3.
 * Example 2:
 * <p>
 * Input: s = "abcd", t = "cdef", maxCost = 3
 * Output: 1
 * Explanation: Each character in s costs 2 to change to charactor in t, so the maximum length is 1.
 * Example 3:
 * <p>
 * Input: s = "abcd", t = "acde", maxCost = 0
 * Output: 1
 * Explanation: You can't make any change, so the maximum length is 1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s and t only contain lower case English letters.
 */
public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int diff[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int max = 0, p1 = 0, res = 0;
        for (int i = 0; i < diff.length; i++) {
            max += diff[i];
            while (max > maxCost) {
                max -= diff[p1];
                p1++;
            }
            res = Math.max(res, i - p1);

        }
        return res;
    }
}
