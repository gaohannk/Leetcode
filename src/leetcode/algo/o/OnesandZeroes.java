package leetcode.algo.o;

/**
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 * <p>
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
 * <p>
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * <p>
 * Note:
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 * Example 1:
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * <p>
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 * Example 2:
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 * <p>
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */

/**
 * dp[m][n] represent the maximum number of string can be from by m 0s and n 1s
 */
public class OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int s = strs.length - 1; s >= 0; s--) {
            int[] count = count(strs[s]);
            for (int i = m; i >= count[0]; i--)
                for (int j = n; j >= count[1]; j--)
                    dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);

        }
        return dp[m][n];
    }

    public int[] count(String str) {
        int[] res = new int[]{0, 0};
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') res[0]++;
            else res[1]++;
        }
        return res;
    }
}
