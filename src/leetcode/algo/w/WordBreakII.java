package leetcode.algo.w;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */

public class WordBreakII {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String>[] dp = new LinkedList[s.length() + 1];
        List<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            List<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
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
