package leetcode.algo.t;

import java.util.*;

/* Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
/* build a counter map that maps a num to its frequency
 * build a heap/priority queue that keeps track of k most significant entries
 * iterate through the final heap and get the keys
 */
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> res = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, (a, b) -> a.getValue() - b.getValue());
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.offer(entry);
			if (pq.size() > k)
				pq.poll();
		}
		while (!pq.isEmpty()) {
			res.add(0, pq.poll().getKey());
		}
		return res;
	}
}
