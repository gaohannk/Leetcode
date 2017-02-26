package leetcode;
/* Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
/* 优化解法，只需要顺序扫描数组，记录下能够到达的最远位置
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		int farest = 0;
		for (int i = 0; i <= farest; i++) {
			if (A[i] + i > farest)
				farest = A[i] + i;
			if (farest >= A.length - 1)
				return true;
		}
		return false;
	}
}