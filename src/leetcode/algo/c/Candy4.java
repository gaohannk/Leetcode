package leetcode.algo.c;

import java.util.Arrays;

/* There are N children standing in a line. Each child is assigned a rating
 * You are giving candies to these children subjected to the following
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
// Space: O(n)
// Time: O(n)
// Two pass two arrays
public class Candy4 {
    public int candy(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }
}
