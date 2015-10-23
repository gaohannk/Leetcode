package leetcode;

import java.util.ArrayList;

/* Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		if (rowIndex == 0) 
			return list;
		while (rowIndex-- > 0) {
			ArrayList<Integer> newlist = new ArrayList<Integer>();
			newlist.add(1);
			for (int i = 1; i < list.size(); i++) {
				newlist.add(list.get(i) + list.get(i - 1));
			}
			newlist.add(1);
			list = newlist;
		}
		return list;
	}
}
