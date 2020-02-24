package company.google.onsite;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 */
public class RemoveInvalidParentheses {
    private Set<String> validExpressions = new HashSet<String>();
    private int minimumRemoved;

    private void helper(String s, int cur, int leftCount, int rightCount, StringBuilder curExpression, int removedCount) {
        // If we have reached the end of string.
        if (cur == s.length()) {
            // If the current curExpression is valid.
            if (leftCount == rightCount) {
                // If the current count of removed parentheses is <= the current minimum count
                if (removedCount <= minimumRemoved) {
                    // If the current count beats the overall minimum we have till now
                    if (removedCount < this.minimumRemoved) {
                        validExpressions.clear();
                        minimumRemoved = removedCount;
                    }
                    validExpressions.add(curExpression.toString());
                }
            }
        } else {
            char c = s.charAt(cur);
            int length = curExpression.length();

            // If the current character is neither an opening bracket nor a closing one, simply recurse further by adding it to the curExpression StringBuilder
            if (c != '(' && c != ')') {
                curExpression.append(c);
                helper(s, cur + 1, leftCount, rightCount, curExpression, removedCount);
                curExpression.deleteCharAt(length);
            } else {
                // Case 1: Delete the current character and move forward
                helper(s, cur + 1, leftCount, rightCount, curExpression, removedCount + 1);

                // Case 2: Not delete, keep it
                curExpression.append(c);
                // If it's an opening parenthesis, consider it and recurse
                if (c == '(') {
                    helper(s, cur + 1, leftCount + 1, rightCount, curExpression, removedCount);
                } else if (rightCount < leftCount) {
                    // For a closing parenthesis, only recurse if right < left
                    helper(s, cur + 1, leftCount, rightCount + 1, curExpression, removedCount);
                }
                curExpression.deleteCharAt(length);
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        helper(s, 0, 0, 0, new StringBuilder(), 0);
        return new LinkedList<>(validExpressions);
    }
}
