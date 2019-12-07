package leetcode.algo.r;

import java.util.Random;

/**
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
 * <p>
 * Note:
 * <p>
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 * <p>
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 * <p>
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * Explanation of Input Syntax:
 * <p>
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class RandomPickwithWeight {
    class Solution {
        int[] preSum;
        Random rand;
        int total;

        public Solution(int[] w) {
            preSum = new int[w.length];
            int sum = 0;
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                preSum[i] = sum;
            }
            this.total = sum;
            this.rand = new Random();
        }

        public int pickIndex() {
            int idx = rand.nextInt(total);
            for (int i = 0; i < preSum.length; i++) {
                if (preSum[i] > idx) {
                    return i;
                }
            }
            return preSum.length;
        }
    }
}
