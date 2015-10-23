package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/* Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression. Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		HashSet<String> OPERATORS = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : tokens) {
			if (OPERATORS.contains(token)) {
				int x = stack.pop();
				int y = stack.pop();
				switch (token) {
				case "+":
					stack.push(x + y);
				case "-":
					stack.push(y - x); // not x-y
				case "*":
					stack.push(y * x);
				case "/":
					stack.push(y / x);
				}
			} else
				stack.push(Integer.parseInt(token));
		}
		return stack.pop();
	}
}
