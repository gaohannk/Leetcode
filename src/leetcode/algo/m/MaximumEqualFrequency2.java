package leetcode.algo.m;

import java.util.*;

/**
 * Given an array nums of positive integers, return the longest possible length of an array prefix of nums, such that it is possible to remove exactly one element from this prefix so that every number that has appeared in it will have the same number of occurrences.
 * <p>
 * If after removing one element there are no remaining elements, it's still considered that every appeared number has the same number of ocurrences (0).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,1,1,5,3,3,5]
 * Output: 7
 * Explanation: For the subarray [2,2,1,1,5,3,3] of length 7, if we remove nums[4]=5, we will get [2,2,1,1,3,3], so that each number will appear exactly twice.
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
 * Output: 13
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,2,2,2]
 * Output: 5
 * Example 4:
 * <p>
 * Input: nums = [10,2,8,9,3,8,1,5,2,3,7,6]
 * Output: 8
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class MaximumEqualFrequency2 {
    Map<Integer, Integer> count = new HashMap<>();
    Map<Integer, Integer> freq = new HashMap<>();

    public int maxEqualFreq(int[] nums) {
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int c = count.getOrDefault(nums[i], 0);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) - 1);
                if (freq.get(c) == 0) {
                    freq.remove(c);
                }
            }
            int nc = count.get(nums[i]);
            freq.put(nc, freq.getOrDefault(nc, 0) + 1);
            if (valid(i)) res = i + 1;
        }
        return res;
    }

    private boolean valid(int index) {
        //如果只有一个数
        if (count.size() == 1) return true;
        //如果所有数都只出现了一次
        if (count.size() == index + 1) return true;
        //
        if (freq.size() != 2) return false;

        List<Integer> freqK = new ArrayList<>(freq.keySet());
        Collections.sort(freqK);
        int f1 = freqK.get(0), f2 = freqK.get(1);
        //如果只有一个数出现了一次，其余的数都出现多次
        if (f1 == 1 && freq.get(f1) == 1) return true;
        //如果只有一个数出现次数是最多的，其余出现次数都相等并且出现的次数比较大的那个频率出现少一次
        if (freq.get(f2) == 1 && f1 + 1 == f2) return true;
        return false;
    }
}
