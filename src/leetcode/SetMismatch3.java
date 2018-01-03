package leetcode;

/**
 * Because numbers are from 1 to n, after we put number i to index i - 1 there's only 1 mis-matching which is the answer. Time complexity O(n). Space complexity O(1).
 */
public class SetMismatch3 {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                result[0] = nums[i];
                result[1] = i + 1;
                break;
            }
        }

        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
