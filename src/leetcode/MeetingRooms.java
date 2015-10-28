package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 */
public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null)
			return false;
/*		 Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				int r = o1.start - o2.start;
				return r < 0 ? -1 : r == 0 ? 0 : 1;
			}
		});
*/		
		Arrays.sort(intervals, (o1, o2) -> {
			int r = o1.start - o2.start;
			return r == 0 ? o1.end - o2.end : r;
		});

		for (int i = 1; i < intervals.length; i++) {
			Interval i1 = intervals[i - 1];
			Interval i2 = intervals[i];
			if (i1.end > i2.start)
				return false;
		}
		return true;
	}
}
