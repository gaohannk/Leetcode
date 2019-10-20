package leetcode.m;

import java.util.LinkedList;
import java.util.List;

/**
 * Boyer Majority Vote
 * Time O(n) Space O(1)
 */

public class MajorityElementII3 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return res;
        int candidate1 = nums[0], candidate2 = nums[0], count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                //drop old candidate
                candidate1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }
}
