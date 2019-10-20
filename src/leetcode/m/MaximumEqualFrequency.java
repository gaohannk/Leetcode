package leetcode.m;

import java.util.HashMap;

/**
 * Given an array nums of positive integers, return the longest possible length of an array prefix of nums, such that it is possible to remove exactly one element from this prefix so that every number that has appeared in it will have the same number of occurrences.
 *
 * If after removing one element there are no remaining elements, it's still considered that every appeared number has the same number of ocurrences (0).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1,1,5,3,3,5]
 * Output: 7
 * Explanation: For the subarray [2,2,1,1,5,3,3] of length 7, if we remove nums[4]=5, we will get [2,2,1,1,3,3], so that each number will appear exactly twice.
 * Example 2:
 *
 * Input: nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
 * Output: 13
 * Example 3:
 *
 * Input: nums = [1,1,1,2,2,2]
 * Output: 5
 * Example 4:
 *
 * Input: nums = [10,2,8,9,3,8,1,5,2,3,7,6]
 * Output: 8
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class MaximumEqualFrequency {
    public int maxEqualFreq(int[] nums) {
        // k: number, v: appear times for this number
        HashMap<Integer, Integer> countMap = new HashMap<>();
        // k: freq, v:times for this freq
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            int count = countMap.get(nums[i]);
            freqMap.put(count, freqMap.getOrDefault(count, 0) + 1);
            // 1112223334, 1122334
            if (count * freqMap.get(count) == i + 1) {
                int size = (i == nums.length - 1) ? i : i + 2;
                res = Math.max(size, res);
                // 111222333
            } else if (count * freqMap.get(count) == i) {
                res = Math.max(i + 1, res);
            }
        }
        return res;
    }
}
