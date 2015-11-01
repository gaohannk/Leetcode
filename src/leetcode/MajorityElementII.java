package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
 * The algorithm should run in linear time and in O(1) space.
 * Hint:
 * How many majority elements could it possibly have?
 */
public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else
				map.put(nums[i], map.get(nums[i]) + 1);
		}
		for(Integer i:map.keySet()){
			if(map.get(i)>nums.length/3)
				list.add(i);
		}
		return list;
	}
}
