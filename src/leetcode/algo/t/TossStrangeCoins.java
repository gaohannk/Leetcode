package leetcode.algo.t;

/**
 * You have some coins.  The i-th coin has a probability prob[i] of facing heads when tossed.
 * <p>
 * Return the probability that the number of coins facing heads equals target if you toss every coin exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prob = [0.4], target = 1
 * Output: 0.40000
 * Example 2:
 * <p>
 * Input: prob = [0.5,0.5,0.5,0.5,0.5], target = 0
 * Output: 0.03125
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= prob.length <= 1000
 * 0 <= prob[i] <= 1
 * 0 <= target <= prob.length
 * Answers will be accepted as correct if they are within 10^-5 of the correct answer.
 */

/**
 * dp[i][j] --> probility of getting j head with i + 1 toss
 * dp[i][j] = dp[i - 1][j -1] * prob[i] +dp[i - 1][j] * (1 - prob[i])
 * base case
 * dp[0][0] = 1;
 * Time O(n2), since dp[i][j] only depends on dp[i - 1][], can be optimized to O(n) space
 */
public class TossStrangeCoins {
    public double probabilityOfHeads(double[] prob, int target) {
        double[] dp = new double[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= prob.length; i++) {
            double prev = dp[0];
            dp[0] *= (1 - prob[i - 1]);
            for (int j = 1; j <= target; j++) {
                double tmp = dp[j];
                dp[j] = prev * prob[i - 1] + dp[j] * (1 - prob[i - 1]);
                prev = tmp;
            }
        }
        return dp[target];

    }
}
