package leetcode.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * <p>
 * Example 1:
 * <p>
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * Example 2:
 * <p>
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 */
public class TwoSumIIIDatastructuredesign {
    class TwoSum {

        Map<Integer, Integer> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {

        }

        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (int num : map.keySet()) {
                int comp = value - num;
                if (map.containsKey(comp)) {
                    if (num == comp) {
                        if (map.get(num) >= 2)
                            return true;
                        else continue;
                    }
                    if (map.get(comp) > 0)
                        return true;
                }
            }
            return false;
        }
    }
}
