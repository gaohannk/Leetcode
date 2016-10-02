package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
If there are multiple solutions, return any subset is fine.
Example 1:
nums: [1,2,3]
Result: [1,2] (of course, [1,3] will also be ok)
Example 2:
nums: [1,2,4,8]
Result: [1,2,4,8]
*/
// len[i] store the number of largest subset ending with i
// index[i] trace the last element index for constructing the list result

public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		LinkedList<Integer> res = new LinkedList<>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		int index[] = new int[nums.length];
		int len[] = new int[nums.length];
		Arrays.fill(len, 1);
		Arrays.fill(index, -1);
		for (int i = 1; i < nums.length; i++) {
			int maxlen = 0;
			int id = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					if (len[j] > maxlen) {
						id = j;
						maxlen = len[j];
					}
				}
			}
			len[i] = maxlen + 1;
			index[i] = id;
		}
		int max = 0;
		int point = 0;
		for (int i = 1; i < nums.length; i++) {
			if (len[i] > max) {
				max = len[i];
				point = i;
			}
		}
		while (point != -1) {
			res.add(0, nums[point]);
			point = index[point];
		}
		return res;
	}
}
