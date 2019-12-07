package leetcode.algo.l;

public class LongestContinuousIncreasingSubsequence2 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = 1, temp = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                temp++;
            } else {
                length = Math.max(length, temp);
                temp = 1;
            }
        }
        length = Math.max(length, temp);
        return length;
    }
}
