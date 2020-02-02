package company.linkedin;

import java.util.Stack;

public class MaxStack {

    Stack<Integer> stack;
    Stack<Integer> maxStack;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!maxStack.isEmpty() && maxStack.peek() > x) {
            maxStack.push(maxStack.peek());
        } else {
            maxStack.push(x);
        }
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        if (stack.peek() == max) {
            maxStack.pop();
            return stack.pop();
        }
        Stack<Integer> temp = new Stack<>();
        while (stack.peek() != max) {
            temp.push(pop());
        }
        pop(); // pop max value in stack
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return max;
    }
}
