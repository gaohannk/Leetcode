package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
 * <p>
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.
 * <p>
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 * Example 1:
 * Input: [ [1,2] ]
 * <p>
 * Output: [-1]
 * <p>
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * Example 2:
 * Input: [ [3,4], [2,3], [1,2] ]
 * <p>
 * Output: [-1, 0, 1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 * Example 3:
 * Input: [ [1,4], [2,3], [3,4] ]
 * <p>
 * Output: [-1, 2, -1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 */
public class FindRightInterval2 {
    public static int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        // map records the index for each start point
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }

        //sort according to start point
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));

        //binary search to insert current end point to larger sorted start points
        for (int i = 0; i < intervals.length; i++) {
            int target = intervals[i].end;
            int left = i + 1, right = intervals.length;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (intervals[mid].start < target) left = mid + 1;
                else right = mid;
            }
            result[map.get(intervals[i].start)] = (right == intervals.length) ? -1 : map.get(intervals[right].start);
        }
        return result;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(3, 4), i2 = new Interval(2, 3), i3 = new Interval(1, 2);
        Arrays.stream(findRightInterval(new Interval[]{i1, i2, i3})).forEach(p -> System.out.println(p));
    }
}
