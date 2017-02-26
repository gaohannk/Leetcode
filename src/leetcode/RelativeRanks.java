package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * <p>
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1)
                res[map.get(nums[i])] = "Gold Medal";
            else if (i == nums.length - 2)
                res[map.get(nums[i])] = "Silver Medal";
            else if (i == nums.length - 3)
                res[map.get(nums[i])] = "Bronze Medal";
            else
                res[map.get(nums[i])] = Integer.toString(nums.length - i);

        }
        return res;
    }
}
