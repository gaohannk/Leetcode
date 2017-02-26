package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 */

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if(findNums.length==0)
            return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] nextGreat = new int[nums.length];
        int res[] = new int[findNums.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                nextGreat[i - 1] = nums[i];
                while (!stack.isEmpty()) {
                    if (stack.peek() < nums[i]) {
                        stack.pop();
                        nextGreat[stack2.pop()] = nums[i];
                    }
                    else
                        break;
                }
            } else {
                stack.push(nums[i - 1]);
                stack2.push(i - 1);
            }
        }
        while (!stack.isEmpty()) {
                stack.pop();
                nextGreat[stack2.pop()] = -1;
        }
        nextGreat[nums.length - 1] = -1;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nextGreat[i]);
        }

        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }
}
