package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. 
 * You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class ImplementStackusingQueues {
	class MyStack {
		Queue<Integer> queue = new LinkedList<Integer>();
		int count;
		// Push element x onto stack.
		public void push(int x) {
			queue.add(x);
			count++;
		}

		// Removes the element on top of the stack.
		public void pop() {
			Queue<Integer> temp = new LinkedList<Integer>();
			int i=count;
			while (i>1) {
				temp.add(queue.poll());
				i--;
			}
			queue.poll();
			while (!temp.isEmpty())
				queue.add(temp.poll());
			count--;
		}

		// Get the top element.
		public int top() {
			Queue<Integer> temp = new LinkedList<Integer>();
			int i= count;
			while (i>1) {
				temp.add(queue.poll());
				i--;
			}
			int res=queue.poll();
			while (!temp.isEmpty())
				queue.add(temp.poll());
			queue.add(res);
			return res;
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return queue.isEmpty();
		}
	}
}
