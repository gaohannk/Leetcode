package leetcode;

/*
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductofArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int product = 1;
		int res[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int index = i;
				product = 1;
				for (int j = 0; j < nums.length; j++) {
					if (j != i)
						product *= nums[j];
				}
				res[i] = product;
				return res;
			}
			product *= nums[i];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] != 0) {
				res[i] = product / nums[i];
			}
		}
		return res;
	}
}
