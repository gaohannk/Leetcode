package leetcode.algo.w;

import java.util.Arrays;

/* Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSortII {

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] nums0 = new int[nums.length + 1];
        for (int i = (nums.length + 1) / 2 - 1, j = nums.length - 1, cur = 0; i >= 0; nums0[cur++] = nums[i--], nums0[cur++] = nums[j--])
            ;
        System.arraycopy(nums0, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

}
