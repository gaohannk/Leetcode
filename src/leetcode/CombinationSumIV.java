package leetcode;

/* Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
Example:
nums = [1, 2, 3]
target = 4
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
*/
//TLE
public class CombinationSumIV {
	public static int combinationSum4(int[] nums, int target) {
		int dp[] = new int[target];
		for (int i = 1; i < target; i++) {
			dp[i] = -1;
		}
		return helper(nums, target, dp);

	}

	private static int helper(int[] nums, int target, int[] dp) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target - nums[i] > 0) {
				if (dp[target - nums[i]] == -1)
					dp[target - nums[i]] = helper(nums, target - nums[i], dp);
				res += dp[target - nums[i]];
			} else if (target - nums[i] == 0)
				res++;
		}
		return res;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };
		System.out.println(combinationSum4(nums, 32));
	}
}
