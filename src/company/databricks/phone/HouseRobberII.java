package company.databricks.phone;

import java.util.Arrays;

import static company.databricks.phone.HouseRobber.rob2;

public class HouseRobberII {

    // if is cycle
    public int rob3(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1) {
            return Math.max(nums[0], 0);
        }
        if (nums.length == 2) {
            return Math.max(Math.max(nums[0], nums[1]), 0);
        }
        return Math.max(rob2(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                rob2(Arrays.copyOfRange(nums, 1, nums.length)));
    }
}
