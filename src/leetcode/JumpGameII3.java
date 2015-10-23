package leetcode;

/* 1 The key point of solving the problem by greedy approach is that we should keep the current
 * maximum reachable distance, the next maximum reachable distance and also the steps needed to do it.
 * 2 when the index exceed the current maximum reachable distance, then we need to update it by 
 * the next maximum reachable distance and increase the steps by steps++, because when the index 
 * exceed the current maximum reachable distance, it means that we are stuck in current maximum 
 * reachable distance, we need to jump to increase the next maximum distance.
*/
public class JumpGameII3 {
	public static int jump(int[] A) {
		if (A == null || A.length == 0 || A.length == 1)
			return 0;
		int ret = 0;
		int last = 0;
		int curr = 0;
		for (int i = 0; i < A.length; ++i) {
			if (i > last) {
				last = curr;
				++ret;
			}
			curr = Math.max(curr, i + A[i]);
		}
		return ret;
	}
}
