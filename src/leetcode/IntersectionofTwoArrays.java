package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

/* Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (!set.contains(nums1[i]))
				set.add(nums1[i]);
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i]) && !list.contains(nums2[i]))
				list.add(nums2[i]);
		}
		int res[] = new int[list.size()];
		int index = 0;
		for (int num : list) {
			res[index++] = num;
		}
		return res;
	}
}
