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
// Linear Solution
public class CountBinarySubstrings2 {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int pre = 0, cur = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                res += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            } else {
                cur++;
            }
        }

        res += Math.min(pre, cur);
        return res;
    }
}
