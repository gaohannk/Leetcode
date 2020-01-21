package leetcode.algo.p;

/*
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
// cumulative product 0(n) space
public class ProductofArrayExceptSelf2 {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        leftProduct[0] = nums[0];
        rightProduct[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i];
        }
        int res[] = new int[nums.length];
        res[0] = rightProduct[1];
        res[nums.length - 1] = leftProduct[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = leftProduct[i - 1] * rightProduct[i + 1];
        }
        return res;
    }
}
