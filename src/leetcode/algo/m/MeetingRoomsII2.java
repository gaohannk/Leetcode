package leetcode.algo.m;

/* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */

import leetcode.algo.i.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII2 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            queue.offer(intervals[i]);
        }

        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] meeting = intervals[i];
            if (meeting[0] < queue.peek()[1]) {
                count++;
            } else {
                queue.poll();
            }
        }
        return count;
    }
}
