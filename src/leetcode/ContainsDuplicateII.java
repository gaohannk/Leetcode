package leetcode;
/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 */

import java.util.HashSet;

public class ContainsDuplicateII {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (k > nums.length)
			return false;
		if (nums.length == 1)
			return false;

		for (int i = 0; i <= nums.length - k; i++) {
			for (int j = i + 1; j <= i + k; j++) {
				if (nums[i] == nums[j])
					return true;
			}
		}
		return false;
	}

	private boolean iscontainsDuplicate(int[] nums, int i, int j) {
		int length = j - i + 1;
		if (length == 1)
			return false;
		if (length == 2 && nums[i] == nums[j])
			return true;
		if (length == 2 && nums[i] != nums[j])
			return false;
		int mid = (i + j) / 2;
		HashSet<Integer> set = new HashSet<>();
		for (int k = i; k < mid; k++) {
			set.add(nums[k]);
		}
		for (int k = mid; k <= j; k++) {
			if (set.contains(nums[k]))
				return true;
		}
		return iscontainsDuplicate(nums, i, mid) || iscontainsDuplicate(nums, mid + 1, j);
	}
}
