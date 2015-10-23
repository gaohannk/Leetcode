package leetcode;
/* Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame3 {
	public boolean canJump(int[] A) {
		if (A.length == 1)
			return true;
		if (A[0] >= (A.length - 1))
			return true;
		int maxlength = A[0];
		for (int i = 0; i < A.length - 1; i++) {
			if (maxlength >= i && (i + A[i]) >= A.length - 1)
				return true;
			if (maxlength <= i && A[i] == 0)
				return false;
			if ((i + A[i]) > maxlength)
				maxlength = i + A[i];
		}
		return false;
	}
}
