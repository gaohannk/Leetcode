package leetcode.algo.p;

/*
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
// cumulative product O(1) space
public class ProductofArrayExceptSelf3 {
    public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i];
        }

        int rightProduct = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            res[i + 1] = res[i] * rightProduct;
            rightProduct *= nums[i + 1];
        }
        res[0] = rightProduct;
        return res;
    }
}
