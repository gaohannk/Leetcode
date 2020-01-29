package leetcode.algo;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 *
 * Example:
 *
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output:
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new LinkedList<>();
        for (String s : strings) {
            if (res.size() == 0) {
                List<String> list = new LinkedList<>();
                list.add(s);
                res.add(list);
                continue;
            }
            boolean added = false;
            for (List<String> list : res) {
                if (isShirtSequence(s, list.get(0))) {
                    list.add(s);
                    added = true;
                    break;
                }
            }
            if (!added) {
                List<String> list = new LinkedList<>();
                list.add(s);
                res.add(list);
            }
        }
        return res;
    }

    private boolean isShirtSequence(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            int diff = t.charAt(i) - s.charAt(i);
            int diff2 = t.charAt(i - 1) - s.charAt(i - 1);
            if (diff < 0) {
                diff += 26;
            }
            if (diff2 < 0) {
                diff2 += 26;
            }
            if (diff != diff2) {
                return false;
            }
        }
        return true;
    }
}
