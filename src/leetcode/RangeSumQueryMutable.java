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
		int[] prefixSum;

		void update(int i, int val) {
			int valofi;
			valofi = prefixSum[i + 1] - prefixSum[i];
			for (int index = i; index < prefixSum.length-1; index++) {
				prefixSum[index+1] += val - valofi;
			}
		}

		public NumArray(int[] nums) {
			int len = nums.length;
			prefixSum = new int[len + 1];
			prefixSum[0] = 0;
			for (int i = 0; i < len; i++) {
				prefixSum[i + 1] = prefixSum[i] + nums[i];
			}
		}

		public int sumRange(int i, int j) {
			return prefixSum[j + 1] - prefixSum[i];
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
