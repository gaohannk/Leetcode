package leetcode;

/* Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
// Binary Search TLE
public class ContainsDuplicateIII2 {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		int start = 0, end = nums.length - 1;
		return helper(start, end, nums, k, t);

	}

	private static boolean helper(int start, int end, int[] nums, int k, int t) {
		int mid = 0;
		if (start >= end)
			return false;
		for (int l = 1; l <= k; l++) {
			mid = start + (end - start) / 2;
			for (int i = 0; i <= l; i++) {
				if (mid - i >= 0 && mid + l - i <= nums.length - 1 && Math.abs(nums[mid - i] - nums[mid + l - i]) <= t){
					System.out.println(nums[mid-i]+":"+nums[mid+l-i]);
					return true;
				}
			}
		}
		return helper(mid + 1, end, nums, k, t) || helper(start, mid - 1, nums, k, t);
	}

	public static void main(String[] args) {

		int nums[] = { 1, 6, 14, 10, 24, 3 };
		System.out.println(containsNearbyAlmostDuplicate(nums, 2, 3));
	}
}
