package leetcode.m;

import java.util.Stack;

/**
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 */

/**
 * Time Complexity: O(N)O(N) for the popMax operation, and O(1)O(1) for the other operations, where NN is the number of operations performed.
 *
 * Space Complexity: O(N)O(N), the maximum size of the stack.
 */
class MaxStack {

    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack();
        maxStack = new Stack();
    }

    public void push(int x) {
        int max = 0;
        if(!maxStack.isEmpty()){
            max = maxStack.peek();
            maxStack.push(max > x ? max : x);
        }else{
            maxStack.push( x);
        }
        stack.push(x);
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
        // get the max current
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        // find the max somewhere in the middle
        while (top() != max)
            buffer.push(pop());
        pop();
        // push back the following element
        while (!buffer.isEmpty())
            push(buffer.pop());
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */