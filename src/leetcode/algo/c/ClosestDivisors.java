package leetcode.algo.c;

/**
 * Given an integer num, find the closest two integers in absolute difference whose product equals num + 1 or num + 2.
 *
 * Return the two integers in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 8
 * Output: [3,3]
 * Explanation: For num + 1 = 9, the closest divisors are 3 & 3, for num + 2 = 10, the closest divisors are 2 & 5, hence 3 & 3 is chosen.
 * Example 2:
 *
 * Input: num = 123
 * Output: [5,25]
 * Example 3:
 *
 * Input: num = 999
 * Output: [40,25]
 */
public class ClosestDivisors {
    public int[] closestDivisors(int num) {
        int[] res;
        int[] tmp = diff(num + 1);
        int[] tmp2 = diff(num + 2);
        if (Math.abs(tmp[0] - tmp[1]) < Math.abs(tmp2[0] - tmp2[1])) {
            res = tmp;
        } else {
            res = tmp2;
        }
        return res;
    }

    private int[] diff(int num) {
        int[] candidates = new int[2];
        for (int i = (int) Math.sqrt(num); i >= 1; i--) {
            if (num % i == 0) {
                candidates[0] = i;
                candidates[1] = num / i;
                break;
            }
        }
        return candidates;
    }
}
