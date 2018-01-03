package leetcode;

import java.util.Arrays;

/**
 * In a given integer array nums, there is always exactly one largest element.
 * <p>
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 * <p>
 * If it is, return the index of the largest element, otherwise return -1.
 * <p>
 * Example 1:
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 * Note:
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 */
public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        if (nums.length < 2)
            return -1;
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int largestID = -1;
        int secondID = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                second =largest;
                secondID = largestID;
                largest = nums[i];
                largestID = i;
            } else if (second < nums[i] && nums[i] < largest) {
                second = nums[i];
                secondID = i;
            }
        }
        if (nums[largestID] >= nums[secondID] * 2)
            return largestID;
        return -1;
    }
}
