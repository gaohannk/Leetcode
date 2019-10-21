package leetcode;

import java.util.*;

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
public class TwoSumIIIDatastructuredesign2 {
    class TwoSum {

        private List<Integer> nums = new ArrayList<>();

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {

        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            nums.add(number);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            Collections.sort(nums);

            int i = 0, j = nums.size() - 1;

            while (i < j) {
                if ((nums.get(i) + nums.get(j)) == value)
                    return true;
                else if ((nums.get(i) + nums.get(j)) > value)
                    j--;
                else
                    i++;
            }
            return false;
        }
    }
}
