package leetcode;

/* Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
// Idea is to work backwards from the last index. Keep track of the smallest index that can "jump" to the last index.
// Check whether the current index can jump to this smallest index.
public class JumpGame3 {
    public boolean canJump(int[] A) {
        int n = A.length;
        int last = n - 1, i;
        for (i = n - 2; i >= 0; i--) {
            if (i + A[i] >= last) last = i;
        }
        return last <= 0;
    }
}
