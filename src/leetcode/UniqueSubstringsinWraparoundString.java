package leetcode;

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
public class UniqueSubstringsinWraparoundString {
    public int findSubstringInWraproundString(String p) {
        String s = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        if (p.length() == 1)
            return 1;
        int start = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)
                continue;
            else {
                set.add(p.substring(start, i));
                start = i;
            }
        }
        set.add(p.substring(start, p.length()));
        HashSet<String> subSet = new HashSet<>();
        int res = 0;
        for (String str : set) {
            for(int len=1;len<str.length();len++) {
                for (int i = 0; i < str.length()-len; i++) {
                    if (!subSet.contains(str.substring(i, i + len))){
                        subSet.add(str.substring(i, i + len));
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
