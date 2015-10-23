package leetcode;
/* Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
/* brute force
 * 
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		boolean[] canArrive = new boolean[A.length];
		canArrive[0] = true;
		for (int i = 0; i < A.length; i++) {
			if (canArrive[i] == false)
				continue;
			int farest = Math.min(i + A[i], A.length - 1);
			for (int j = i + 1; j <= farest; j++)
				canArrive[j] = true;
			if (canArrive[A.length - 1])
				return true;
		}
		return false;
	}
}
