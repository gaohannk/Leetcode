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
public class DataStreamasDisjointIntervals {
	public class SummaryRanges {
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
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i).end + 1 == val && list.get(i + 1).start - 1 == val) {
					list.get(i).end = list.get(i + 1).end;
					list.remove(i + 1);
					return;
				} else if (list.get(i).end + 1 == val) {
					list.get(i).end = val;
					return;
				} else if (list.get(i + 1).start - 1 == val) {
					list.get(i + 1).start = val;
					return;
				} else if (list.get(i + 1).start - 1 > val) {
					Interval interval = new Interval(val, val);
					list.add(i + 1, interval);
					return;
				}else if(list.get(i).start<=val&&list.get(i).end>=val)
					return;
			}
			if (list.get(list.size() - 1).end + 1 == val)
				list.get(list.size() - 1).end = val;
			else {
				Interval interval = new Interval(val, val);
				list.add(interval);
			}
		}

		public List<Interval> getIntervals() {
			return list;
		}
	}
}
