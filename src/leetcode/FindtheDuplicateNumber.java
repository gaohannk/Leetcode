package leetcode;

/* Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
/* 我们在区间[1, n]中搜索，首先求出中点mid，然后遍历整个数组，统计所有小于等于mid的数的个数，如果个数大于mid，则说明重复值在[mid+1, n]之间，
 * 反之，重复值应在[1, mid-1]之间，然后依次类推，知道搜索完成，此时的low就是我们要求的重复值，
 * O(nlogn)
 */
public class FindtheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			int count = getCount(nums, mid);
			if (count <= mid)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}

	public int getCount(int[] nums, int mid) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= mid)
				count++;
		}
		return count;
	}
}
