package leetcode;
/* Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
// Sort and record positon
import java.util.Arrays;

public class ContainsDuplicateIII4 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length < 2 || k < 1 || t < 0)
			return false;
		ValuePosPair[] valPosArr = new ValuePosPair[nums.length];
		for (int i = 0; i < nums.length; i++)
			valPosArr[i] = new ValuePosPair(nums[i], i);
		Arrays.sort(valPosArr);
		for (int i = 0; i < valPosArr.length; i++) {
			for (int j = i + 1; j < valPosArr.length
					&& ((long) valPosArr[j].val - (long) valPosArr[i].val <= (long) t); j++) {
				if (Math.abs(valPosArr[j].pos - valPosArr[i].pos) <= k)
					return true;
			}
		}
		return false;
	}

	class ValuePosPair implements Comparable<ValuePosPair> {
		int val;
		int pos;

		ValuePosPair(int v, int p) {
			val = v;
			pos = p;
		}

		public int compareTo(ValuePosPair x) {
			if (this.val < x.val)
				return -1;
			else if (this.val == x.val)
				return 0;
			else
				return 1;
		}
	}
}
