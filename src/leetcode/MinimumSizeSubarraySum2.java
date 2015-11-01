package leetcode;

/* Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. 
 * If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum2 {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0)
			return 0;
		int start = 0, end = nums.length - 1;
		return helper(s, nums, start, end);
	}

	private int helper(int s, int[] nums, int start, int end) {
		if (start > end)
			return Integer.MAX_VALUE;
		int mid = (start + end) / 2;
		int sum = 0;
		int p1 = mid;
		int p2 = mid ;
		int res = Integer.MAX_VALUE;
		while (sum < s && p2 <= end && p1 >= start) {
			if (nums[p1] < nums[p2]) {
				sum += nums[p2];
				p2++;
			} else {
				sum += nums[p1];
				p1--;
			}
		}
		res = p2 - p1 + 1;
		res = Math.min(res, Math.min(helper(s, nums, start, mid - 1), helper(s, nums, mid + 1, end)));
		return res;
	}
}
