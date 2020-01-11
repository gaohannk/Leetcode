package company.offerup.phone;

public class BestTimetoBuyandSellStock {
    public static int bestTime(int[] prices) {
        if (prices.length == 0 || prices.length == 1)
            return 0;
        int min = prices[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(bestTime(prices));
    }
}
