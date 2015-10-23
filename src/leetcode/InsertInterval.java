package leetcode;

import java.util.ArrayList;

/* Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if 
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		int i = 0;
		for (i = 0; i < intervals.size(); i++) {
			if (intervals.get(i).end < newInterval.start) {
				result.add(intervals.get(i));
			} else if (intervals.get(i).start > newInterval.end) {
				result.add(newInterval);
				break;
			} else if (intervals.get(i).end >= newInterval.start || intervals.get(i).start <= newInterval.end) {
				newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(
						newInterval.end, intervals.get(i).end));
			}
		}
		if (i == intervals.size())
			result.add(newInterval);
		for (; i < intervals.size(); i++)
			result.add(intervals.get(i));
		return result;
	}
}
