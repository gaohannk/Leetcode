package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber2 {
	public String largestNumber(int[] num) {
		// 1045
		// 1111 begin.
		if (num == null) {
			return null;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int n1 : num) {
			list.add(n1);
		}

		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				String s1 = "" + o1 + o2;
				String s2 = "" + o2 + o1;
				return s2.compareTo(s1);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int n : list) {
			sb.append(n);
		}

		if (sb.charAt(0) == '0') {
			return "0";
		}

		return sb.toString();
	}
}
