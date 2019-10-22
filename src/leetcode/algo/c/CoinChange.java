package leetcode.algo.c;

/* You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
// top down
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount];
        return helper(coins, dp, amount);
    }

    private int helper(int[] coins, int[] dp, int amount) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        // prune
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = helper(coins, dp, amount - coins[i]);
            if (res != -1) {
                min = Math.min(min, res + 1);
            }
        }
        dp[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount];
    }

}
