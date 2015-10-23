package leetcode;

/* Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		int mid = 0;
		int start = 0, end = A.length - 1;
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
			if (A[mid] > target)
				return mid;
			else
				return mid + 1;
		return mid;
	}
}
