package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MajorityElementII2 {
	public List<Integer> majorityElement(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			if (!set.contains(nums[i])) {
				for (int j = 0; j < nums.length; j++) {
					if (nums[j] == nums[i])
						count++;
				}
				if (count > nums.length / 3) {
					list.add(nums[i]);
					set.add(nums[i]);
					count = 0;
				}
			}
		}
		return list;
	}
}
