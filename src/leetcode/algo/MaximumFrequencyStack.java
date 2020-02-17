package leetcode.algo;

import java.util.*;

/**
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 *
 * FreqStack has two functions:
 *
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 *
 *
 * Example 1:
 *
 * Input:
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * Output: [null,null,null,null,null,null,null,5,7,5,4]
 * Explanation:
 * After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:
 *
 * pop() -> returns 5, as 5 is the most frequent.
 * The stack becomes [5,7,5,7,4].
 *
 * pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
 * The stack becomes [5,7,5,4].
 *
 * pop() -> returns 5.
 * The stack becomes [5,7,4].
 *
 * pop() -> returns 4.
 * The stack becomes [5,7].
 */
// TLE
public class MaximumFrequencyStack {
    class FreqStack {
        // key: integer value: freq
        Map<Integer, Integer> map;
        List<Integer> list;

        public FreqStack() {
            this.map = new HashMap<>();
            this.list = new LinkedList<>();
        }

        public void push(int x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            list.add(x);
        }

        public int pop() {
            int max = 0;
            Set<Integer> set = new HashSet<>();
            for (int key : map.keySet()) {
                if (max < map.get(key)) {
                    max = map.get(key);
                    set.clear();
                    set.add(key);
                } else if (max == map.get(key)) {
                    set.add(key);
                }
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                int ele = list.get(i);
                if (set.contains(ele)) {
                    if (map.get(ele) == 1) {
                        map.remove(ele);
                    } else {
                        map.put(ele, map.get(ele) - 1);
                    }
                    return list.remove(i);
                }
            }
            return -1;
        }
    }
}
