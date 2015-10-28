package leetcode;

import java.util.Stack;

/*Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueusingStacks {
	class MyQueue {
		Stack<Integer> stack = new Stack<Integer>();

		// Push element x to the back of queue.
		public void push(int x) {
			stack.push(x);
		}

		// Removes the element from in front of queue.
		public void pop() {
			Stack<Integer> temp = new Stack<>();
			while (!stack.isEmpty()) {
				temp.add(stack.pop());
			}
			temp.pop();
			while (!temp.isEmpty())
				stack.add(temp.pop());
		}

		// Get the front element.
		public int peek() {
			Stack<Integer> temp = new Stack<>();
			while (!stack.isEmpty()) {
				temp.add(stack.pop());
			}
			int r = temp.peek();
			while (!temp.isEmpty())
				stack.add(temp.pop());
			return r;
		}

		// Return whether the queue is empty.
		public boolean empty() {
			return stack.isEmpty();
		}
	}
}
