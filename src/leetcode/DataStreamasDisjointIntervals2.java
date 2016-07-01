package leetcode;

import java.util.LinkedList;
import leetcode.Interval;
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/**Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
Follow up:
What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?

**/
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
import java.util.List;

//TLE
public class DataStreamasDisjointIntervals2 {
	public static class SummaryRanges {
		List<Interval> list;

		/** Initialize your data structure here. */
		public SummaryRanges() {
			list = new LinkedList<>();
		}

		public void addNum(int val) {
			if (list.size() == 0) {
				list.add(new Interval(val, val));
				return;
			}
			int start = 0;
			int end = list.size();

			while (start <= end) {
				int mid = (start + end) / 2;
				if (mid + 1 < list.size() && list.get(mid).end + 1 == val && list.get(mid + 1).start - 1 == val) {
					list.get(mid).end = list.get(mid + 1).end;
					list.remove(mid + 1);
					return;
				} else if (list.get(mid).end + 1 == val) {
					list.get(mid).end = val;
					return;
				} else if (mid - 1 >= 0 && list.get(mid).start - 1 == val && list.get(mid - 1).end + 1 == val) {
					list.get(mid).start = list.get(mid - 1).start;
					list.remove(mid - 1);
					return;
				} else if (list.get(mid).start - 1 == val) {
					list.get(mid).start = val;
					return;
				} else if (mid + 1 < list.size() && list.get(mid).end + 1 < val && list.get(mid + 1).start - 1 > val) {
					list.add(mid + 1, new Interval(val, val));
					return;
				} else if (mid - 1 >= 0 && list.get(mid - 1).end + 1 < val && list.get(mid).start - 1 > val) {
					list.add(mid, new Interval(val, val));
					return;
				} else if (list.get(mid).start <= val && list.get(mid).end >= val)
					return;
				else if (list.get(mid).start - 1 > val && mid == start) {
					list.add(mid, new Interval(val, val));
					return;
				} else if (list.get(mid).end + 1 < val && mid == end - 1) {
					list.add(mid + 1, new Interval(val, val));
					return;
				} else if (list.get(mid).start - 1 > val) {
					end = mid;
				} else if (list.get(mid).end + 1 < val) {
					start = mid + 1;
				}
			}
		}

		public List<Interval> getIntervals() {
			return list;
		}
	}

	public static void main(String[] args) {
		SummaryRanges sr = new SummaryRanges();
		sr.addNum(1);
		sr.getIntervals();
		sr.addNum(3);
		sr.getIntervals();
		sr.addNum(7);
		sr.getIntervals();
		sr.addNum(2);
		sr.getIntervals();
		sr.addNum(6);
		sr.getIntervals();
	}
}
