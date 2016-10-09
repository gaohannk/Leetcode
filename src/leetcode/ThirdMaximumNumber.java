package leetcode;

/**
 * Given an array of integers, return the 3rd Maximum Number in this array, if it doesn't exist, return the Maximum Number. The time complexity must be O(n) or less.
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int max[] = new int[3];
        for (int i = 0; i < max.length; i++) {
            max[i] = Integer.MIN_VALUE;
        }
        if (nums[0] < nums[1]) {
            max[0] = nums[1];
            max[1] = nums[0];
        } else {
            max[1] = nums[1];
            max[0] = nums[0];
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = nums[i];

            } else if (max[0] > nums[i] && nums[i] > nums[1]) {
                max[2] = max[1];
                max[1] = nums[i];
            } else if (max[1] > nums[i] && nums[i] > nums[2]) {
                nums[2] = nums[i];
            }
        }
        return max[2];
    }
}
