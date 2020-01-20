package company.oracle.high;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        Stack<Integer> index = new Stack<>();
        index.push(0);
        int res[] = new int[nums.length];
        Arrays.fill(res, -1);

        for (int i = 1; i < 2 * nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i % nums.length]) {
                stack.pop();
                res[index.pop() % nums.length] = nums[i % nums.length];
            }
            stack.push(nums[i % nums.length]);
            index.push(i);
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
