package leetcode.algo.p;

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
// TLE brute force
public class PermutationinString {
    boolean flag = false;

    public boolean checkInclusion(String s1, String s2) {
        permute(s1, s2, 0);
        return flag;
    }

    public String swap(String s, int i, int j) {
        if (i == j)
            return s;
        char c[] = s.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return new String(c);
    }

    void permute(String s1, String s2, int start) {
        if (start == s1.length()) {
            if (s2.contains(s1))
                flag = true;
        } else {
            for (int i = start; i < s1.length(); i++) {
                s1 = swap(s1, start, i);
                permute(s1, s2, start + 1);
                s1 = swap(s1, start, i);
            }
        }
    }
}
