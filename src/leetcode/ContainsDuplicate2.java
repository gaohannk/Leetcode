package leetcode;

/* Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
import java.util.HashSet;

public class ContainsDuplicate2 {

	public boolean containsDuplicate(int[] nums) {
		if (nums.length == 0)
			return false;
		return iscontainsDuplicate(nums, 0, nums.length - 1);

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
