package leetcode.algo.w;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
// O(nlogn) Two pointer
public class WiggleSortII3 {

    public static void wiggleSort(int[] nums) {
        int sortedNums[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int len = nums.length;
        int mid = (len + 1) / 2;
        int front = 0;
        int i = len - 1;
        while (i >= 0) {
            if (i % 2 == 1) {
                nums[i] = sortedNums[mid++];
            } else {
                nums[i] = sortedNums[front++];
            }
            i--;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
//        int[] nums = {1, 3, 2, 2, 3, 1};
        wiggleSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

}
