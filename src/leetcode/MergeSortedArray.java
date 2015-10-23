package leetcode;
/* Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int i = m + n - 1;
		int j = m - 1;
		int k = n - 1;
		if (m == 0)
			while (k >= 0) {
				A[k] = B[k];
				k--;
			}
		while (j >= 0 && k >= 0) {
			if (A[j] > B[k])
				A[i--] = A[j--];
			else
				A[i--] = B[k--];
		}
		while (k >= 0) {
			A[i--] = B[k--];
		}
	}
}
