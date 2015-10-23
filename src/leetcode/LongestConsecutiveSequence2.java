package leetcode;

import java.util.HashSet;

/* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence2 {
	public int longestConsecutive(int[] num) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++)
			set.add(num[i]);

		int res = 1;
		int count = 1;
		for (int i : num) {
			set.remove(i);
			int left = i - 1;
			while (set.contains(left)) {
				set.remove(left);
				count++;
				left--;
			}
			int right = i + 1;
			while (set.contains(right)) {
				set.remove(right);
				right++;
				count++;
			}
			if (count > res)
				res = count;
			count = 1;
		}
		return res;
	}
}