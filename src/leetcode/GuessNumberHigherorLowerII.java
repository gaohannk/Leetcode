package leetcode;

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
/*
 dp[p][q]= k			k=target
 		 = k +dp[k+1][q]  k<target
		 = k +dp[q][k-1]  k>target
 p<=k<=q
 dp[0][n-1]
*/
public class GuessNumberHigherorLowerII {
	public static int getMoneyAmount(int n) {
		int dp[][] = new int[n][n];
		helper(0, n - 1, dp);
		return dp[0][n - 1];
	}

	public static int helper(int start, int end, int dp[][]) {
		if (start >= end)
			return 0;
		if (dp[start][end] != 0)
			return dp[start][end];
		int minCost = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			int cost = 0;
			cost = Math.max(cost, i + 1 + helper(i + 1, end, dp));
			cost = Math.max(cost, i + 1 + helper(start, i - 1, dp));
			minCost = minCost < cost ? minCost : cost;
		}
		dp[start][end] = minCost;
		// System.out.println(dp[start][end]);
		return minCost;
	}

	public static void main(String[] args) {
		System.out.println(getMoneyAmount(20));
	}
}
