package leetcode.algo.r;

import java.util.Arrays;

/* Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
// Space O(1)
// Time O(n)
public class RotateArray4 {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int count = 0;
        int p = 0;
        int temp = nums[p];
        while (count < len) {
            int temp2 = nums[(p + k) % len];
			// use large index to override small index
			nums[(p + k) % len] = temp;
			// we need two temp to switch
            temp = temp2;
            p = (p + k) % len;
            count++;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int count = 0;
        int p = 0;
        int temp = nums[p];
        while (count < len) {
        	// avoid negative index
            int id = (p - k) % len < 0 ? (p - k) % len + len : (p - k) % len;
            // use small index to override large index
            nums[p] = nums[id];
            p = (p - k) % len < 0 ? (p - k) % len + len : (p - k) % len;
            count++;
        }
        p = p + k;
        nums[p] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
