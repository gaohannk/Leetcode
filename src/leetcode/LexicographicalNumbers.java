package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*Given an integer n, return 1 - n in lexicographical order.
For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
*/
//TLE
public class LexicographicalNumbers {
	public List<Integer> lexicalOrder(int n) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<String> string = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			string.add(String.valueOf(n));
		}
		string.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				for (int i = 0; i < o1.length() && i < o2.length(); i++) {
					if (o1.charAt(i) < o2.charAt(i))
						return -1;
					else if (o1.charAt(i) > o2.charAt(i))
						return 1;
				}
				return o1.length() < o2.length() ? -1 : o1.length() > o2.length() ? 1 : 0;
			}
		});
		for(int i=0;i<string.size();i++){
			list.add(Integer.parseInt(string.get(i)));
		}
		return list;
	}
}
