package leetcode;

import java.util.ArrayList;
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
// Slide window
public class FindAllAnagramsinaString2 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return res;
        }
        if (s.length() < p.length())
            return res;
        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++)
            map[p.charAt(i) - 'a']++;
        for (int i = 0; i < p.length()-1; i++) {
            map[s.charAt(i) - 'a']--;
        }

        for (int start=0, j = p.length() - 1; j < s.length();start++, j++) {
            map[s.charAt(j) - 'a']--;
            if (isAnagram(map))
                res.add(start);
            map[s.charAt(start) - 'a']++;
        }
        return  res;
    }

    private static boolean isAnagram(int[] map) {
        for (int i : map) {
            if (i != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
