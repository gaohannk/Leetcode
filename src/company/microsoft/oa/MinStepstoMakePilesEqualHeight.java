package company.microsoft.oa;

import java.util.Arrays;

/**
 * Alexa is given n piles of equal or unequal heights. In one step, Alexa can remove any number of boxes from the pile which has the maximum height and try to make it equal to the one which is just lower than the maximum height of the stack. Determine the minimum number of steps required to make all of the piles equal in height.
 *
 * Example 1:
 *
 * Input: piles = [5, 2, 1]
 * Output: 3
 * Explanation:
 * Step 1: reducing 5 -> 2 [2, 2, 1]
 * Step 2: reducing 2 -> 1 [2, 1, 1]
 * Step 3: reducing 2 -> 1 [1, 1, 1]
 * So final number of steps required is 3.
 */
public class MinStepstoMakePilesEqualHeight {
    public int minSteps(int[] piles) {
        Arrays.sort(piles);
        int count = 0;
        int n = piles.length;
        for (int i = 1; i < n; i++) {
            if (piles[n - i - 1] != piles[n - i]) {
                count += i;
            }
        }
        return count;
    }
}
