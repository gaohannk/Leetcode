package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/* Given an array of integers, find two numbers such that they add up to a specific target 
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum4 {
	public int[] twoSum(int[] numbers, int target) {
		int length = numbers.length;
		int[] output = { -1, -1 };
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < length; i++) {
			if (!hm.containsKey(numbers[i])) {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(i + 1);
				hm.put(numbers[i], al);
			} else {
				int key = numbers[i];
				hm.get(key).add(i + 1);
			}
		}
		for (int key : hm.keySet()) {
			ArrayList<Integer> al = hm.get(key);
			int num1 = al.get(0);

			if (hm.containsKey(target - key)) {
				al.remove(0);
				output[0] = num1;
				output[1] = hm.get(target - key).get(0);
				Arrays.sort(output);
				return output;
			}
		}
		return output;
	}
}
