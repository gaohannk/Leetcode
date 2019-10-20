package leetcode.b;

import java.util.*;

/**
 * Given a list of phrases, generate a list of Before and After puzzles.
 *
 * A phrase is a string that consists of lowercase English letters and spaces only. No space appears in the start or the end of a phrase. There are no consecutive spaces in a phrase.
 *
 * Before and After puzzles are phrases that are formed by merging two phrases where the last word of the first phrase is the same as the first word of the second phrase.
 *
 * Return the Before and After puzzles that can be formed by every two phrases phrases[i] and phrases[j] where i != j. Note that the order of matching two phrases matters, we want to consider both orders.
 *
 * You should return a list of distinct strings sorted lexicographically.
 *
 *
 *
 * Example 1:
 *
 * Input: phrases = ["writing code","code rocks"]
 * Output: ["writing code rocks"]
 *
 * Example 2:
 *
 * Input: phrases = ["mission statement",
 *                   "a quick bite to eat",
 *                   "a chip off the old block",
 *                   "chocolate bar",
 *                   "mission impossible",
 *                   "a man on a mission",
 *                   "block party",
 *                   "eat my words",
 *                   "bar of soap"]
 * Output: ["a chip off the old block party",
 *          "a man on a mission impossible",
 *          "a man on a mission statement",
 *          "a quick bite to eat my words",
 *          "chocolate bar of soap"]
 *
 * Example 3:
 *
 * Input: phrases = ["a","b","a"]
 * Output: ["a"]
 *
 *
 *
 * Constraints:
 *
 *     1 <= phrases.length <= 100
 *     1 <= phrases[i].length <= 100
 */
public class BeforeandAfterPuzzle {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, List<String>> suffix = new HashMap<>();
        for (int i = 0; i < phrases.length; i++) {
            String p = phrases[i];
            int sufIndex = p.lastIndexOf(" ");
            String suf = p;
            if (sufIndex != -1) {
                suf = p.substring(sufIndex + 1);
            }
            suffix.putIfAbsent(suf, new ArrayList<>());
            suffix.get(suf).add(p + "#" + i);
        }
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < phrases.length; i++) {
            String p = phrases[i];
            int preIndex = p.indexOf(" ");
            String pre = p;
            String right = "";
            if (preIndex != -1) {
                pre = p.substring(0, preIndex);
                right = p.substring(preIndex + 1);
            }
            if (suffix.containsKey(pre)) {
                List<String> list = suffix.get(pre);
                for (String s : list) {
                    String[] r = s.split("#");
                    if (Integer.parseInt(r[1]) != i) {
                        String temp = r[0] + " " + right;
                        set.add(temp.trim());
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
