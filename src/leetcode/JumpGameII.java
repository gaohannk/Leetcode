package leetcode;
/* Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, 
 * then 3 steps to the last index.)
 */
/* DP: let F(i) denote the minimum number of jumps, then we have F(i) = min(F(j) ) + 1 where j = 0, … i – 1, 
 * this is O(N^2) approach and will get TLE by the OJ
 */
public class JumpGameII {
	public static int jump(int[] A) {
		if (A.length < 2)
			return 0;
		int[] dist = new int[A.length];
		dist[A.length - 1] = 0;
		for (int i = A.length - 2; i >= 0; i--) {
			int minDist = A.length-1;
			for (int j = 1; j <= A[i] && i + j < A.length; j++) {
				int nextIdx = i + j;
				int candidate = dist[nextIdx] + 1;
				if (candidate < minDist) {
					minDist = candidate;
				}
			}
			dist[i] = minDist;
		}
		return dist[0];
	}
}
