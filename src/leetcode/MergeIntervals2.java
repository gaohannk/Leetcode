package leetcode;
import java.util.*;

/* Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class MergeIntervals2 {

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (intervals == null)
			return intervals;
		int len = intervals.size();
		if (len == 0 || len == 1)
			return intervals;

		// sort the input by start value
		Collections.sort(intervals, new IntervalComparator());
		Interval a = intervals.get(0);
		for (int i = 1; i < len; i++) {
			Interval b = intervals.get(i);
			// if can merge, merge a and b.
			if (a.end >= b.start) {
				a = new Interval(Math.min(a.start, b.start), Math.max(a.end,
						b.end));
			}
			// if cannot merge, move to the next, reset the a node.
			else {
				res.add(a);
				a = b;
			}
		}
		res.add(a);
		return res;
	}
}

class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval a, Interval b) {
		return a.start - b.start;
	}
}
