package leetcode.algo.s;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] nums = new int[1690];
        nums[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < 1690; ++i) {
            ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = ugly;

            if (ugly == nums[i2] * 2) {
                i2++;
            }
            if (ugly == nums[i3] * 3) {
                i3++;
            }
            if (ugly == nums[i5] * 5) {
                i5++;
            }
        }
        return nums[n - 1];

    }
}
