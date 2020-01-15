package company.oracle.phone;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence3 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int count = 1;
                int cur = nums[i] + 1;
                while (set.contains(cur)) {
                    cur++;
                    count++;
                }
                res = Math.max(res, count);

            }
        }
        return res;
    }
}
