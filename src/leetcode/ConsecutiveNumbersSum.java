package leetcode;

/**
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * Example 2:
 * <p>
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * Example 3:
 * <p>
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * Note: 1 <= N <= 10 ^ 9.
 */
//TLE Boute Force
public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0, j = i;
            while (sum < N) {
                sum += j;
                j++;
            }
            if (sum == N)
                res++;

        }
        return res;
    }
}
