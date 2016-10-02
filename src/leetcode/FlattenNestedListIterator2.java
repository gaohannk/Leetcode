package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

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
	/**
	 * // This is the interface that allows for creating nested lists. // You
	 * should not implement it, or speculate about its implementation public
	 * interface NestedInteger {
	 *
	 * // @return true if this NestedInteger holds a single integer, rather than
	 * a nested list. public boolean isInteger();
	 *
	 * // @return the single integer that this NestedInteger holds, if it holds
	 * a single integer // Return null if this NestedInteger holds a nested list
	 * public Integer getInteger();
	 *
	 * // @return the nested list that this NestedInteger holds, if it holds a
	 * nested list // Return null if this NestedInteger holds a single integer
	 * public List<NestedInteger> getList(); }
	 */
	public interface NestedInteger {
		// Returns true if this NestedInteger holds a single integer, rather
		// than a nested list
		public boolean isInteger();

		// Returns the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Returns null if this NestedInteger holds a nested list
		public Integer getInteger();

		// Returns the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Returns null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

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
