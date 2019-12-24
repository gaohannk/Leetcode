package leetcode.algo.m;

import java.util.*;

// Out loop len of substring
// In loop start index
public class MaximumNumberofOccurrencesofaSubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int max = 0;
        for (int i = maxSize; i >= minSize; i--) {
            Map<String, Integer> occurMap = new HashMap<>();
            for (int j = 0; j < s.length() - i + 1; j++) {
                String sub = s.substring(j, j + i);
                Set<Character> set = new HashSet<>();
                for (char c : sub.toCharArray()) {
                    set.add(c);
                    if (set.size() > maxLetters) {
                        break;
                    }
                }
                if (set.size() <= maxLetters) {
                    occurMap.put(sub, occurMap.getOrDefault(sub, 0) + 1);
                }
            }
            for (String key : occurMap.keySet()) {
                max = Math.max(max, occurMap.get(key));
            }
        }
        return max;
    }
}
