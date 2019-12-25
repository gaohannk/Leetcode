package leetcode.algo.d;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */

/**
 * When i = 7, stack = [7 (73)]. ans[i] = 0.
 * When i = 6, stack = [6 (76)]. ans[i] = 0.
 * When i = 5, stack = [5 (72), 6 (76)]. ans[i] = 1.
 * When i = 4, stack = [4 (69), 5 (72), 6 (76)]. ans[i] = 1.
 * When i = 3, stack = [3 (71), 5 (72), 6 (76)]. ans[i] = 2.
 * When i = 2, stack = [2 (75), 6 (76)]. ans[i] = 4.
 * When i = 1, stack = [1 (74), 2 (75), 6 (76)]. ans[i] = 1.
 * When i = 0, stack = [0 (73), 1 (74), 2 (75), 6 (76)]. ans[i] = 1.
 */
public class DailyTemperatures2 {
    public static int[] dailyTemperatures(int[] T) {
        // Store the index of element
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        Arrays.stream(dailyTemperatures(T)).forEach(x -> System.out.print(x + ","));

        // 76
        // 72 76
        // 69 72 76
        // 71 72 76
    }
}
