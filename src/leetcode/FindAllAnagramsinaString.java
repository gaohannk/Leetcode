package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
//TLE
public class FindAllAnagramsinaString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0)
            return res;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            HashMap<Character, Integer> temp = new HashMap(map);
            for (int j = i; j < p.length() + i; j++) {
                if (!map.keySet().contains(s.charAt(j)))
                    break;
                if (temp.get(s.charAt(j)) == null)
                    break;
                temp.put(s.charAt(j), temp.get(s.charAt(j)) - 1);
                if (temp.get(s.charAt(j)) == 0)
                    temp.remove(s.charAt(j));
                if (temp.size() == 0) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
