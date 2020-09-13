package leetcode.algo;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.
 *
 * A subarray of an array is a consecutive sequence of zero or more values taken out of that array.
 *
 * Return the maximum length of a subarray with positive product.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,-2,-3,4]
 * Output: 4
 * Explanation: The array nums already has a positive product of 24.
 * Example 2:
 *
 * Input: nums = [0,1,-2,-3,-4]
 * Output: 3
 * Explanation: The longest subarray with positive product is [1,-2,-3] which has a product of 6.
 * Notice that we cannot include 0 in the subarray since that'll make the product 0 which is not positive.
 * Example 3:
 *
 * Input: nums = [-1,-2,-3,0,1]
 * Output: 2
 * Explanation: The longest subarray with positive product is [-1,-2] or [-2,-3].
 * Example 4:
 *
 * Input: nums = [-1,2]
 * Output: 1
 * Example 5:
 *
 * Input: nums = [1,2,3,5,-6,4,0,10]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
// TLE
public class MaximumLengthofSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int maxCount = 0;
        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                l.add(nums[i]);
            } else {
                if (l.size() != 0) {
                    maxCount = Math.max(maxCount, getPositiveProductLen(l));
                    l = new LinkedList<>();
                }
            }
        }
        if (l.size() != 0) {
            maxCount = Math.max(maxCount, getPositiveProductLen(l));
        }
        return maxCount;
    }

    private int getPositiveProductLen(List<Integer> list) {
        int negCount = 0, firstNeg = 0, lastNeg = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) {
                negCount++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) {
                firstNeg = i;
                break;
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) < 0) {
                lastNeg = i;
                break;
            }
        }
        return negCount % 2 == 0 ? list.size() : Math.max(list.size() - firstNeg - 1, lastNeg);
    }
}
