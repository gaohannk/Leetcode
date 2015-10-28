package leetcode;

import java.util.HashSet;

/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string. 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic. 
 */
public class StrobogrammaticNumber {
	public boolean isStrobogrammatic1(String num) {
		if (num == null || num.length() == 0)
			return false;
		HashSet<Character> set = new HashSet<Character>();
		set.add('0');
		set.add('1');
		set.add('8');
		int mid = num.length() / 2;
		if (num.length() % 2 == 1 && !set.contains(num.charAt(mid)))
			return false;
		for (int i = 0; i < num.length() / 2; i++) {
			char left = num.charAt(i);
			char right = num.charAt(num.length() - 1 - i);
			if (left == right) {
				if (!set.contains(left))
					return false;
			} else {
				boolean flag=(left == '6' && right == '9') || (left == '9' && right == '6');
				if (!flag)
					return false;
			}
		}
		return true;

	}
}
