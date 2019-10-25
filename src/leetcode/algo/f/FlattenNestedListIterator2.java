package leetcode.algo.f;

import leetcode.common.NestedInteger;

import java.util.*;

/*Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
*/
public class FlattenNestedListIterator2 {

	public class NestedIterator implements Iterator<Integer> {
		Deque<NestedInteger> s;

		public NestedIterator(List<NestedInteger> nestedList) {
			s = new ArrayDeque<>(nestedList == null ? Arrays.asList() : nestedList);
		}

		@Override
		public Integer next() {
			return s.pollFirst().getInteger();
		}

		@Override
		public boolean hasNext() {
			while (!s.isEmpty() && !s.peekFirst().isInteger()) {
				List<NestedInteger> list = s.pollFirst().getList();
				for (int i = list.size() - 1; i >= 0; i--)
					s.addFirst(list.get(i));
			}
			return !s.isEmpty();
		}
	}

	/**
	 * Your NestedIterator object will be instantiated and called as such:
	 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext())
	 * v[f()] = i.next();
	 */
}
