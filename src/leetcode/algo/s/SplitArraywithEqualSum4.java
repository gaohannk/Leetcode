package leetcode.algo.s;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:
 * <p>
 * 0 < i, i + 1 < j, j + 1 < k < n - 1
 * Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
 * where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
 * Example:
 * Input: [1,2,1,2,1,2,1]
 * Output: True
 * Explanation:
 * i = 1, j = 3, k = 5.
 * sum(0, i - 1) = sum(0, 0) = 1
 * sum(i + 1, j - 1) = sum(2, 2) = 1
 * sum(j + 1, k - 1) = sum(4, 4) = 1
 * sum(k + 1, n - 1) = sum(6, 6) = 1
 * Note:
 * 1 <= n <= 2000.
 * Elements in the given array will be in range [-1,000,000, 1,000,000].
 */
// TODO
public class SplitArraywithEqualSum4 {
    public boolean splitArray(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int summ = 0, tot = 0;
        for (int i = 0; i < nums.length; i++) {
            summ += nums[i];
            if (map.containsKey(summ))
                map.get(summ).add(i);
            else {
                map.put(summ, new ArrayList<Integer>());
                map.get(summ).add(i);
            }
            tot += nums[i];
        }
        summ = nums[0];
        for (int i = 1; i < nums.length - 5; i++) {
            if (map.containsKey(2 * summ + nums[i])) {
                for (int j : map.get(2 * summ + nums[i])) {
                    j++;
                    if (j > i + 1 && j < nums.length - 3 && map.containsKey(3 * summ + nums[i] + nums[j])) {
                        for (int k : map.get(3 * summ + nums[j] + nums[i])) {
                            k++;
                            if (k < nums.length - 1 && k > j + 1 && 4 * summ + nums[i] + nums[j] + nums[k] == tot)
                                return true;
                        }
                    }
                }
            }
            summ += nums[i];
        }
        return false;
    }
}
