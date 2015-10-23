package leetcode;

/* Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchforaRange {
	public int[] searchRange(int[] A, int target) {
		int mid = 0;
		int start = 0, end = A.length - 1;
		int[] index = { -1, -1 };
		boolean flag = true;
		while (start <= end) {
			mid = (start + end) >> 1;
			if (A[mid] == target) {
				flag = false;
				break;
			}
			if (A[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		if (flag)
			return index;
		int right = mid;
		while (right < A.length && A[right] == target)
			right++;
		int left = mid;
		while (left >= 0 && A[left] == target)
			left--;
		index[0] = left + 1;
		index[1] = right - 1;
		return index;
	}

}
