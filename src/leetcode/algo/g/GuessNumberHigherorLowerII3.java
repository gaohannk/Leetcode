package leetcode.algo.g;

/*We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
*/

/**
 * We need to use a dpdp matrix, where dp(i, j)dp(i,j) refers to the minimum cost of finding the worst number given only the numbers in the range (i, j)(i,j).
 * dp dp(i,j)=min for k between (i,j) [ k+max(dp(i,k-1),dp(k+1,j))]
 */

public class GuessNumberHigherorLowerII3 {
    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int min = Integer.MAX_VALUE;
                for (int k = start; k < start + len - 1; k++) {
                    int maxRes = k + Math.max(dp[start][k - 1], dp[k + 1][start + len - 1]);
                    min = Math.min(maxRes, min);
                }
                dp[start][start + len - 1] = min;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(getMoneyAmount(20));
    }
}
