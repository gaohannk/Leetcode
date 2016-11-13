package leetcode;

import java.util.HashMap;
import java.util.Random;

/*Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 1 is the only number in the set, getRandom always return 1.
randomSet.getRandom();
*/

public class InsertDeleteGetRandom2 {
    public class RandomizedSet {
        private Random rnd;
        private HashMap<Integer, Integer> index2Num;
        private HashMap<Integer, Integer> num2Index;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            size = 0;
            rnd = new Random();
            index2Num = new HashMap<>();
            num2Index = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already
         * contain the specified element.
         */
        public boolean insert(int val) {
            if (num2Index.containsKey(val))
                return false;
            num2Index.put(val, size);
            index2Num.put(size, val);
            size++;
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the
         * specified element.
         */
        public boolean remove(int val) {
            if (!num2Index.containsKey(val))
                return false;
            int index = num2Index.get(val);
            size--;
            num2Index.remove(val);
            if (index == size) {
                index2Num.remove(index);
            } else {
                int num = index2Num.get(size);
                index2Num.remove(size);
                num2Index.put(num, index);
                index2Num.put(index, num);
            }
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return index2Num.get(rnd.nextInt(size));
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet(); boolean param_1 =
     * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
     * obj.getRandom();
     */
}
