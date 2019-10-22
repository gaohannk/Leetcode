package leetcode.algo.m;

/* Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */

public class MinimumSizeSubarraySum4 {
    public static int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res != Integer.MAX_VALUE ? res : 0;
    }
}
