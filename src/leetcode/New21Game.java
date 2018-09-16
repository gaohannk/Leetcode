package leetcode;

import java.util.Arrays;

/**
 * Alice plays the following game, loosely based on the card game "21".
 * <p>
 * Alice starts with 0 points, and draws numbers while she has less than K points.  During each draw, she gains an integer number of points randomly from the range [1, W], where W is an integer.  Each draw is independent and the outcomes have equal probabilities.
 * <p>
 * Alice stops drawing numbers when she gets K or more points.  What is the probability that she has N or less points?
 * <p>
 * Example 1:
 * <p>
 * Input: N = 10, K = 1, W = 10
 * Output: 1.00000
 * Explanation:  Alice gets a single card, then stops.
 * Example 2:
 * <p>
 * Input: N = 6, K = 1, W = 10
 * Output: 0.60000
 * Explanation:  Alice gets a single card, then stops.
 * In 6 out of W = 10 possibilities, she is at or below N = 6 points.
 * Example 3:
 * <p>
 * Input: N = 21, K = 17, W = 10
 * Output: 0.73278
 * Note:
 * <p>
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * Answers will be accepted as correct if they are within 10^-5 of the correct answer.
 * The judging time limit has been reduced for this question.
 */
public class New21Game {
    public static double new21Game(int N, int K, int W) {
        double dp[][] = new double[K + 1][N + 1];
        for (int j = 1; j <= W; j++) {
            dp[1][j] = 1.0 / W;
            System.out.println("dp[" + 1 + "][" + j + "]=" + dp[1][j]);
        }
        System.out.println("-------------------");
        for (int i = 1; i <= K; i++) {
                dp[i][i] = 1.0 / W;
                System.out.println("dp[" + i + "][" + i + "]=" + dp[i][i]);
        }
        System.out.println("-------------------");

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                double sum = 0;
                for (int k = 1; k <= W; k++) {
                    if (j - k >= 0) {
                        //System.out.println("dp[" + (i-1) + "][" + (j-k) + "]=" + dp[i-1][j-k]);
                        sum += dp[i - 1][j - k] / W;
                    }
                }
                if (sum != 0.0) {
                    dp[i][j] = sum;
                    System.out.println("dp[" + i + "][" + j + "]=" + dp[i][j]);
                }
            }
        }
        double res = 0.0;
        for (int i = 1; i <= K; i++) {
            for (int j = K; j <= N; j++) {
                System.out.println("res:dp[" + i + "][" + j + "]=" + dp[i][j]);
                res += dp[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new21Game(21, 17, 10));
    }
}
