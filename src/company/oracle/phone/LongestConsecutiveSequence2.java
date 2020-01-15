package company.oracle.phone;

import java.util.Arrays;

public class LongestConsecutiveSequence2 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 1, res = 1;
        for (int i = 1; i < nums.length; i++) {
            // Don't forget this
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        res = Math.max(res, count);
        return res;
    }
}
