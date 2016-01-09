package leetcode;

/* Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
/* i is odd，nums[i] >= nums[i - 1]
 * i is even，nums[i] <= nums[i - 1]
 * We exchange if not statify. If nums[i] > nums[i - 1]， then exchange nums[i] <= nums[i - 1]。
 * Time O(n)
 * Space O(1)
 */
public class WiggleSort {
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length <= 0)
			return;
		for (int i = 1; i < nums.length; i++) {
			if (i % 2 == 1) {
				if (nums[i - 1] > nums[i])
					swap(nums, i, i - 1);
			} else {
				if (nums[i] > nums[i - 1])
					swap(nums, i, i - 1);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
