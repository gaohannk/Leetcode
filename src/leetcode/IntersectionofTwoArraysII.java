package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

/*
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to num2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

*/
public class IntersectionofTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			list1.add(nums1[i]);
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			if (list1.contains(nums2[i])) {
				list1.remove(list1.indexOf(nums2[i]));
				list.add(nums2[i]);
			}
		}
		int res[] = new int[list.size()];
		int index = 0;
		for (int num : list) {
			res[index++] = num;
		}
		return res;
	}
}
