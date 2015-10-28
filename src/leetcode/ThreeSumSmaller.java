package leetcode;

import java.util.Arrays;

/* Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * Return 2. Because there are two triplets which sums are less than 2:
 * [-2, 0, 1]
 * [-2, 0, 3]
 * Follow up:
 * Could you solve it in O(n^2) runtime?
 */
public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length < 3)
			return 0;
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum3=nums[i] + nums[j] + nums[k];
				if ( sum3< target) {
					res += k - j;
					j++;
				} else {
					while (j < k && sum3>=target){
						k--;
						sum3=nums[i] + nums[j] + nums[k];
					}
				}
			}
		}
		return res;
	}
}
