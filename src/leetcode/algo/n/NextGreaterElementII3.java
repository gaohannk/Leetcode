package leetcode.algo.n;

import java.util.Stack;

/**
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 *
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 */

// O(n^2)
public class NextGreaterElementII3 {
    public static int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        Stack<Integer> index = new Stack<>();
        index.push(0);
        int res[] = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                stack.pop();
                res[index.pop()] = nums[i];
            }
            stack.push(nums[i]);
            index.push(i);
        }
        while (stack.size() > 1) {
            int val = stack.peek();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > val) {
                    stack.pop();
                    res[index.pop()] = nums[i];
                    break;
                }
            }
        }
        while (!index.isEmpty()) {
            res[index.pop()] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {1, 2, 3, 5, 2, 0};

        int[] res = nextGreaterElements(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
