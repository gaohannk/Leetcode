package leetcode.algo.m;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//Time O(n) Space O(n)
public class MajorityElementII2 {
    public List<Integer> majorityElement(int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if (!res.contains(nums[i])) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == nums[i])
                        count++;
                }
                if (count > nums.length / 3) {
                    list.add(nums[i]);
                    res.add(nums[i]);
                    count = 0;
                }
            }
        }
        return list;
    }
}
