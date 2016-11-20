package leetcode;

/**
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * <p>
 * Note: n will be less than 15,000.
 * <p>
 * Example 1:
 * Input: [1, 2, 3, 4]
 * <p>
 * Output: False
 * <p>
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * Input: [3, 1, 4, 2]
 * <p>
 * Output: True
 * <p>
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * <p>
 * Output: True
 * <p>
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            int bigger = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                // 1. We don't care about numbers
                // less than a[i]
                if (nums[j] <= nums[i]) continue;

                // 2. If num is greater than bigger
                // then update bigger
                if (nums[j] >= bigger) {
                    bigger = nums[j];
                } else {
                    // Now this number is greater than nums[i] see 1. and less than bigger, see 2.
                    return true;
                }
            }
        }
        return false;
    }
}
