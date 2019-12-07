package leetcode.algo.s;

/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: 3
 * Output: False
 */

/**
 * Any positive number nn is expressible as a sum of two squares if and only if the prime factorization of nn, every prime of the form (4k+3)(4k+3) occurs an even number of times.
 */
public class SumofSquareNumbers4 {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}
