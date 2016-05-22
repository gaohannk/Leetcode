package leetcode;

/* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII2 {

	public int minMeetingRooms(Interval[] intervals) {
		int count = 0;
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		PriorityQueue<Interval> minHeap = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.end - o2.end;
			}
		});
		minHeap.offer(intervals[0]);
		for (int i = 0; i < intervals.length; i++) {
			int earlistEnd = minHeap.peek().end;
			if (earlistEnd < intervals[i].start) {
				minHeap.poll();
				minHeap.offer(intervals[i]);
			} else {
				minHeap.offer(intervals[i]);
				count++;
			}
		}
		return count;
	}
}
