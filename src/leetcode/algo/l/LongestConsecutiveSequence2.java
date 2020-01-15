package leetcode.algo.l;

import java.util.HashSet;
import java.util.Set;

/* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence2 {
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int res = 1;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i] - 1)) {
				int count = 1;
				int cur = nums[i] + 1;
				while (set.contains(cur)) {
					cur++;
					count++;
				}
				res = Math.max(res, count);

			}
		}
		return res;
	}
}