package leetcode.t;

import java.util.Stack;

/**
 * Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).
 * <p>
 * Note:
 * <p>
 * The length of the given string is ≤ 10000.
 * Each number will contain only one digit.
 * The conditional expressions group right-to-left (as usual in most languages).
 * The condition will always be either T or F. That is, the condition will never be a digit.
 * The result of the expression will always evaluate to either a digit 0-9, T or F.
 * Example 1:
 * <p>
 * Input: "T?2:3"
 * <p>
 * Output: "2"
 * <p>
 * Explanation: If true, then result is 2; otherwise result is 3.
 * Example 2:
 * <p>
 * Input: "F?1:T?4:5"
 * <p>
 * Output: "4"
 * <p>
 * Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
 * <p>
 * "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
 * -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
 * -> "4"                                    -> "4"
 * Example 3:
 * <p>
 * Input: "T?T?F:5:3"
 * <p>
 * Output: "F"
 * <p>
 * Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
 * <p>
 * "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
 * -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
 * -> "F"                                    -> "F"
 */
public class TernaryExpressionParser {
    public char parseTernary(String expression) {
        Stack<Character> num = new Stack<>(); // 0-9 or T or F
        Stack<Character> symbol = new Stack<>(); // : or ?
        int i = expression.length() - 1;
        while (i-- >= 0) {
            char c = expression.charAt(i);
            if (c > '0' && c < '9' || c=='T' || c=='F')
                num.push(c);
            else if (c == ':')
                symbol.push(c);
            else if (c == '?') {
                if (expression.charAt(i - 1) == 'T') {
                    char val = num.pop();
                    num.pop();
                    num.push(val);
                } else {
                    num.pop();
                }
                symbol.pop();
                i--;
            }
        }
        return num.pop();
    }
}
