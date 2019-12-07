package leetcode.algo.c;

/**
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
 * <p>
 * Substrings that occur multiple times are counted the number of times they occur.
 * <p>
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 * <p>
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 * <p>
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 * Example 2:
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 * Note:
 * <p>
 * s.length will be between 1 and 50,000.
 * s will only consist of "0" or "1" characters.
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int i = 1;
        int res = 0;
        int pre = 0, cur = 1;
        if (s.length() == 1)
            return 0;
        while (i < s.length()) {
            int k;
            for (k = i; k < s.length(); k++) {
                if (s.charAt(k) == s.charAt(k - 1)) {
                    cur++;
                } else {
                    break;
                }
            }
            res += Math.min(pre, cur);
            pre = cur;
            cur = 1;
            i = k;
            i++;
        }
        // Special case 001101 last is only 1 times
        if (s.charAt(s.length() - 1) != s.charAt(s.length() - 2)) {
            res += Math.min(pre, cur);
        }

        return res;
    }
}
