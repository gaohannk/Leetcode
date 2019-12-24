package leetcode.algo.g;

import java.util.Arrays;

/**
 * Represent the state as DP[pos][mod]: maximum possible sum starting in the position "pos" in the array where the current sum modulo 3 is equal to mod.
 */
public class GreatestSumDivisiblebyThree {
    public int maxSumDivThree(int[] nums) {
        return maxSumDivK(nums, 3);
    }

    public int maxSumDivK(int[] nums, int k) {
        if (k == 0) return -1;
        int[] dp = new int[k];
        for (int num : nums) {
            int tmp[] = Arrays.copyOf(dp, k);
            for (int i = 0; i < k; i++) {
                dp[(num + tmp[i]) % k] = Math.max(dp[(num + tmp[i]) % k], num + tmp[i]);
            }
        }
        return dp[0];
    }
}
