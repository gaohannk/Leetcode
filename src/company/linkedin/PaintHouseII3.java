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
// O(n*k)
// two mins
public class PaintHouseII3 {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        for (int i = 1; i < costs.length; i++) {
            int min1 = Integer.MAX_VALUE, index1 = -1; // smallest
            int min2 = Integer.MAX_VALUE, index2 = -1; // second smallest
            for (int j = 0; j < k; j++) {
                if (costs[i - 1][j] < min1) {
                    min2 = min1;
                    min1 = costs[i - 1][j];
                    index2 = index1;
                    index1 = j;
                } else if (costs[i - 1][j] < min2) {
                    min2 = costs[i - 1][j];
                    index2 = j;
                }
            }
            for (int j = 0; j < k; j++) {
                costs[i][j] += j == index1 ? min2 : min1;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            res = Math.min(res, costs[n - 1][i]);
        }
        return res;
    }
}
