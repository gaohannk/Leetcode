package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * <p>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [2,3]
 */
//O(n)
public class FindAllDuplicatesinanArray2 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new LinkedList<Integer>();
        // If a number has been seen we will set its corresponding index to its negative
        // If it is already negative then we have seen it before
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val-1] < 0)
                duplicates.add(val);
            else
                // We are setting the value at this index to be negative to imply we've seen the index itself in the array already
                nums[val-1] = -1 * nums[val-1];
        }
        return duplicates;
    }
}
