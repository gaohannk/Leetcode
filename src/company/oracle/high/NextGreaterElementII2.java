package company.oracle.high;

import java.util.Stack;

public class NextGreaterElementII2 {
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
