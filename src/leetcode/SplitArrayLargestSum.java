package leetcode;

/**
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * <p>
 * Note:
 * Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤ 14,000.
 * <p>
 * Examples:
 * <p>
 * Input:
 * nums = [1,2,3,4,5]
 * m = 2
 * <p>
 * Output:
 * 9
 * <p>
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [1,2,3] and [4,5],
 * where the largest sum among the two subarrays is only 9.
 */

/**
 * The answer is between maximum value of input array numbers and sum of those numbers.
 * Use binary search to approach the correct answer. We have l = max number of array; r = sum of all numbers in the array;Every time we do mid = (l + r) / 2;
 * Use greedy to narrow down left and right boundaries in binary search.
 * 3.1 Cut the array from left.
 * 3.2 Try our best to make sure that the sum of numbers between each two cuts (inclusive) is large enough but still less than mid.
 * 3.3 We'll end up with two results: either we can divide the array into more than m subarrays or we cannot.
 * If we can, it means that the mid value we pick is too small because we've already tried our best to make sure each part holds as many non-negative numbers as we can but we still have numbers left. So, it is impossible to cut the array into m parts and make sure each parts is no larger than mid. We should increase m. This leads to mid = l + 1;
 * If we can't, it is either we successfully divide the array into m parts and the sum of each part is less than mid, or we used up all numbers before we reach m. Both of them mean that we should lower mid because we need to find the minimum one. This leads to r = mid - 1;
 */
public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int) sum;
        //binary search
        long l = max;
        long r = sum;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    public static boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total > target) {
                total = nums[i];
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int m = 2;
        System.out.println(splitArray(nums, m));
    }
}
