package leetcode;

import java.util.Set;

/*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
/* Time: O(string length * dict size)
 * Define an array t[] such that t[i]==true => 0-(i-1) can be segmented using dictionary
 * Initial state t[0] == true
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true; // set first to be true, why?
        // Because we need initial state

        for (int i = 0; i <= s.length(); i++) {
            // should continue from match position
            if (!t[i])
                continue;
            for (String a : dict) {
                int end = i + a.length();
                if (end <= s.length() && !t[end] && s.substring(i, end).equals(a))
                    t[end] = true;
            }
        }
        return t[s.length()];
    }
}
