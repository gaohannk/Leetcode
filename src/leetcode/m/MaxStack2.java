package leetcode.m;

import java.util.*;

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
 * <p>
 * Using structures like Array or Stack will never let us popMax quickly. We turn our attention to tree and linked-list structures that have a lower time complexity for removal, with the aim of making popMax faster than O(N)O(N) time complexity.
 * <p>
 * Say we have a double linked list as our "stack". This reduces the problem to finding which node to remove, since we can remove nodes in O(1) time.
 * <p>
 * We can use a TreeMap mapping values to a list of nodes to answer this question. TreeMap can find the largest value, insert values, and delete values, all in O(logN) time.
 * <p>
 * Using structures like Array or Stack will never let us popMax quickly. We turn our attention to tree and linked-list structures that have a lower time complexity for removal, with the aim of making popMax faster than O(N)O(N) time complexity.
 * <p>
 * Say we have a double linked list as our "stack". This reduces the problem to finding which node to remove, since we can remove nodes in O(1) time.
 * <p>
 * We can use a TreeMap mapping values to a list of nodes to answer this question. TreeMap can find the largest value, insert values, and delete values, all in O(logN) time.
 * <p>
 * Using structures like Array or Stack will never let us popMax quickly. We turn our attention to tree and linked-list structures that have a lower time complexity for removal, with the aim of making popMax faster than O(N)O(N) time complexity.
 * <p>
 * Say we have a double linked list as our "stack". This reduces the problem to finding which node to remove, since we can remove nodes in O(1) time.
 * <p>
 * We can use a TreeMap mapping values to a list of nodes to answer this question. TreeMap can find the largest value, insert values, and delete values, all in O(logN) time.
 * <p>
 * Using structures like Array or Stack will never let us popMax quickly. We turn our attention to tree and linked-list structures that have a lower time complexity for removal, with the aim of making popMax faster than O(N)O(N) time complexity.
 * <p>
 * Say we have a double linked list as our "stack". This reduces the problem to finding which node to remove, since we can remove nodes in O(1) time.
 * <p>
 * We can use a TreeMap mapping values to a list of nodes to answer this question. TreeMap can find the largest value, insert values, and delete values, all in O(logN) time.
 */

/**
 * Using structures like Array or Stack will never let us popMax quickly. We turn our attention to tree and linked-list structures that have a lower time complexity for removal, with the aim of making popMax faster than O(N)O(N) time complexity.
 *
 * Say we have a double linked list as our "stack". This reduces the problem to finding which node to remove, since we can remove nodes in O(1) time.
 *
 * We can use a TreeMap mapping values to a list of nodes to answer this question. TreeMap can find the largest value, insert values, and delete values, all in O(logN) time.
 */

/**
 * Complexity Analysis
 *
 * Time Complexity: O(log N) for all operations except peek which is O(1), where NN is the number of operations performed. Most operations involving TreeMap are O(logN).
 *
 * Space Complexity: O(N), the size of the data structures used.
 */
class MaxStack2 {

    class Node {
        int val;

        public Node(int v) {
            val = v;
        }
    }


    TreeMap<Integer, List<Node>> map;
    LinkedList<Node> dll;

    public MaxStack2() {
        map = new TreeMap();
        dll = new LinkedList<>();
    }

    public void push(int x) {
        dll.addFirst(new Node(x));
        if (!map.containsKey(x))
            map.put(x, new ArrayList<>());
        map.get(x).add(dll.peek());
    }

    public int pop() {
        int val = dll.pop().val;
        List<Node> L = map.get(val);
        L.remove(L.size() - 1);
        if (L.isEmpty())
            map.remove(val);
        return val;
    }

    public int top() {
        return dll.peek().val;
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = peekMax();
        List<Node> L = map.get(max);
        Node node = L.remove(L.size() - 1);
        dll.remove(node);
        if (L.isEmpty())
            map.remove(max);
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