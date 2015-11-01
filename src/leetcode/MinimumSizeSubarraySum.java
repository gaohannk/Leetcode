package leetcode;

/* Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. 
 * If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
//TLE
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int sum = 0;
		int p1 = 0;
		int p2 = 0;
		int res = Integer.MAX_VALUE;
		while (p1 < nums.length) {
			while (sum < s) {
				if (p2 >= nums.length)
					break;
				sum += nums[p2];
				p2++;
			}
			int length = p2 - p1 + 1;
			res = res < length ? res : length;
			while (sum >= s) {
				sum -= nums[p1];
				p1++;
			}
		}
		return res;
	}
}
