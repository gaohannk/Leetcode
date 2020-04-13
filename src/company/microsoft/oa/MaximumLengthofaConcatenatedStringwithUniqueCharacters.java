package company.microsoft.oa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        int[] max = new int[1];
        dfs(arr, new ArrayList<>(), 0, max);
        return max[0];
    }

    public void dfs(List<String> arr, List<String> temp, int start, int[] max) {
        if (start == arr.size()) {
            int count = 0;
            for (String s : temp) {
                count += s.length();
            }
            max[0] = Math.max(max[0], count);
            return;
        }
        for (int i = start; i < arr.size(); i++) {
            temp.add(arr.get(i));
            if (isUnique(temp)) {
                dfs(arr, temp, i + 1, max);
                temp.remove(temp.size() - 1);
            } else {
                temp.remove(temp.size() - 1);
                dfs(arr, temp, i + 1, max);
            }
        }
    }

    public boolean isUnique(List<String> list) {
        Set<Character> set = new HashSet();
        for (String s : list) {
            for (char c : s.toCharArray()) {
                if (!set.add(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
