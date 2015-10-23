package leetcode;

import java.util.ArrayList;

/* Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (numRows == 0)
			return res;
		list.add(1);
		res.add(list);
		while (--numRows > 0) {
			ArrayList<Integer> newlist = new ArrayList<Integer>();
			newlist.add(1);
			for (int i = 1; i < list.size(); i++) {
				newlist.add(list.get(i) + list.get(i - 1));
			}
			newlist.add(1);
			res.add(newlist);
			list = newlist;
		}
		return res;
	}
}
