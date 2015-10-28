package leetcode;

import java.util.LinkedList;
import java.util.List;

/* Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new LinkedList<String>();
		if (nums == null)
			return null;
		if (nums.length == 0)
			return res;
		String str = "" + nums[0];
		int p = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1] + 1) {
				if (i - p > 1) {
					str += "->" + nums[i - 1];
				}
				res.add(str);
				str = "" + nums[i];
				p = i;
			}
		}

		if (p < nums.length - 1)
			str += "->" + nums[nums.length - 1];
		res.add(str);
		return res;
	}
}
