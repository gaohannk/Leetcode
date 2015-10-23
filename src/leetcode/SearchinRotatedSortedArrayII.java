package leetcode;

/* Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */
public class SearchinRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		int start = 0, end = A.length - 1;
		while (start <= end) {
			if (start > end)
				return false;
			int mid = (start + end) >> 1;
			if (A[mid] == target)
				return true;
			if (A[mid] > A[start]) {
				if (A[start] <= target && target < A[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else if (A[mid] < A[start]) {
				if (A[mid] < target && target <= A[end])
					start = mid + 1;
				else
					end = mid - 1;
			} else if (A[mid] == A[start]) {
				start++;
			}
		}
		return false;
	}
}
