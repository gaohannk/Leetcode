package leetcode;

/* Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */

/**
 * 用maxCover记录最大可到达距离，step记录仍然可走的步数，遍历数组更新这两个值，若step=0且没有走到数组尾部，则返回false；若遍历完成则返回true
 */
public class JumpGame2 {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return false;

        int maxCover = 0, step = 1;
        for (int i = 0; i < nums.length; i++) {
            step--;
            if (i + nums[i] > maxCover) {
                maxCover = i + nums[i];
                step = nums[i];
            }
            if (step == 0 && i < nums.length - 1)
                return false;
        }
        return true;
    }
}
