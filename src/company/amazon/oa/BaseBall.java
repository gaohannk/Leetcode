package company.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Q1： 丢棒球，输入一个字符串，其中包括整数，Z，X，或者+。整数代表此轮得分，X：当前成绩是double前面一个分数，+：当前成绩是前两个的和，Z：移除前一个成绩，求最后的总成绩和
 *
 * 一颗栗子： 输入["5", "-2", "4", "Z","X", 9, "+", "+"]
 * output: 27
 * 5 : sum = 5
 * -2 : sum = 5 - 2 = 3
 * 4 : sum = 3 + 4 = 7
 * Z : sum = 7 - 4 = 3
 * X : sum = 3 + -2 * 2 = -1 (4被移除了，前一个成绩是-2)
 * 9 : sum = -1 + 9 = 8
 * + : sum = 8 + 9 - 4 = 13 (前两个成绩是9和-4)
 * + : sum = 13 + 9 + 5 = 27 (前两个成绩是5 和 9)
 * 用一个stack解决。
 */
public class BaseBall {
    public static int solution(String[] input) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            String cur = input[i];
            if (cur.equals("Z")) {
                sum -= stack.pop();
            } else if (cur.equals("X")) {
                int score = 0;
                if (!stack.isEmpty()) {
                    score = stack.peek() * 2;
                }
                stack.push(score);
                sum += score;
            } else if (cur.equals("+")) {
                int fist = stack.pop();
                int second = stack.peek();
                int score = fist + second;
                stack.push(fist);
                stack.push(score);
                sum += score;
            } else {
                int score = Integer.parseInt(cur);
                stack.push(score);
                sum += score;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] line = {"5", "Z", "X", "1", "X", "+", "1", "1"};
        System.out.println(solution(line));
    }
}
