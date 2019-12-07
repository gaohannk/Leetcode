package leetcode.algo.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 890
 *
 * Two Map
 */
public class FindandReplacePattern2 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (String word : words) {
            if (match(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }

    public boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap();
        Map<Character, Character> map2 = new HashMap();

        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!map.containsKey(w)) {
                map.put(w, p);
            }
            if (!map2.containsKey(p)){
                map2.put(p,w);
            }

            if (map.get(w) != p || map2.get(p) != w)
                return false;
        }
        return true;
    }
}
