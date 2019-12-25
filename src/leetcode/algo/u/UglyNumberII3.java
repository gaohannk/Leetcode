package leetcode.algo.u;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/* Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumberII3 {
    public static int nthUglyNumber(int n) {
        int[] nums = new int[1690];
        nums[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < 1690; ++i) {
            ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = ugly;

            if (ugly == nums[i2] * 2)
                ++i2;
            if (ugly == nums[i3] * 3)
                ++i3;
            if (ugly == nums[i5] * 5)
                ++i5;
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
        //System.out.println(1076168025);
    }
}
