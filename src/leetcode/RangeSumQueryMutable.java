package leetcode;

/* Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
*/
//TLE
public class RangeSumQueryMutable {

	public static class NumArray {
		public int[] sum;

		public NumArray(int[] nums) {
			sum = new int[nums.length];
			if (nums.length > 0) {
				sum[0] = nums[0];
				for (int i = 1; i < nums.length; i++) {
					sum[i] = sum[i - 1] + nums[i];
				}
			}
		}

		void update(int i, int val) {
			int valofi;
			if (i > 0)
				valofi = sum[i] - sum[i - 1];
			else
				valofi = sum[i];
			for (int index = i; index < sum.length; index++) {
				sum[index] += val - valofi;
			}
		}

		public int sumRange(int i, int j) {
			if (i != 0)
				return sum[j] - sum[i - 1];
			else
				return sum[j];
		}
	}

	public static void main(String[] args) {
		// Your NumArray object will be instantiated and called as such:
		int nums[] = { 1, 3, 5 };
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 1));
		numArray.update(1, 10);
		System.out.println(numArray.sumRange(1, 2));
	}
}
