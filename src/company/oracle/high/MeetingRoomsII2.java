package company.oracle.high;
/* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */

import java.util.Arrays;

public class MeetingRoomsII2 {

    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int index = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[index])
                rooms++;
            else
                index++;
        }
        return rooms;
    }

}
