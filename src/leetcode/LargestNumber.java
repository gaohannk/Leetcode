package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/* Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
/* [5,343,23] compare 500 and 343,230 is wrong method see case [121,12]
 * Turn number to string and compare string by position. Can't use Integer.value of() directly to a+b, since out of Integer Range.
 * Corner Case: [0,0]
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				count++;
		}
		if (count == nums.length)
			return "0";
		String res = "";
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String a = o1 + o2;
				String b = o2 + o1;
				return b.compareTo(a);
			}
		});
		for (int i = 0; i < strs.length; i++) {
			res = strs[i] + res;
		}
		return res;
	}
}
