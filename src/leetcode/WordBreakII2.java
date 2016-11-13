package leetcode;

import java.util.*;

/* Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */

public class WordBreakII2 {

    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0 || dict == null)
            return res;
        if (wordBreakcheck(s, dict)) // Prune
            helper(s, dict, 0, "", res);
        return res;
    }

    private static void helper(String s, Set<String> dict, int start, String item, ArrayList<String> res) {
        if (start >= s.length()) {
            res.add(item);
            return;
        }

        StringBuilder str = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            str.append(s.charAt(i));
            if (dict.contains(str.toString())) {
                String newItem = new String();
                if (item.length() > 0)
                    newItem = item + " " + str.toString();
                else
                    newItem = str.toString();
                helper(s, dict, i + 1, newItem, res);
            }
        }
    }

    public static boolean wordBreakcheck(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true; // set first to be true, why?
        // Because we need initial state
        for (int i = 0; i <= s.length(); i++) {
            // should continue from match position
            for (int j = i; j >= 0; j--) {
                if (t[j] && dict.contains(s.substring(j, i))) {
                    t[i] = true;
                    break;
                }
            }
        }
        return t[s.length()];
    }

    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("aaaa");
        dict.add("aaa");
        // dict.add("and");
        // dict.add("sand");
        // dict.add("dog");
        String s = "aaaaaaa";
        System.out.println(wordBreak(s, dict));
    }

}
