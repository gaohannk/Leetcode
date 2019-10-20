package leetcode.m;

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
public class MinimumTimeDifference2 {
    public int findMinDifference(List<String> timePoints) {
        boolean[] times = new boolean[1440];
        for (String timeStr : timePoints) {
            int hours = Integer.valueOf(timeStr.substring(0, 2));
            int minutes = Integer.valueOf(timeStr.substring(3, 5));
            int mins = hours * 60 + minutes;
            if (times[mins]) {
                return 0;
            } else {
                times[mins] = true;
            }
        }
        int diff = Integer.MAX_VALUE, prev = -1, min = 1440, max = -1;
        for (int i = 0; i < 1440; i++) {
            if (times[i]) {
                if (prev == -1) {
                    prev = i;
                } else {
                    diff = Math.min(diff, i - prev);
                    prev = i;
                }
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        return Math.min(diff, Math.min(max - min, 1440 - (max - min)));
    }
}
