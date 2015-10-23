package leetcode;

import java.util.Arrays;

/* Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */
/* 排序之后查找。跳过非正整数部分和重复部分
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		Arrays.sort(A);
		int count = 1;
		if (A.length == 0)
			return 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= 0)
				continue;
			if (i > 0 && A[i] == A[i - 1])
				continue;
			if (A[i] != count)
				break;
			else
				count++;
		}
		return count;
	}
}
