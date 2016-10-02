package leetcode;

import java.util.LinkedList;
import java.util.Random;

/*Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);

*/
public class RandomPickIndex {
	public static class Solution {
		LinkedList<Integer> index;
		int[] nums;
		Random rand = null;

		public Solution(int[] nums) {
			this.nums = nums;
			this.index = new LinkedList<>();
			this.rand = new Random();
		}

		public int pick(int target) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == target)
					index.add(i);
			}
			//return index.get((int) (Math.random() * index.size()));
			return index.get(rand.nextInt(index.size()));
		}
	}

	public static void main(String[] args) {
		int nums[] = { 1,2,3,3,3 };
		Solution solution = new RandomPickIndex.Solution(nums);
		System.out.println(solution.pick(3));
	}
}
