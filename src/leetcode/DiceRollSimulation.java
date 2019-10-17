package leetcode;

public class DiceRollSimulation {
    public int dieSimulator(int n, int[] rollMax) {
        long divisor = (long) Math.pow(10, 9) + 7;
        long[][] dp = new long[n][7];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        // Basically, once we are done with a layer -i- of DP, the sum is stored in dp[i, 6], before moving on to the next layer i + 1
        dp[0][6] = 6;
        for (int i = 1; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                dp[i][j] = dp[i - 1][6];
                // If we have rolled less than the max consecutive limit, we don't worry about this not being a valid roll
                if (i - rollMax[j] >= 0) {
                    /*
                     our current dp[i, j] is the max possible we can add
                     we make sure we remove any sequence (rollMax[j] - 1) in the past that ends with j
                     that way we are guaranteed to be within rollMax[j] limit even if we roll a j
                     */
                    int k = i - rollMax[j] - 1;
                    if (k >= 0) {
                        dp[i][j] = (dp[i][j] - (dp[k][6] - dp[i - rollMax[j] - 1][j])) % divisor + divisor;
                    } else {
                        // If we are exactly on the roll limit, then we cannot roll a j
                        dp[i][j] = (dp[i][j] - 1) % divisor;
                    }
                }
                sum = (sum + dp[i][j]) % divisor;
            }
            dp[i][6] = sum;
        }
        return (int) (dp[n - 1][6]);
    }
}
