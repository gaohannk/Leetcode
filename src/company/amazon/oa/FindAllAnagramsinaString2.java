package company.amazon.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
// Slide window
public class FindAllAnagramsinaString2 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return res;
        }
        if (s.length() < p.length()) {
            return res;
        }

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        for (int i = 0; i < p.length() - 1; i++) {
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
        }
        int start = 0;
        for (int i = p.length() - 1; i < s.length(); start++, i++) {
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
            if (isAnagram(map, map2))
                res.add(start);
            map2.put(s.charAt(start), map2.getOrDefault(s.charAt(start), 0) - 1);
            if (map2.get(s.charAt(start)) == 0) {
                map2.remove(s.charAt(start));
            }
        }
        return res;
    }

    private static boolean isAnagram(Map<Character, Integer> map, Map<Character, Integer> map2) {
        for (char key : map.keySet()) {
            if (!map2.keySet().contains(key)) {
                return false;
            }
        }
        for (char key : map2.keySet()) {
            if (!map.keySet().contains(key)) {
                return false;
            }
        }
        for (char key : map.keySet()) {
            if (map2.get(key) != map.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
