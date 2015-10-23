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
//TLE
public class InsertInterval3 {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		for (int i=0;i<intervals.size();i++) {
			Interval currinter=intervals.get(i);
			if (currinter.end < newInterval.start) {
				continue;
			} else if (currinter.start > newInterval.end) {
				intervals.add(i,newInterval);
			} else if (currinter.end >= newInterval.start || currinter.start <= newInterval.end) {
				newInterval = new Interval(Math.min(currinter.start, newInterval.start), Math.max(newInterval.end,
						currinter.end));
				intervals.remove(currinter);
			}
		}
		return result;
	}
}
