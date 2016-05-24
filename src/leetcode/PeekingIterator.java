package leetcode;

import java.util.Iterator;

/*
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 * Hint:
 * Think of "looking ahead". You want to cache the next element.
 * Is one variable sufficient? Why or why not?
 * Test your design with call order of peek() before next() vs next() before peek().
 * For a clean implementation, check out Google's guava library source code.
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */
public class PeekingIterator {
	public Iterator<Integer> it;
	public int cache;
	public boolean pointToFirst;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		it = iterator;
		pointToFirst = true;

	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (!pointToFirst)
			return cache;
		cache = it.next();
		pointToFirst = false;
		return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
		if (!pointToFirst) {
			pointToFirst = true;
			return cache;
		}
		return it.next();
	}

	public boolean hasNext() {
		if (!pointToFirst)
			return true;
		return it.hasNext();
	}
}
