package leetcode.algo;

import java.util.Arrays;

/**
 * A chess knight can move as indicated in the chess diagram below:
 *
 * .
 *
 *
 *
 * This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.
 *
 * Each time it lands on a key (including the initial placement of the knight), it presses the number of that key, pressing N digits total.
 *
 * How many distinct numbers can you dial in this manner?
 *
 * Since the answer may be large, output the answer modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: 10
 * Example 2:
 *
 * Input: 2
 * Output: 20
 * Example 3:
 *
 * Input: 3
 * Output: 46
 */
public class KnightDialer {
    public int knightDialer(int N) {
        int MOD = 1_000_000_007;
        int[][] moves = new int[][]{
                {4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0},
                {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};

        int[][] dp = new int[N][10];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int before : moves[j]) {
                    dp[i][j] += dp[i - 1][before];
                    dp[i][j] %= MOD;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += dp[N - 1][i];
            res %= MOD;
        }
        return res;
    }
}
