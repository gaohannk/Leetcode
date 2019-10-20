package leetcode.f;

import leetcode.i.Interval;

import java.util.Arrays;

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
public class FindRightInterval {
    static class Pair {
        Interval interval;
        int index;

        public Pair(Interval interval, int i) {
            this.interval = interval;
            this.index = i;
        }
    }

    public static int[] findRightInterval(Interval[] intervals) {
        int res[] = new int[intervals.length];
        Arrays.fill(res, -1);
        Pair[] intervalWithIndex = new Pair[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            intervalWithIndex[i] = new Pair(intervals[i], i);
        }
        Arrays.sort(intervalWithIndex, (o1, o2) -> o1.interval.start - o2.interval.start);
        Arrays.stream(intervalWithIndex).forEach(p -> System.out.println(p.interval.start + "," + p.interval.end + " " + p.index));
        for (int i = 0; i < intervalWithIndex.length; i++) {
            for (int j = i + 1; j < intervalWithIndex.length; j++) {
                if (intervalWithIndex[j].interval.start >= intervalWithIndex[i].interval.end) {
                    res[intervalWithIndex[i].index] = intervalWithIndex[j].index;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(3, 4), i2 = new Interval(2, 3), i3 = new Interval(1, 2);
        Arrays.stream(findRightInterval(new Interval[]{i1, i2, i3})).forEach(p -> System.out.println(p));
    }
}
