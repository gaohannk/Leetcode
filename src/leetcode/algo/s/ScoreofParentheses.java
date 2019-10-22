package leetcode.algo.s;

import java.util.Stack;

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * <p>
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "(())"
 * Output: 2
 * Example 3:
 * <p>
 * Input: "()()"
 * Output: 2
 * Example 4:
 * <p>
 * Input: "(()(()))"
 * Output: 6
 * <p>
 * <p>
 * Note:
 * <p>
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 */
/*
Time Complexity: O(N)O(N), where NN is the length of S.
Space Complexity: O(N)O(N), the size of the stack.
 */
public class ScoreofParentheses {

    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> score = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push("(");
                score.push(-1); // Separate the bound for sum
            } else {
                stack.pop();
                int total = 0;
                while (score.peek() != -1) {
                    total += score.pop();
                }
                score.pop();
                score.push(Math.max(2 * total, 1));
            }
        }
        // Sum all left score in stack
        int res = 0;
        while (score.size() > 0) {
            res += score.pop();
        }
        return res;
    }

    public int scoreOfParentheses2(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
