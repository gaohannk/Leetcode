package leetcode.algo.m;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// Out loop start index
// In loop len of substring
public class MaximumNumberofOccurrencesofaSubstring2 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        int j;
        while (i <= s.length() - minSize) {
            j = i + minSize;
            while (j <= s.length() && j <= i + maxSize) {
                //  j=i+min;
                String sub = s.substring(i, j);
                if (!isUnique(sub, maxLetters)) {
                    break;
                } else {
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                    j++;
                }
            }
            i++;
        }
        int res = 0;
        for (int x : map.values()) {
            res = Math.max(res, x);
        }
        return res;
    }

    public boolean isUnique(String s, int n) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            if (set.size() > n) {
                return false;
            }
        }
        return true;
    }
}
