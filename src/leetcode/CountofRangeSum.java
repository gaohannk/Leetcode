package leetcode;

/* Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * Example:
 * Given nums = [-2, 5, -1], lower = -2, upper = 2,
 * Return 3.
 * The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 */
//TLE
public class CountofRangeSum {
	public int countRangeSum(int[] nums, int lower, int upper) {
		if (nums.length == 0)
			return 0;
		int[] sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++)
			sum[i + 1] = sum[i] + nums[i];

		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j <= nums.length; j++) {
				if (lower <= sum[j] - sum[i] && sum[j] - sum[i] <= upper)
					ans++;
			}
		}
		return ans;
	}
}
