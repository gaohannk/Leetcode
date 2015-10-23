package leetcode;
/* Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * The array may contain duplicates.
 */
public class FindMinimuminRotatedSortedArrayII {
	public int findMin(int[] num) {

		int min = findmin(num, 0, num.length - 1);
		return min;
	}

	public int findmin(int[] num, int left, int right) {
		int mid = (left + right) / 2;
		if (left == right)
			return num[left];
		if (num[left] <= num[mid] && num[right] < num[mid])
			return findmin(num, mid + 1, right);
		else if (num[mid] <= num[right] && num[left] > num[mid])
			return findmin(num, left, mid);
		return Math.min(findmin(num,left,mid),findmin(num,mid+1,right));
	}
}
