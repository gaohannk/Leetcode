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
// Two pass one array
public class Candy3 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int c : candies) {
            sum += c;
        }
        return sum;
    }
}
