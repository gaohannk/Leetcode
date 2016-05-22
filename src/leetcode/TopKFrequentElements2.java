package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/* Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

public class TopKFrequentElements2 {

	public List<Integer> topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> cntMap = new HashMap<>();

		// loop nums
		Arrays.stream(nums).forEach(n -> {
			Integer cnt = cntMap.getOrDefault(n, 0);
			cntMap.put(n, cnt + 1);
		});

		// sort the map by value
		return cntMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed()).limit(k)
				.map(m -> m.getKey()).collect(Collectors.toList());

	}
}
