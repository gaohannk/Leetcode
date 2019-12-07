package leetcode;

import java.util.Arrays;

/* Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1,
 * then 3 steps to the last index.)
 */
/* DP: let F(i) denote the minimum number of jumps, then we have F(i) = min(F(j) ) + 1 where j = 0, … i – 1 && from j can reach i,
 * A better way to save time is to keep track of j, because dp is in increasing order (obviously proven from above formula),
 * each time we just have to check the first j that satisfies from j can reach i, thus reduce time to O(N)
 */
public class JumpGameII3 {
    public int jump(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1, j = 0; i < nums.length; i++) {

            for (; j <= i - 1; j++) {
                if (j + nums[j] >= i) { // can reach
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}