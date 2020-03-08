package leetcode.algo.g;

/**
 * Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
 *
 * On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
 *
 * The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
 *
 * Return the maximum number of customers that can be satisfied throughout the day.
 *
 *
 *
 * Example 1:
 *
 * Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * Output: 16
 * Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
 * The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 */
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfy = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                satisfy += customers[i]; // directly sum the satisfy customers
            }
        }
        return satisfy + getMax(customers, grumpy, X);
    }

    public int getMax(int[] customers, int[] grumpy, int X) { // X is window size
        int max = 0;
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            sum += grumpy[i] * customers[i];
            if (i >= X) {
                sum -= grumpy[i - X] * customers[i - X];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
