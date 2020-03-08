package leetcode.algo.h;

import java.util.Arrays;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 * Example 2:
 *
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 * Example 3:
 *
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class HowManyNumbersAreSmallerThantheCurrentNumber2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        Pair[] pairs = new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs);
        int count = 0;
        res[pairs[0].idx] = count;
        for (int i = 1; i < nums.length; i++) {
            // same value, not increase count
            if(pairs[i].val == pairs[i-1].val){
                res[pairs[i].idx] =  count ;
            }else{
                count = i;
                res[pairs[i].idx] =  count ;
            }
        }
        return res;
    }
    class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int num, int idx) {
            this.val = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
}
