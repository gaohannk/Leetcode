package leetcode;

/* Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
//TLE
public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		for (int l = 1; l <= k; l++) {
			for (int i = 0; i < nums.length - k; i++) {
				int j = i + l;
				if (Math.abs(nums[i] - nums[j])<=t)
					return true;
			}
		}
		return false;
	}
}
