package leetcode.algo.c;
// TLE DFS method
public class CoinChangeII2 {
    public int change(int amount, int[] coins) {
        int res[] = new int[1];
        helper(coins, res, 0, amount, coins.length-1);
        return res[0];
    }

    public void helper(int[] coins, int[] res, int sum, int amount, int start) {
        if (sum > amount) {
            return;
        }
        if (sum == amount) {
            res[0]++;
            //System.out.println(res[0]);
            return;
        }
        for (int i = start; i >= 0; i--) {
            sum += coins[i];
            helper(coins, res, sum, amount, i);
            sum -= coins[i];
        }
    }
}
