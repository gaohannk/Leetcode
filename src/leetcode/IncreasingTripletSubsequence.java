package leetcode;

/* Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should:
 * Return true if there exists i, j, k 
 * such that list[i] < list[j] < list[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * Given [5, 4, 3, 2, 1],
 * return false.
 */
public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		if (nums.length < 3)
			return false;
		int smallest = Math.min(nums[0], nums[1]);
		int second = Math.max(nums[0], nums[1]);
		boolean flag = nums[0] > nums[1] ? false : true;
		for (int i = 2; i < nums.length; i++) {
			if (flag) {
				if (nums[i] > second)
					return true;
				else if (nums[i] > smallest)
					second = nums[i];
				else {
					smallest = nums[i];
				}
			} else {
				if (nums[i] > second) {
					second = nums[i];
					flag = true;
				} else if (nums[i] > smallest) {
					second = nums[i];
					flag = true;
				} else {
					second = smallest;
					smallest = nums[i];
				}
			}
		}
		return false;
	}
}
