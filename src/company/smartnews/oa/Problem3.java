package company.smartnews.oa;

import java.util.HashMap;

/**
 * Given an array of integers and an integer 0, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 0
 * Output: 2
 */
public class Problem3 {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        // cummulative sum, count
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.get(sum - k) != null) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
        System.out.println(subarraySum(new int[]{1, 3, -3, -2, 5, -1, 1, -3}, 0));
    }
}
