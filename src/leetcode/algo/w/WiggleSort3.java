package leetcode.algo.w;

import java.util.Arrays;

/* Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
/* Time O(nlogn)
 * Space O(1)
 */
public class WiggleSort3 {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (((i % 2 == 1) && nums[i - 1] > nums[i])
                    || ((i % 2 == 0) && nums[i - 1] < nums[i])) {
                swap(nums, i - 1, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
