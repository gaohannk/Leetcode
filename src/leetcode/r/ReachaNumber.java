package leetcode.r;

/**
 * You are standing at position 0 on an infinite number line. There is a goal at position target.
 * <p>
 * On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
 * <p>
 * Return the minimum number of steps required to reach the destination.
 * <p>
 * Example 1:
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second step we step from 1 to 3.
 * Example 2:
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second move we step  from 1 to -1.
 * On the third move we step from -1 to 2.
 * Note:
 * target will be a non-zero integer in the range [-10^9, 10^9].
 */
public class ReachaNumber {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0)
            k++;
            target -= k;

        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

//    public int reachNumber(int target) {
//        target = Math.abs(target);
//        int step = 0;
//        int sum = 0;
//        while (sum < target) {
//            step++;
//            sum += step;
//        }
//        while ((sum - target) % 2 != 0) {
//            step++;
//            sum += step;
//        }
//        return step;
//    }
}
