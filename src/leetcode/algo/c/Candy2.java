package leetcode.algo.c;

/* There are N children standing in a line. Each child is assigned a rating
 * You are giving candies to these children subjected to the following
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */

// Space: O(1)
// Time: O(n)
// One pass
public class Candy2 {
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int res = 1;
        int up = 1, down = 0, peak = up;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                up++;
                peak = up;
                down = 0;
                res += up;
            } else if (ratings[i] < ratings[i - 1]) {
                down++;
                // down + 1, "lazy update" the peak element gap
                // 1,2,3,4/7,6,5,4,3,2,1 7 and 4 has gap 3, we should add 7 instead of 4
                res += down < peak ? down : down + 1;
                up = 1;
            } else {
                res++;
                up = 1;
                down = 0;
                peak = up;
            }
        }
        return res;
    }
}
