package company.linkedin;

/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Example:
 *
 * Input: [[1,5,3],[2,9,4]]
 * Output: 5
 * Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 * Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 * Follow up:
 * Could you solve it in O(nk) runtime?
 */
// O(n*k^2)
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs == null)
            return 0;
        int n = costs.length;
        int k = costs[0].length;
        int dp[][] = new int[n][k];
        // Init
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int localMin = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    if (j != l) {
                        localMin = Math.min(localMin, dp[i - 1][l]);
                    }
                }
                dp[i][j] = localMin + costs[i][j];
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
