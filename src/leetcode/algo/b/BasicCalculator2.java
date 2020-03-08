package leetcode.algo.b;

import java.util.Stack;

/* Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 */
public class BasicCalculator2 {
    public static int calculate(String s) {
        int num = 0;
        int n = 0;
        Stack<Object> stack = new Stack<Object>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // Forming the num - in reverse order.
                num = (int) Math.pow(10, n) * (int) (ch - '0') + num;
                n += 1;
            } else if (ch != ' ') {
                if (n != 0) {
                    // Save the num on the stack As we encounter some non-digit.
                    stack.push(num);
                    n = 0;
                    num = 0;
                }
                if (ch == '(') {
                    int res = evaluateExpr(stack);
                    stack.pop();
                    // Append the evaluated result to the stack. This result could be of a sub-expression within the parenthesis.
                    stack.push(res);
                } else {
                    // For other non-digits '+', '-', ')' just push onto the stack.
                    stack.push(ch);
                }
            }
        }

        //Push the last num to stack, if any.
        if (n != 0) {
            stack.push(num);
        }

        // Evaluate any left overs in the stack.
        return evaluateExpr(stack);
    }

    public static int evaluateExpr(Stack<Object> stack) {
        int res = 0;
        if (!stack.empty()) {
            res = (int) stack.pop();
        }

        // Evaluate the expression till we get corresponding ')'
        while (!stack.empty() && !((char) stack.peek() == ')')) {
            char sign = (char) stack.pop();
            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}