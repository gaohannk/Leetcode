package leetcode.algo;

/**
 * Given a binary string s (a string consisting only of '0's and '1's), we can split s into 3 non-empty strings s1, s2, s3 (s1+ s2+ s3 = s).
 *
 * Return the number of ways s can be split such that the number of characters '1' is the same in s1, s2, and s3.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "10101"
 * Output: 4
 * Explanation: There are four ways to split s in 3 parts where each part contain the same number of letters '1'.
 * "1|010|1"
 * "1|01|01"
 * "10|10|1"
 * "10|1|01"
 * Example 2:
 *
 * Input: s = "1001"
 * Output: 0
 * Example 3:
 *
 * Input: s = "0000"
 * Output: 3
 * Explanation: There are three ways to split s in 3 parts.
 * "0|0|00"
 * "0|00|0"
 * "00|0|0"
 * Example 4:
 *
 * Input: s = "100100010100110"
 * Output: 12
 *
 *
 * Constraints:
 *
 * s[i] == '0' or s[i] == '1'
 * 3 <= s.length <= 10^5
 */

/**
 * There is no way if the sum (number of '1's) is not divisible by the number of splits. So sum%3 should be 0.
 * Preffix s1 , and suffix s3 should have sum/3 characters '1'.
 */
public class NumberofWaystoSplitaString {
    public int numWays(String s) {
        long n = s.length(), mod = 1_000_000_007, onesCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                onesCount++;
            }
        }
        if (onesCount % 3 != 0) {
            return 0;
        }
        if (onesCount == 0) {
            return (int) ((n - 1) * (n - 2) / 2 % mod); // combinations, select 2 slots from n - 1 slots;
        }
        long firstZeros = 0, secondZeros = 0, avg = onesCount / 3, prefixOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                prefixOnes++;
            } else {
                if (prefixOnes == avg) {
                    firstZeros++; // btwn s1 and s2;
                } else if (prefixOnes == avg * 2) {
                    secondZeros++; // btwn s3 and s2;
                }
            }
        }
        return (int) (++firstZeros * ++secondZeros % mod);  // two 0s form 3 slots
    }
}
