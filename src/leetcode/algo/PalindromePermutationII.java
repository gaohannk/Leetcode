package leetcode.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
 *
 * Example 1:
 *
 * Input: "aabb"
 * Output: ["abba", "baab"]
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 */
// TLE, brute force
public class PalindromePermutationII {

    public List<String> generatePalindromes(String s) {
        Set<String> set = new HashSet<>();
        permute(s.toCharArray(), 0, set);
        return new ArrayList<String>(set);
    }

    void permute(char[] s, int l, Set<String> set) {
        if (l == s.length) {
            if (isPalindrome(s)) {
                set.add(new String(s));
            }
        } else {
            for (int i = l; i < s.length; i++) {
                swap(s, l, i);
                permute(s, l + 1, set);
                swap(s, l, i);
            }
        }
    }

    public boolean isPalindrome(char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != s[s.length - 1 - i])
                return false;
        }
        return true;
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
