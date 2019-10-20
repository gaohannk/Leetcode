package leetcode.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 890
 * <p>
 * One Map
 */
public class FindandReplacePattern {
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
        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!map.containsKey(w)) {
                map.put(w, p);
            }

            if (map.get(w) != p)
                return false;
        }

        boolean[] seen = new boolean[26];
        for (char p : map.values()) {
            if (seen[p - 'a']) {
                return false;
            }
            seen[p - 'a'] = true;
        }
        return true;
    }
}
