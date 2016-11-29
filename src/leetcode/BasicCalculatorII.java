package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 */

/**
 * sign + -: from left to right use queue
 * num 0-9: use stack
 **/
public class BasicCalculatorII {
    public static int calculate(String s) {
        s = trimEmpty(s);

        Stack<Integer> num = new Stack<>();
        Queue<Character> sign = new LinkedList<>();
        int i = 0;
        int flag = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                i++;
                if (flag == 0)
                    num.push(sum);
                else if (flag == 1) {
                    num.push(num.pop() * sum);
                    flag = 0;
                } else if (flag == 2) {
                    num.push(num.pop() / sum);
                    flag = 0;
                }
            } else if (s.charAt(i) == '+') {
                sign.offer('+');
                i++;
            } else if (s.charAt(i) == '-') {
                sign.offer('-');
                i++;
            } else if (s.charAt(i) == '*') {
                i++;
                flag = 1;
            } else if (s.charAt(i) == '/') {
                i++;
                flag = 2;

            }
        }
        // don't forget upside down the num, since calculate from left to right
        Stack<Integer> num2 = new Stack<>();
        while (!num.isEmpty()) {
            num2.push(num.pop());
        }
        while (!sign.isEmpty()) {
            char c = sign.poll();
            if (c == '+')
                num2.push(num2.pop() + num2.pop());
            else if (c == '-')
                num2.push(num2.pop() - num2.pop());
        }
        return num2.pop();
    }

    private static String trimEmpty(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.print(calculate("1-1+1"));
    }
}
