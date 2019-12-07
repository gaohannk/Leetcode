package leetcode.algo.m;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * <p>
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 */
public class MeetingRooms {
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int endTime = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < endTime)
                return false;
            else
                endTime = intervals[i][1];
        }
        return true;
    }
}
