package leetcode.s;

/**
 * Given a string text, we are allowed to swap two of the characters in the string. Find the length of the longest substring with repeated characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text = "ababa"
 * Output: 3
 * Explanation: We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. Then, the longest repeated character substring is "aaa", which its length is 3.
 * Example 2:
 * <p>
 * Input: text = "aaabaaa"
 * Output: 6
 * Explanation: Swap 'b' with the last 'a' (or the first 'a'), and we get longest repeated character substring "aaaaaa", which its length is 6.
 * Example 3:
 * <p>
 * Input: text = "aaabbaaa"
 * Output: 4
 * Example 4:
 * <p>
 * Input: text = "aaaaa"
 * Output: 5
 * Explanation: No need to swap, longest repeated character substring is "aaaaa", length is 5.
 * Example 5:
 * <p>
 * Input: text = "abcdef"
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= text.length <= 20000
 * text consist of lowercase English characters only.
 */
public class SwapForLongestRepeatedCharacterSubstring {
    public int maxRepOpt1(String text) {
        int[] left = new int[text.length()];
        int[] right = new int[text.length()];
        int[] times = new int[26];
        int count = 0, res = 0;
        int i = 1;
        while (i < text.length()) {
            while (i < text.length() && text.charAt(i) == text.charAt(i - 1)) {
                i++;
            }
            times[text.charAt(i - 1) - 'a']++;
            i++;
        }
        if (i == text.length()) {
            times[text.charAt(i) - 'a']++;
        }

        for (i = 0; i < text.length(); i++) {
            if (i == 0) {
                left[i] = 0;
                count = 1;
                continue;
            }
            if (text.charAt(i) == text.charAt(i - 1)) {
                left[i] = count;
                count++;
            } else {
                left[i] = count;
                count = 1;
            }
        }
        count = 0;
        for (i = text.length() - 1; i >= 0; i--) {
            if (i == text.length() - 1) {
                right[i] = 0;
                count = 1;
                continue;
            }
            if (text.charAt(i) == text.charAt(i + 1)) {
                right[i] = count;
                count++;
            } else {
                right[i] = count;
                count = 1;
            }
        }

        res = 0;
        for (i = 1; i < text.length() - 1; i++) {
            if (text.charAt(i) != text.charAt(i - 1)) {
                if (text.charAt(i - 1) == text.charAt(i + 1)) {
                    if (times[text.charAt(i - 1) - 'a'] > 2) {
                        // aaaxaaa...a
                        res = Math.max(res, left[i] + right[i] + 1);
                    } else {
                        // aaaxaaa
                        res = Math.max(res, left[i] + right[i]);
                    }
                } else {
                    // aaaxbbb or aaaxbbb...a
                    res = Math.max(res, left[i] + (times[text.charAt(i - 1) - 'a'] > 1 ? 1 : 0));
                }
            }
        }
        // last char
        if (text.charAt(i) != text.charAt(i - 1)) {
            if (times[text.charAt(i - 1) - 'a'] >= 2) {
                // a...aaax
                res = Math.max(res, left[i] + 1);
            } else {
                // aaax
                res = Math.max(res, left[i]);
            }
        } else {
            if (times[text.charAt(i - 1) - 'a'] >= 2) {
                // a...aaax
                res = Math.max(res, left[i] + 2);
            } else {
                // aaax
                res = Math.max(res, left[i] + 1);
            }
        }
        return res;
    }
}
