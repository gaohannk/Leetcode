package leetcode;

/* Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int maxprofit = 0;
        int fmin = prices[0], smax = prices[prices.length - 1];
        int[] forward = new int[prices.length];
        int[] backward = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            forward[i] = Math.max(forward[i - 1], prices[i] - fmin);
            fmin = Math.min(fmin, prices[i]);
        }

        for (int i = prices.length - 2; i >= 0; i--) {
            backward[i] = Math.max(backward[i+1], smax - prices[i]);
            smax = Math.max(smax, prices[i]);
        }

        for (int i = 0; i < prices.length; i++) {
            maxprofit = Math.max(maxprofit, forward[i] + backward[i]);
        }
        return maxprofit;
    }
}
