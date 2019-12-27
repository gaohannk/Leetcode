package leetcode.algo.c;

public class CheckIfaNumberIsMajorityElementinaSortedArray {
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;

        for (int i : nums) {
            if (i == target) {
                count++;
                if (count > nums.length / 2) {
                    //is majority
                    return true;
                }
            }
        }
        return false;
    }
}
