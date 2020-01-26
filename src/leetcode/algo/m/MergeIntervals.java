package leetcode.algo.m;

import leetcode.algo.i.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
	public class Solution {
		public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

			Collections.sort(intervals, new Comparator<Interval>() {
				public int compare(Interval a, Interval b) {
					return Integer.compare(a.start, b.start);
				}
			});

			ArrayList<Interval> res = new ArrayList<Interval>();
			int i = 0;
			while (i < intervals.size()) {
				int j = i + 1;
				int end = intervals.get(i).end;
				while (j < intervals.size() && end >= intervals.get(j).start) {
					end = Math.max(end, intervals.get(j).end);
					j++;
				}
				res.add(new Interval(intervals.get(i).start, end));
				i = j;

			}
			return res;
		}
	}
}
