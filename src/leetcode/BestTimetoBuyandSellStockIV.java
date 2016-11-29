package leetcode;

/* Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

/**
 * dp[i,j] represent the max profit with at most i transactions before time j
 * case 1: no sell at j
 * case 2: sell at j, i-1 transaction before k
 * dp[i,j]= Math.max(dp[i,j-1], profit[j] - (profit[t]- dp[i-1,t])) (0<=t<j)
 * = Math.max(dp[i,j-1], profit[j] - min(profit[t]- dp[i-1,t])
 * or = Math.max(dp[i,j-1], profit[j] + max(dp[i-1,t]-profit[t])
 * Init:
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 **/
public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        int maxProfit = 0;
        if (k >= prices.length / 2)
            return quickSolve(prices);

        int dp[][] = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int tmpMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }

    private int quickSolve(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
}
