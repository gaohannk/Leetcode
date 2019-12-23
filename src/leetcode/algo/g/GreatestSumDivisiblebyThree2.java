package leetcode.algo.g;

/**
 * Represent the state as DP[pos][mod]: maximum possible sum starting in the position "pos" in the array where the current sum modulo 3 is equal to mod.
 */
public class GreatestSumDivisiblebyThree2 {
    public int maxSumDivThree(int[] A) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int a : A) {
            int[] dp2 = new int[3];
            for (int i = 0; i < 3; ++i)
                dp2[(i + a) % 3] = Math.max(dp[(i + a) % 3], dp[i] + a);
            dp = dp2;
        }
        return dp[0];
    }
}
