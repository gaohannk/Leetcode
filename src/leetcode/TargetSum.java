package leetcode;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * <p>
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * <p>
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer
 */
public class TargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        int[] symbols = {1, -1};
        return helper(nums, S, symbols, 0, 0);

    }

    private static int helper(int[] nums, int target, int[] symbols, int curSum, int index) {
        if (index >= nums.length) {
            if (curSum == target)
                return 1;
            return 0;
        }
        int res = 0;
        for (int i = 0; i < symbols.length; i++) {
            curSum += symbols[i] * nums[index];
            res += helper(nums, target, symbols, curSum, index + 1);
            curSum -= symbols[i] * nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(findTargetSumWays(nums, S));
    }
}
