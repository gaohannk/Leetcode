package company.databricks.onsite;
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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class InsertDeleteGetRandom {
	public class RandomizedSet {
		private Random rnd;
		private HashMap<Integer, Integer> num2index;
		private LinkedList<Integer> list ;

		/** Initialize your data structure here. */
		public RandomizedSet() {
			rnd = new Random();
			list= new LinkedList<>();
			num2index = new HashMap<>();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already
		 * contain the specified element.
		 */
		public boolean insert(int val) {
			if (num2index.containsKey(val)) {
				return false;
			}

			num2index.put(val, list.size());
			list.add(val);
			return true;
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the
		 * specified element.
		 */
		public boolean remove(int val) {
			 if(!num2index.containsKey(val)) {
		            return false;
		        }
		        
		        int idx = num2index.remove(val); // remove our val from mapping
		        int lastValue = list.remove(list.size() - 1);// remove the last item
		        if(val != lastValue) {
		            list.set(idx, lastValue); // set the current item to equal the last item
		            num2index.put(lastValue, idx); // num2index the last item to our current index
		        }
		        return true;
		}

		/** Get a random element from the set. */
		public int getRandom() {
			 return list.get(rnd.nextInt(list.size()));
		}
	}

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet(); boolean param_1 =
	 * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
	 * obj.getRandom();
	 */
}
