package leetcode;
/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
 * such that lists[i] = lists[j] and the difference between i and j is at most k.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContainsDuplicateII2 {
	class Pair {
		int val;
		int index;

		public Pair(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		List<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < nums.length; i++) {
			Pair a = new Pair(nums[i], i);
			list.add(a);
		}
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.val - p2.val;
			}

		});
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).val == list.get(i + 1).val) {
				if (Math.abs(list.get(i).index - list.get(i + 1).index) <= k) {
					return true;
				}
			}
		}
		return false;
	}
}
