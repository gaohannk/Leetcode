package leetcode;
/* Given an array of integers, find two numbers such that they add up to a specific target 
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

import java.util.Arrays;

public class TwoSum2 {
	class pairs implements Comparable<pairs> {
		int number;
		int index;

		pairs(int number, int index) {
			this.number = number;
			this.index = index;
		}

		public int compareTo(pairs p2) {
			return this.number - p2.number;
		}

	}
	public int[] twoSum(int[] numbers, int target) {
		int index = 0;
		int index2 = numbers.length - 1;
		int[] result = new int[2];
		pairs[] pair = new pairs[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			pair[i] = new pairs(numbers[i], i + 1);
		}
		Arrays.sort(pair);
		while (index < index2) {
			if ((pair[index].number + pair[index2].number) < target) {
				index++;
			} else {
				if (pair[index].number + pair[index2].number > target) {
					index--;
				} else {
					if (pair[index].index < pair[index].index) {
						result[0] = pair[index].index;
						result[1] = pair[index2].index;
					} else {
						result[1] = pair[index].index;
						result[0] = pair[index2].index;
					}
				}

			}
		}
		return result;
	}
}
