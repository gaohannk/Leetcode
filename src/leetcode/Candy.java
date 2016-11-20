package leetcode;

/* There are N children standing in a line. Each child is assigned a rating 
 * You are giving candies to these children subjected to the following 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy {
    public int candy(int[] ratings) {
        int left = 1;
        int right = 1;
        int sum = 0;
        int leftstart = 0;
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] < ratings[i]) {
                left = i + 1 - leftstart;
                for (int j = i; j < ratings.length - 1; j++) {
                    if (ratings[j + 1] > ratings[j]) {
                        right = j - i + 1;
                        leftstart = j;
                        break;
                    }
                }
                sum += getSum(1, Math.min(left, right)) - 1;
                sum += getSum(1, Math.max(left, right));
                sum--;
                i = leftstart;
            }
        }
        sum++;
        return sum;
    }

    private int getSum(int i, int j) {
        return (j + i) * (j - i + 1) / 2;
    }
}
