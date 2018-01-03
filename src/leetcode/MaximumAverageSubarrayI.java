package leetcode;

/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 * <p>
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * Note:
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 */
public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        int count = 0;
        double total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count < k) {
                total += nums[i];
                count++;
                continue;
            }
            max = total / k > max ? total / k : max;
            total += nums[i];
            total -= nums[i - k];
        }
        max = total / k > max ? total / k : max;
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
