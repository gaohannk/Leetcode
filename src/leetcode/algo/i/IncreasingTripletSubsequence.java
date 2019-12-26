package leetcode.algo.i;

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
	public static boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3)
			return false;

		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;

		for (int num : nums) {
			if (num <= first) {
				first = num;
			} else if (num <= second) {
				second = num;
			} else {  //Think of first<second<num
				return true;
			}

		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = {5, 3, 7};
		System.out.println(increasingTriplet(nums));
	}
}
