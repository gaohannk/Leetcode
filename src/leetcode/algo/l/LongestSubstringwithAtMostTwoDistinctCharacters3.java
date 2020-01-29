package leetcode.algo.l;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters3 {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 3)
            return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 1;
        map.put(s.charAt(0), 1);
        int max = 2;
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            // update result
            if (map.keySet().size() <= 2) {
                if (max < j - i + 1) {
                    max = j - i + 1;
                }
            } else {
                while (map.keySet().size() > 2) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eeecccbbbb"));
    }
}
