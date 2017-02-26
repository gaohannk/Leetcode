package leetcode;

/* Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, 
 * then 3 steps to the last index.)
 */
/* 基本思路就是求出每个范围内可以跳到的范围，新的范围不与上个范围重叠。开始的范围是[0,0];
 * [0,0]->[1,2] -> [3,4]
 * [2] -> [3,1] -> [1,4]
 * 虽然用到了2次循环，但只遍历一次数组中的元素，所以时间复杂度为：O(n)
 */
public class JumpGameII2 {
    public int jump(int[] A) {
        if (A == null || A.length == 0 || A.length == 1)
            return 0;
        int start = 0, end = 0;
        int jump_times = 0, max = 0;
        while (end < A.length) {
            max = 0;
            jump_times++;
            for (int i = start; i <= end; i++) {
                //arrive end
                if ((A[i] + i) >= (A.length - 1))
                    return jump_times;
                if ((A[i] + i) > max)
                    max = A[i] + i;
            }
            start = end + 1;
            end = max;
        }
        return jump_times;
    }
}
