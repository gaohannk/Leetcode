package leetcode;
/* Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */
/* 思路：交换数组元素，使得数组中第i位存放数值(i+1)。最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。
 * 整个过程需要遍历两次数组，复杂度为O(n)。
 */
public class FirstMissingPositive2 {
	public int firstMissingPositive(int[] A) {
		int i = 0;
		while (i < A.length) {
			if (A[i] != (i + 1) && A[i] >= 1 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
				// 注意：交换的元素索引中包含交换的值
				int temp = A[i];
				A[i] = A[temp - 1];
				A[temp - 1] = temp;		
			}else
				i++;
		}
		for (i = 0; i < A.length; ++i)
			if (A[i] != (i + 1))
				return i + 1;
		return A.length + 1;
	}
}
