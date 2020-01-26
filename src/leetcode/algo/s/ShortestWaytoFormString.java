package leetcode.algo.s;

import java.util.HashSet;
import java.util.Set;

/**
 * From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).
 *
 * Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: source = "abc", target = "abcbc"
 * Output: 2
 * Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
 * Example 2:
 *
 * Input: source = "abc", target = "acdbc"
 * Output: -1
 * Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.
 * Example 3:
 *
 * Input: source = "xyz", target = "xzyxz"
 * Output: 3
 * Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
 *
 *
 * Constraints:
 *
 * Both the source and target strings consist of only lowercase English letters from "a"-"z".
 * The lengths of source and target string are between 1 and 1000.
 * Accepted
 */
public class ShortestWaytoFormString {
    public static int shortestWay(String source, String target) {
        char[] s = source.toCharArray();
        int i = 0;
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (char c : s) {
            set.add(c);
        }
        for (char c : target.toCharArray()) {
            if (!set.contains(c)) {
                return -1;
            }
        }
        while (i < target.length()) {
            int j = 0;
            while (i < target.length() && j < s.length) {
                if (target.charAt(i) == source.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            count++;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(shortestWay("abc", "abcbc"));
        System.out.println(shortestWay("abc", "acdbc"));
        System.out.println(shortestWay("xyz", "xzyxz"));

    }
}