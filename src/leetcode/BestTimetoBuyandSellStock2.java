package leetcode;

/* Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */
/* min表示到目前为止的最低价格
 * profit表示当前价格减去之前出现的最低价格得到的利润
 * maxprofit表示当前最大利润
 */
public class BestTimetoBuyandSellStock2 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = prices[i] < min ? prices[i] : min;
            int profit = prices[i] - min;
            maxprofit = Math.max(maxprofit, profit);
        }
        return maxprofit;
    }
}
