package leetcode;
/* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) – Push element x onto stack.
 * pop() – Removes the element on top of the stack.
 * top() – Get the top element.
 * getMin() – Retrieve the minimum element in the stack.
 * Hints:
 * Consider space-time tradeoff. How would you keep track of the minimums using extra space?
 * Make sure to consider duplicate elements.
 */
/* O(n) runtime, O(n) space – Minor space optimization:
 * If a new element is larger than the current minimum, we do not need to push it on to the min stack. 
 * When we perform the pop operation, check if the popped element is the same as the current minimum. 
 * If it is, pop it off the min stack too.
 */
import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		if (stack.peek().equals(minStack.peek()))
			minStack.pop();
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
