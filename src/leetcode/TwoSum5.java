package leetcode;

import java.util.Arrays;
/* Given an array of integers, find two numbers such that they add up to a specific target 
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum5 {
	public int[] twoSum(int[] numbers, int target) {
		// Copy the original array and sort it
		int N = numbers.length;
		int[] sorted = new int[N];
		System.arraycopy(numbers, 0, sorted, 0, N);
		Arrays.sort(sorted);
		// find the two numbers using the sorted arrays
		int first = 0;
		int second = sorted.length - 1;
		while (first < second) {
			if (sorted[first] + sorted[second] < target) {
				first++;
				continue;
			} else if (sorted[first] + sorted[second] > target) {
				second--;
				continue;
			} else
				break;
		}
		int number1 = sorted[first];
		int number2 = sorted[second];
		// Find the two indexes in the original array
		int index1 = -1, index2 = -1;
		for (int i = 0; i < N; i++) {
			if ((numbers[i] == number1) || (numbers[i] == number2)) {
				if (index1 == -1)
					index1 = i + 1;
				else
					index2 = i + 1;
			}

		}
		int[] result = new int[] { index1, index2 };
		return result;
	}
}
