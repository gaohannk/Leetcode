package company.opendoor.phone;

import java.util.*;

/* Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression. Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotationInputIsString {
    private static final Set<String> OPERATORS = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String string) throws Exception {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        List<String> tokens = new LinkedList<>();
        while (i < string.length()) {
            if (Character.isDigit(string.charAt(i)) || string.charAt(i) == '.') {
                sb.append(i);
            } else {
                tokens.add(sb.toString());
                sb = new StringBuilder();
                tokens.add(string.charAt(i) + "");
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                if(stack.isEmpty()){
                    throw new Exception("no operatorand");
                }
                int y = stack.pop();
                if(stack.isEmpty()){
                    throw new Exception("no operatorand");
                }
                int x = stack.pop();
                stack.push(eval(x, y, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int eval(int x, int y, String operator) throws Exception {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            default:
                if(y==0){
                    throw new Exception();
                }
                return x / y;
        }
    }
}
