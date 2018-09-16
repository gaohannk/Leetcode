package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * <p>
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 */
public class MeetingRooms {
    public static boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1.start-o2.start);
        int endTime = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].start < endTime)
                return false;
            else
                endTime = intervals[i].end;
        }
        return true;
    }

    public static void main(String[] args){
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0,30);
        intervals[1] = new Interval(5,10);
        intervals[2] = new Interval(15,20);

        System.out.print(canAttendMeetings(intervals));
    }
}
