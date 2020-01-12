package leetcode.algo.w;

import java.util.*;

/* Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */

public class WordBreakII2 {

    static Map<Integer, List<String>> map = new HashMap<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }

    public static List<String> helper(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = helper(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        List<String> dict = new LinkedList<>();
        dict.add("aaaa");
        dict.add("aaa");
        // dict.add("and");
        // dict.add("sand");
        // dict.add("dog");
        String s = "aaaaaaa";
        System.out.println(wordBreak(s, dict));
    }

}
