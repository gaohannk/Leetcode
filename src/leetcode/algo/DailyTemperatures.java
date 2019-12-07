package leetcode.algo;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
// TLE
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        stack.push(T[T.length - 1]);
        int[] res = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            int count = 0;
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty() && stack.peek() < T[i]) {
                temp.push(stack.pop());
                count++;
            }

            if (!stack.isEmpty()) {
                res[i] = count + 1;
            } else {
                // The right most one
                res[i] = 0;
            }
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            stack.push(T[i]);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        Arrays.stream(dailyTemperatures(T)).forEach(x -> System.out.print(x + ","));
    }
}
