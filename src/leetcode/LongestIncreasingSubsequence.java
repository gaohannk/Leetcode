package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
*/
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		List<ValAndIndex> l = new ArrayList<ValAndIndex>();
		for (int i = 0; i < nums.length; i++)
			l.add(new ValAndIndex(nums[i], i));
		int max = l.isEmpty() ? 0 : 1;
		Collections.sort(l, new Comparator<ValAndIndex>() {
			@Override
			public int compare(ValAndIndex o1, ValAndIndex o2) {
				return o1.val - o2.val;
			}
		});
		for (int i = 0; i < nums.length; i++) {
			ValAndIndex v1 = l.get(i);
			for (int j = i + 1; j < nums.length; j++) {
				ValAndIndex v2 = l.get(j);
				if (v2.val > v1.val && v2.idx > v1.idx && v2.cnt <= v1.cnt) {
					v2.cnt = v1.cnt + 1;
					max = v2.cnt > max ? v2.cnt : max;
				}
			}
		}
		return max;
	}

	private class ValAndIndex {
		private int val;
		private int idx;
		private int cnt = 1;

		public ValAndIndex(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}
}
