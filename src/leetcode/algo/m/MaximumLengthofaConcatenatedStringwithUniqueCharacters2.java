package leetcode.algo.m;

import java.util.HashSet;
import java.util.List;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 *
 * Return the maximum possible length of s.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */
public class MaximumLengthofaConcatenatedStringwithUniqueCharacters2 {
    private int maxLen;

    private boolean isUniq(String s) {
        HashSet<String> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c + ""))
                return false;
            set.add(c+"");
        }
        return true;
    }

    private void explore(List<String> arr, StringBuilder sb, int start) {
        int len = sb.length();
        maxLen = Math.max(maxLen, len);
        if (start == arr.size()) {
            return;
        }
        for (int i = start; i < arr.size(); i++) {
            sb.append(arr.get(i));
            if (isUniq(sb.toString())) {
                explore(arr, sb, i + 1);
            }
            sb.setLength(len);
        }
    }

    public int maxLength(List<String> arr) {
        maxLen = Integer.MIN_VALUE;
        explore(arr, new StringBuilder(), 0);
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
