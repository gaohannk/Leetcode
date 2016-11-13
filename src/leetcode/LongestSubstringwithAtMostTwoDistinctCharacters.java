package leetcode;

/* Given a string S, find the length of the longest substring T that contains at most two distinct characters.
 * For example,
 * Given S = “eceba”,
 * T is "ece" which its length is 3.
 */
/* aaacccbbcccbb
 * 当前字符k与前一个字符不同时,j始终记录当前字符k之前的字符，也就是k之前不同字符的最后一个。
 * i记录候选字符串的倒数第二个不同字符
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null)
            return 0;
        if (s.length() <= 2)
            return s.length();
        int i = 0, j = -1, maxLen = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1))
                continue;
            if (j >= 0 && s.charAt(j) != s.charAt(k)) {   // k is at the third distinct character
                maxLen = Math.max(k - i, maxLen);
                i = j + 1;      // the head of potential string with two distinct character
            }
            j = k - 1;          //the tail of the distinct character before current
        }
        return Math.max(s.length() - i, maxLen);
    }
}
