package leetcode.algo.f;

import leetcode.common.NestedInteger;

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
public class FlattenNestedListIterator {

	public class NestedIterator implements Iterator<Integer> {
		Stack<NestedInteger> stack = new Stack<>();

		public NestedIterator(List<NestedInteger> nestedList) {
			for (int i = nestedList.size() - 1; i >= 0; i--) {
				stack.push(nestedList.get(i));
			}
		}

		@Override
		public Integer next() {
			return stack.pop().getInteger();
		}

		@Override
		public boolean hasNext() {
			// Expand list in this function for handle case [[]], [[[]]], [[],[]], etc...
			while (!stack.isEmpty()) {
				if (stack.peek().isInteger())
					return true;
				else {
					List<NestedInteger> list = stack.pop().getList();
					for (int i = list.size() - 1; i >= 0; i--) {
						stack.push(list.get(i));
					}
				}
			}
			return false;
		}
	}

	/**
	 * Your NestedIterator object will be instantiated and called as such:
	 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext())
	 * v[f()] = i.next();
	 */
}
