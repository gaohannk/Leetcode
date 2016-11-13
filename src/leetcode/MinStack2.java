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

import java.util.LinkedList;
import java.util.List;

public class MinStack2 {
    List<Integer> s = new LinkedList();
    List<Integer> min = new LinkedList();

    public void push(int x) {
        if (min.isEmpty()) min.add(x);
        else if (x <= min.get(min.size() - 1)) min.add(x);
        s.add(x);
    }

    public void pop() {
        if (s.size() < 1) return;
        if (top() == min.get(min.size() - 1)) min.remove(min.size() - 1);
        s.remove(s.size() - 1);
    }

    public int top() {
        if (s.size() < 1) return 0;
        return s.get(s.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }
}
