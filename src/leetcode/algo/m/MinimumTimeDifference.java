package leetcode.algo.m;

import java.util.Arrays;
import java.util.List;

/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int res = Integer.MAX_VALUE;
        int[] c = new int[timePoints.size()];

        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            c[i] = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
        }
        Arrays.sort(c);
        for (int i = 1; i < c.length; i++) {
            res = Math.min(res, c[i] - c[i - 1]);
        }
        res = Math.min(res, c[0] + (24 * 60 - c[c.length - 1]));
        return res;
    }
}
