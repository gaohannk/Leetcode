package leetcode;

import java.util.Arrays;

/**
 * Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
 * <p>
 * Note:
 * Both the string's length and k will not exceed 104.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "ABAB", k = 2
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 * <p>
 * Input:
 * s = "AABABBA", k = 1
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int start = 0;
        int maxCount = 0;
        int res = 0;
        for (int end = 0; end < s.length(); end++) {
            freq[s.charAt(end) - 'A']++;
            if (maxCount < freq[s.charAt(end) - 'A'])
                maxCount = freq[s.charAt(end) - 'A'];
            while (end - start - maxCount + 1 > k) {
                freq[s.charAt(start) - 'A']--;
                start++;
                for (int i = 0; i < 26; i++) {
                    if (maxCount < freq[i]) {
                        maxCount = freq[i];
                    }

                }
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
