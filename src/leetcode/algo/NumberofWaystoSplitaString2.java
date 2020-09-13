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
public class NumberofWaystoSplitaString2 {
    public int numWays(String s) {
        // Count the number of '1's in the string, while also saving
        // the index to each '1' into the array ones[].
        char[] sc = s.toCharArray();
        int[] ones = new int[Math.min(sc.length, 6000)];
        int onesCount = 0;
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '1') {
                ones[onesCount] = i;
                onesCount++;
            }
        }

        if (onesCount % 3 != 0) {
            return 0;
        }

        if (onesCount == 0) {
            return (int) (((long) (s.length() - 2) * (long) (s.length() - 1) / 2L) % 1000000007L);
        }

        int end1 = ones[onesCount / 3 - 1];
        int start2 = ones[onesCount / 3];
        int end2 = ones[onesCount * 2 / 3 - 1];
        int start3 = ones[onesCount * 2 / 3];
        return (int) ((long) (start2 - end1) * (long) (start3 - end2) % 1000000007L);
    }
}
