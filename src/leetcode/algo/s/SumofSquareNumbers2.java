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
public class SumofSquareNumbers2 {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }
}
