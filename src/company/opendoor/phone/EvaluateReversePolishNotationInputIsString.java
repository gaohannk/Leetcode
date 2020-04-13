package company.opendoor.phone;

import java.util.*;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression. Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * '2 3 +' => 5 // ["2", "3", "+"]
 * '2 3 *' => 6
 * '2 3 + 4 *' => 20
 * '2 3 4 + *' => 14
 * '-1 3 +' => 2
 * '1.4 2.5 +' => 3.9
 * '3 -5 * abs' => 15
 * '4 neg 8 *' => -32
 * '1 2 3 sum' => 6
 * '1 2 3 4 sum' => 10
 * '1 2 3 4 sum 2 *' => 20
 * '1 2 + 3 4 sum' => 10
 */
public class EvaluateReversePolishNotationInputIsString {
    public static void main(String[] args) throws Exception {
        // TEST
        System.out.println(evaluate("2 3 +"));
        System.out.println(evaluate("2 3 + 4 *"));
        System.out.println(evaluate("2 3 4 + *"));
        System.out.println(evaluate("1.4 2.5 -"));
        System.out.println(evaluate("1.4 2.5 /"));
        System.out.println("-------");
        System.out.println(evaluate("2 3 4 / *"));
        System.out.println(evaluate("2 3 4 + -"));
        System.out.println("-------");
        System.out.println(evaluate("2 3 / 4 *"));
        System.out.println(evaluate("2 3 + 4 -"));
        System.out.println("-------");
        System.out.println(evaluate("1 2 3 sum"));
        System.out.println(evaluate("1 2 + 3 4 sum"));
        System.out.println(evaluate("4 neg 8 *"));
        System.out.println(evaluate("3 -5 * abs"));
    }

    private static final Set<String> operator = new HashSet<>(Arrays.asList("+", "-", "*", "/", "abs", "neg", "sum"));
    private static final Set<String> twoOperator = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    private static final String ABS = "abs";
    private static final String NEG = "neg";
    private static final String SUM = "sum";

    public static double evaluate(String input) throws Exception {
        // corner case
        if (input == null || input.length() == 0) {
            return 0.0;
        }

        Stack<Double> stack = new Stack<>();
        String[] tokens = input.split(" ");

        for (String token : tokens) {
            // operator
            if (operator.contains(token)) {
                calculate(stack, token);
            } else {
                // operation number
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }

    public static void calculate(Stack<Double> stack, String token) {
        // two operator
        if (twoOperator.contains(token)) {
            double y = stack.pop();
            double x = stack.pop();
            switch (token) {
                case "+":
                    stack.push(x + y);
                    break;
                case "-":
                    stack.push(x - y);
                    break;
                case "*":
                    stack.push(x * y);
                    break;
                case "/":
                    stack.push(x / y);
                    break;
            }
        } else {
            switch (token) {
                case "neg":
                    stack.push(stack.pop() * -1);
                    break;
                case "sum":
                    double sum = 0;
                    while (!stack.isEmpty()) {
                        sum += stack.pop();
                    }
                    stack.push(sum);
                    break;
                case "abs":
                    stack.push(Math.abs(stack.pop()));
                    break;
            }
        }
    }
}
