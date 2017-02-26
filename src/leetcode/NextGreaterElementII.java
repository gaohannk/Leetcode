package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

 Example 1:
 Input: [1,2,1]
 Output: [2,-1,2]
 Explanation: The first 1's next greater number is 2;
 The number 2 can't find next greater number;
 The second 1's next greater number needs to search circularly, which is also 2.
 Note: The length of given array won't exceed 10000.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] nextGreat = new int[nums.length];
        Arrays.fill(nextGreat,-1);
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 1; i < 2*nums.length; i++) {
            if (nums[i%nums.length] > nums[(i - 1)% nums.length]) {
                nextGreat[(i - 1)% nums.length] = nums[i% nums.length];
                while (!stack.isEmpty()) {
                    if (stack.peek() < nums[i% nums.length]) {
                        stack.pop();
                        nextGreat[stack2.pop()] = nums[i% nums.length];
                    } else
                        break;
                }
            } else {
                stack.push(nums[(i - 1)% nums.length]);
                stack2.push((i - 1)% nums.length);
            }
        }
        return nextGreat;
    }
}
