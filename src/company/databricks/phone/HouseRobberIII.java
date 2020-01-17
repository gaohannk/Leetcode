package company.databricks.phone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static company.databricks.phone.HouseRobber.rob2;

public class HouseRobberIII {
    char[] backtrack;

    // if is cycle
    // print path
    public List<Integer> rob3(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return new LinkedList<>();
        if (nums.length == 1) {
            if (nums[0] > 0) {
                res.add(nums[0]);
            }
            return res;
        }
        if (nums.length == 2) {
            int max = Math.max(Math.max(nums[0], nums[1]), 0);
            if (max == nums[0]) {
                res.add(nums[0]);
            } else {
                res.add(nums[1]);
            }
            return res;
        }
        int max = Math.max(rob2(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                rob2(Arrays.copyOfRange(nums, 1, nums.length)));
        traverseBacktrack(backtrack, res);
        return res;
    }

    private void traverseBacktrack(char[] backtrack, List<Integer> res) {
    }

    public static int rob2(int[] nums) {
        int[] backtrack = new int[nums.length];
        if (nums.length == 0)
            return 0;
        if (nums.length == 1) {
            return Math.max(nums[0], 0);
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int dp[] = new int[nums.length];
        dp[0] = Math.max(nums[0], 0);
        dp[1] = Math.max(nums[1], 0);
        dp[2] = Math.max(Math.max(dp[0] + nums[2], dp[0]), dp[1]);
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (dp[i - 3] > dp[i - 2]) {
                    backtrack[i] = 'A';
                } else {
                    backtrack[i] = 'B';
                }
                dp[i] = Math.max(dp[i - 3], dp[i - 2]) + nums[i];
            } else {
                if (dp[i - 3] > dp[i - 2]) {
                    backtrack[i] = 'C';
                } else {
                    backtrack[i] = 'D';
                }
                dp[i] = Math.max(dp[i - 3], dp[i - 2]);
            }
        }
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
