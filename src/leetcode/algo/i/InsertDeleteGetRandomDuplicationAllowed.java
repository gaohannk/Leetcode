package leetcode.algo.i;
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

import java.util.*;

public class InsertDeleteGetRandomDuplicationAllowed {
     class RandomizedCollection {
        LinkedList<Integer> lst;
        HashMap<Integer, Set<Integer>> idx;
        java.util.Random rand = new java.util.Random();

        /**
         * Initialize your data structure here.
         */

        public RandomizedCollection() {
            lst = new LinkedList<Integer>();
            idx = new HashMap<Integer, Set<Integer>>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!idx.containsKey(val)) {
                idx.put(val, new LinkedHashSet<Integer>());
            }
            idx.get(val).add(lst.size());
            lst.add(val);
            return idx.get(val).size() == 1;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!idx.containsKey(val) || idx.get(val).size() == 0)
                return false;
            int remove_idx = idx.get(val).iterator().next();
            idx.get(val).remove(remove_idx);
            int last = lst.get(lst.size() - 1);
            lst.set(remove_idx, last); // update value for last
            idx.get(last).add(remove_idx); // add new relationship for last
            idx.get(last).remove(lst.size() - 1); // remove old relationship for last
            lst.remove(lst.size() - 1); // remove last
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return lst.get(rand.nextInt(lst.size()));
        }
    }
}
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
