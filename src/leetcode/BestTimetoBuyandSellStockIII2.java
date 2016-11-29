package leetcode;

/* Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockIII2 {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MAX_VALUE;
        //profit after buy/sell
        int afterFirstSell = 0;
        int afterSecondBuy = Integer.MIN_VALUE;
        int afterSecondSell = 0;
        for (int curPrice : prices) {
            firstBuy = Math.min(firstBuy, curPrice); //for first buy price ,the lower,the better
            afterFirstSell = Math.max(afterFirstSell, curPrice - firstBuy); // the profit after first sell ,the higher,the better
            afterSecondBuy = Math.max(afterSecondBuy, afterFirstSell - curPrice);//the profit left after second buy,the higher,the better
            afterSecondSell = Math.max(afterSecondSell, afterSecondBuy + curPrice); // the profit left after second sell ,the higher,the better
        }
        return afterSecondSell; // afterSecondSell will be the max profit ultimately
    }
}
