package leetcode.algo.c;

public class CheckIfaNumberIsMajorityElementinaSortedArray2 {
    public boolean isMajorityElement(int[] nums, int target) {
        return nums[nums.length/2] == target && nums[nums.length/2-1] == target;
    }
}
