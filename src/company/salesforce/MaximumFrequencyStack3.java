package company.salesforce;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

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
// Using Treemap
public class MaximumFrequencyStack3 {
    class FreqStack {
        // key: freq value: Stack of value
        TreeMap<Integer, Stack<Integer>> freqValueMap;
        Map<Integer, Integer> valueFreqMap;

        public FreqStack() {
            this.freqValueMap = new TreeMap<>();
            this.valueFreqMap = new HashMap<>();
        }

        public void push(int x) {
            valueFreqMap.put(x, valueFreqMap.getOrDefault(x, 0) + 1);
            int f = valueFreqMap.get(x);
            if (freqValueMap.get(f) == null) {
                freqValueMap.put(f, new Stack<>());
            }
            freqValueMap.get(f).push(x);
        }

        public int pop() {
            int max = freqValueMap.lastKey();
            int ret = freqValueMap.get(max).pop();
            if (freqValueMap.get(max).isEmpty()) {
                freqValueMap.remove(max);
            }
            valueFreqMap.put(ret, valueFreqMap.get(ret) - 1);

            return ret;
        }
    }
}
