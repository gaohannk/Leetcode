package company.offerup.oa;

public class MamimumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            if (res < dp[i]) {
                res = dp[i];
            }
        }
        return res;
    }
}
