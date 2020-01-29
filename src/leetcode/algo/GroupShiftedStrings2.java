package leetcode.algo;

import java.util.ArrayList;
import java.util.HashMap;
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
public class GroupShiftedStrings2 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        if (strings == null || strings.length == 0)
            return ans;
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for (String s : strings) {
            char[] ch = s.toCharArray();
            int val = Integer.valueOf(ch[0]);
            int diff = val - 97;
            if (diff > 0) {
                for (int i = 0; i < s.length(); i++) {
                    if (ch[i] - diff < 97)
                        ch[i] = (char) (ch[i] + 26 - diff);
                    else
                        ch[i] = (char) (ch[i] - diff);
                }
            }
            String str = String.valueOf(ch);
            List<String> list;
            if (!hashmap.containsKey(str))
                list = new ArrayList<>();
            else
                list = hashmap.get(str);

            list.add(s);
            hashmap.put(str, list);

        }

        ans.addAll(hashmap.values());
        return ans;

    }
}
