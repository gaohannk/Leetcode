package leetcode;

import java.util.Arrays;
import java.util.Random;

/*Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

*/
public class ShuffleanArray {
	public class Solution {
		private int[] nums = null;
		private Random random = null;

		public Solution(int[] nums) {
			this.nums = nums;
			random = new Random(System.currentTimeMillis());
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			return Arrays.copyOf(nums, nums.length); // just return a copy.
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			int[] ans = Arrays.copyOf(nums, nums.length); // create a copy
			for (int i = 1; i < nums.length; i++) {
				// generate a random number within visited elements including
				// current index.
				swap(ans, i, random.nextInt(i + 1)); // swap the index
			}
			return ans;
		}

		private void swap(int[] array, int i, int j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	/**
	 * Your Solution object will be instantiated and called as such: Solution
	 * obj = new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
	 * obj.shuffle();
	 */
}
