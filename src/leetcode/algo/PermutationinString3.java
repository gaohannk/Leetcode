package leetcode.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 * Note:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class PermutationinString3 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        Map<Character, Integer> s1map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            Map<Character, Integer> s2map = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                s2map.put(s2.charAt(i + j), s2map.getOrDefault(s2.charAt(i + j), 0) + 1);
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    public boolean matches(Map<Character, Integer> s1map, Map<Character, Integer> s2map) {
        for (char key : s1map.keySet()) {
            if (!s2map.containsKey(key)) {
                return false;
            }
            if (s1map.get(key) != s2map.get(key)) {
                return false;
            }
        }
        return true;
    }
}
