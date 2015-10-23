package leetcode;

/* Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example:
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;

		int pre = A[0];
		boolean flag = false;
		// index for updating
		int count = 1;
		for (int i = 1; i < A.length; i++) {
			int curr = A[i];
			if (curr == pre) {
				if (!flag) {
					flag = true;
					A[count++] = curr;
					continue;
				}
			} else {
				pre = curr;
				A[count++] = curr;
				flag = false;
			}
		}
		return count;
	}
}
