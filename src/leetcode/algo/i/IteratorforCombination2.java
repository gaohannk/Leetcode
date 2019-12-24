package leetcode.algo.i;

import java.util.LinkedList;
import java.util.List;

public class IteratorforCombination2 {
	static class CombinationIterator {

		public List<Character> list = new LinkedList<>();
		public int len;
		public String cur;
		public String last;

		public CombinationIterator(String characters, int combinationLength) {
			for (int i = 0; i < characters.length(); i++) {
				this.list.add(characters.charAt(i));
			}
			this.len = combinationLength;
			this.last = "";
			for (int i = characters.length() - 1; i >= characters.length() - len; i--) {
				this.last = list.get(i) + last;
			}
		}

		public String next() {
			if (!hasNext()) {
				return null;
			}
			if (cur == null) {
				cur = "";
				for (int i = 0; i < len; i++) {
					cur += list.get(i);
				}
				return cur;
			}
			int p = list.size() - 1;
			for (int i = len - 1; i >= 0; i--) {
				int index = list.indexOf(cur.charAt(i));
				if (index == p) {
					p--;
					continue;
				} else {
					// abcdef: abcf -> abde
					cur = cur.substring(0, i);
					for (int j = i; j < len; j++) {
						cur += list.get(index + 1);
						index++;
					}
					return cur;
				}
			}
			return null;
		}

		public boolean hasNext() {
			if (cur != null && cur.equals(last))
				return false;
			return true;
		}
	}

	public static void main(String[] args) {
		CombinationIterator iterator = new CombinationIterator("chp", 1); // creates the iterator.
		System.out.println(iterator.next()); // returns "ab"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "ac"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "bc"
		System.out.println(iterator.hasNext()); // returns false
	}
}
