package leetcode.o;

import java.util.Stack;

/**
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
 * <p>
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
 * <p>
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * Output: [null,1,1,1,2,1,4,6]
 * Explanation:
 * First, S = StockSpanner() is initialized.  Then:
 * S.next(100) is called and returns 1,
 * S.next(80) is called and returns 1,
 * S.next(60) is called and returns 1,
 * S.next(70) is called and returns 2,
 * S.next(60) is called and returns 1,
 * S.next(75) is called and returns 4,
 * S.next(85) is called and returns 6.
 * <p>
 * Note that (for example) S.next(75) returned 4, because the last 4 prices
 * (including today's price of 75) were less than or equal to today's price.
 * <p>
 * <p>
 * Note:
 * <p>
 * Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
 * There will be at most 10000 calls to StockSpanner.next per test case.
 * There will be at most 150000 calls to StockSpanner.next across all test cases.
 * The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
 */
public class OnlineStockSpan {
    static class StockSpanner {
        public Stack<Integer> price, count;

        public StockSpanner() {
            price = new Stack<>();
            count = new Stack<>();
        }

        public int next(int price) {
            int sum = 1;
            while (!count.isEmpty() && this.price.peek() <= price) {
                this.price.pop();
                sum += this.count.pop();
            }
            this.price.push(price);
            this.count.push(sum);
            return sum;
        }
    }

    public static void main(String[] args) {
        StockSpanner sp = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        for (int price : prices) {
            System.out.println(sp.next(price));
        }
    }
}
