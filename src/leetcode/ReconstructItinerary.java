package leetcode;

import java.util.HashMap;
import java.util.Random;

/* Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. 
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * Example 2:
 * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class ReconstructItinerary {
	public class RandomizedSet {
		private HashMap<Integer, Integer> keyMap = null;
		private HashMap<Integer, Integer> valueMap = null;
		int count;

		/** Initialize your data structure here. */
		public RandomizedSet() {
			keyMap = new HashMap<Integer, Integer>();
			valueMap = new HashMap<Integer, Integer>();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already
		 * contain the specified element.
		 */
		public boolean insert(int val) {
			if (keyMap.containsKey(val)) {
				return false;
			} else {
				keyMap.put(val, count);
				valueMap.put(count, val);
				count = keyMap.size();
				return true;
			}
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the
		 * specified element.
		 */
		public boolean remove(int val) {
			if (!keyMap.containsKey(val)) {
				return false;
			} else {
				int valueKey = keyMap.get(val);
				keyMap.remove(val);
				if (valueKey != valueMap.size() - 1) {
					valueMap.put(valueKey, valueMap.get(valueMap.size() - 1));
					keyMap.put(valueMap.get(valueMap.size() - 1), valueKey);
					valueMap.remove(valueMap.size() - 1);
				} else {
					valueMap.remove(valueKey);
				}
				count = keyMap.size();
				return true;
			}
		}

		/** Get a random element from the set. */
		public int getRandom() {
			Random random = new Random();
			int n = random.nextInt(keyMap.size());
			return valueMap.get(n);
		}
	}
}
