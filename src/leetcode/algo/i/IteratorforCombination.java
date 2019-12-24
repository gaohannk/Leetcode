package leetcode.algo.i;

import java.util.PriorityQueue;

public class IteratorforCombination {
	static class CombinationIterator {
		PriorityQueue<String> pq = new PriorityQueue<>();

		public CombinationIterator(String s, int k) {
			generateSub(s, k, 0, new StringBuilder());
		}

		private void generateSub(String s, int len, int start, StringBuilder result) {
			if (len == 0) {
				pq.add(result.toString());
				return;
			}
			for (int i = start; i <= s.length() - len; i++) {
				result.append(s.charAt(i));
				generateSub(s, len - 1, i + 1, result);
				result.deleteCharAt(result.length() - 1);
			}
		}

		public String next() {
			return pq.poll();
		}

		public boolean hasNext() {
			return !pq.isEmpty();
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
