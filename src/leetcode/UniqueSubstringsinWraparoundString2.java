package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * <p>
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
 * <p>
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 * <p>
 * Example 1:
 * Input: "a"
 * Output: 1
 * <p>
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * Example 2:
 * Input: "cac"
 * Output: 2
 * Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 * Example 3:
 * Input: "zab"
 * Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 */
//TLE
public class UniqueSubstringsinWraparoundString2 {
    public static int findSubstringInWraproundString(String p) {
        if (p.length() == 0)
            return 0;
        if (p.length() == 1)
            return 1;
        int dp[] = new int[p.length()];
        dp[0] = 1;
        for (int i = 1; i < p.length(); i++) {
            int len = 0;
            int count = 0;
            while (i - len > 0) {
                if (p.substring(0, i + 1).indexOf(p.substring(i - len, i + 1)) == i - len) {
                    //System.out.println(p.substring(i - len, i + 1));
                    count++;
                }
                if (!(p.charAt(i - len) - p.charAt(i - len - 1) == 1 || p.charAt(i - len - 1) - p.charAt(i - len) == 25)) {
                    break;
                }
                len++;
            }
            if (i - len == 0)
                count++;
            dp[i] = dp[i - 1] + count;
        }
        Arrays.stream(dp).forEach(item -> System.out.print(item + " "));
        return dp[p.length() - 1];
    }

    public static void main(String[] args) {
        findSubstringInWraproundString("\"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz\"");
    }
}
