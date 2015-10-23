package leetcode;

/* Given a string containing just the characters '(' and ')',  * find the length of the longest 
 * valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
import java.util.Stack;

/* 1.stack里一直是“还没配对的括号的index”
 * 2 是'(‘的时候push
 * 3 是’)’的时候，说明可能配对了；看stack top是不是左括号，不是的话，push当前右括号,是的话，pop那个配对的左括号，然后update res：
 * i和top的（最后一个配不成对的）index相减，就是i属于的这一段的当前最长。如果一pop就整个栈空了，说明前面全配好对了，那res就是最大=i+1
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int res = 0;
		Stack<Integer> stack = new Stack<Integer>();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ')' && !stack.isEmpty() && arr[stack.peek()] == '(') {
				stack.pop();
				if (stack.isEmpty())
					res = i + 1;
				else
					res = Math.max(res, i - stack.peek());
			} else {
				stack.push(i);
			}
		}
		return res;
	}
}
