package company.offerup;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TwoSumGreaterThanTargetII {
    public static int twoSum2(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] <= target) {
                i++;
            } else {
                count += j - i;
                j--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 5, 7, 8, 10, 13, 14, 16};
        int target = 14;
        int res = twoSum2(array, target);

        System.out.println(res);

    }
}
