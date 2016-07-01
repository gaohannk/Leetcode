package leetcode;

/* Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
 * The returned array must be in sorted order.
Expected time complexity: O(n)
Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
Result: [3, 9, 15, 33]
nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
Result: [-23, -5, 1, 7]
:
*/
public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		double mid = -(double) b / 2.0 / a;
		int i = 0, j = nums.length - 1;
		int res[] = new int[nums.length];
		int index = a >= 0 ? nums.length - 1 : 0;
		while (i < j) {
			if (Math.abs(nums[i] - mid) > Math.abs(mid - nums[j])) {
				res[index] = a * nums[i] * nums[i] + b * nums[i] + c;
				i++;
			} else {
				res[index] = a * nums[j] * nums[j] + b * nums[j] + c;
				j--;
			}
			index = a >= 0 ? index - 1 : index + 1;
		}
		return res;
	}
}
