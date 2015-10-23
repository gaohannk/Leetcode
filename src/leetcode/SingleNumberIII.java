package leetcode;

import java.util.HashSet;
import java.util.Iterator;

/* Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/
public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i]))
				set.add(nums[i]);
			else {
				set.remove(nums[i]);
			}
		}
		Iterator<Integer> it = set.iterator();
		res[0] = it.next();
		res[1] = it.next();
		return res;
	}
}
