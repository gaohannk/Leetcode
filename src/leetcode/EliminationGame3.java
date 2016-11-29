package leetcode;

/**
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * <p>
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 * <p>
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * <p>
 * Find the last number that remains starting with a list of length n.
 * <p>
 * Example:
 * <p>
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * <p>
 * Output:
 * 6
 */
/*My idea is to update and record head in each turn. when the total number becomes 1, head is the only number left.

When will head be updated?

if we move from left
if we move from right and the total remaining number % 2 == 1
like 2 4 6 8 10, we move from 10, we will take out 10, 6 and 2, head is deleted and move to 4
like 2 4 6 8 10 12, we move from 12, we will take out 12, 8, 4, head is still remaining 2
then we find a rule to update our head.
 */

public class EliminationGame3 {
    public int lastRemaining(int n) {
        return helper(1, n, 1, true);
    }
    // start is the current first number
// num is count of remaining numbers
// step is the interval between two next-to-each-other numbers
// isFromLeft is from left or from right
    private int helper(int start, int num, int step, boolean isFromLeft) {
        if (num == 1) {
            return start;
        } else {
            //if isFromLeft, new start is the second number
            //if isFromRight, new start is the first number if count is even
            //                new start is the second number if count is odd
            int newStart = (isFromLeft || num % 2 == 1) ? (start + step) : start;
            return helper(newStart, num / 2, step * 2, !isFromLeft);
        }
    }
}
