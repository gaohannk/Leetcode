package leetcode;

/* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */
/* The basic idea is for each room, we count how many rooms are overlapped with it.
   O(n^2)
 */
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsII3 {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        int max = 1;
        for (int i = 0; i < intervals.length; i++) {
            int count = 1;
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j].start < intervals[i].end) {
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
