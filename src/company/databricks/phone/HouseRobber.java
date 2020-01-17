package company.databricks.phone;

// dp[i] = Math.max(dp[i-2]+nums[i], dp[i-3]+nums[i])
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 3], dp[i - 2]) + nums[i];
        }
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }

    // allow negative
    // dp[i] rob to i, no need to rob i
    public static int rob2(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1) {
            return Math.max(nums[0], 0);
        }
        if (nums.length == 2) {
            return Math.max(Math.max(nums[0], nums[1]), 0);
        }
        int dp[] = new int[nums.length];
        dp[0] = Math.max(nums[0], 0);
        dp[1] = Math.max(nums[1], 0);
        dp[2] = Math.max(Math.max(dp[0] + nums[2], dp[0]), dp[1]);
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i] = Math.max(dp[i - 3], dp[i - 2]) + nums[i];
            } else {
                dp[i] = Math.max(dp[i - 3], dp[i - 2]);
            }
        }
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
