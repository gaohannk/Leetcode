package leetcode.s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A Stepping Number is an integer such that all of its adjacent digits have an absolute difference of exactly 1. For example, 321 is a Stepping Number while 421 is not.
 * <p>
 * Given two integers low and high, find and return a sorted list of all the Stepping Numbers in the range [low, high] inclusive.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: low = 0, high = 21
 * Output: [0,1,2,3,4,5,6,7,8,9,10,12,21]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= low <= high <= 2 * 10^9
 */
public class SteppingNumbers2 {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList();

        for (long i = 0; i <= 9; i++) {
            dfs(low, high, i, res);
        }
        Collections.sort(res);
        return res;
    }

    private void dfs(int low, int high, long cur, List<Integer> list) {
        if (cur >= low && cur <= high)
            list.add((int) cur);
        if (cur == 0 || cur > high)
            return;

        long last = cur % 10;
        long inc = cur * 10 + last + 1;
        long dec = cur * 10 + last - 1;

        if (last == 0)
            dfs(low, high, inc, list);
        else if (last == 9)
            dfs(low, high, dec, list);
        else {
            dfs(low, high, inc, list);
            dfs(low, high, dec, list);
        }
    }
}
