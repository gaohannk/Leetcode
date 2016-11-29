package leetcode;

/* Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
// find local min and max point
public class BestTimetoBuyandSellStockII2 {
	public int maxProfit(int[] prices) {
		int maxprofit = 0;
		int i = 1;
		while (i < prices.length) {
			while (i < prices.length && prices[i] < prices[i - 1])
				i++;
			int buy = prices[i - 1];
			while (i < prices.length && prices[i] > prices[i - 1])
				i++;
			int sell = prices[i - 1];
			maxprofit += sell - buy;
			// don't forget this the price may be keep the same
			i++;
		}
		return maxprofit;
	}
}
