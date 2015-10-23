package leetcode;

/* Similar to Question [1. Two Sum], except that the input array is already sorted in
 * ascending order.
 */
public class TwoSumII {
	public int[] twoSum(int[] numbers, int target) {
		// Assume input is already sorted.
		for (int i = 0; i < numbers.length; i++) {
			int j = bsearch(numbers, target - numbers[i], i + 1);
			if (j != -1) {
				return new int[] { i + 1, j + 1 };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	private int bsearch(int[] A, int key, int start) {
		int L = start, R = A.length - 1;
		while (L < R) {
			int M = (L + R) / 2;
			if (A[M] < key) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return (L == R && A[L] == key) ? L : -1;
	}
}
