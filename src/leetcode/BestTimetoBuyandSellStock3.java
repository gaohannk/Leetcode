package leetcode;

/* Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */
//TlE
public class BestTimetoBuyandSellStock3 {
	public int maxProfit(int[] prices) {
		int maxprofit = 0;
		for (int i = 1; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] - prices[i] > maxprofit)
					maxprofit = prices[j] - prices[i];
			}
		}
		return maxprofit;
	}
}
