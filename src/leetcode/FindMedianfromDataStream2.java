package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/* Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * Examples: 
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * For example:
 * add(1)
 * add(2)
 * findMedian() -> 1.5
 * add(3) 
 * findMedian() -> 2
 */
public class FindMedianfromDataStream2 {
	class MedianFinder {
		// max queue is always larger or equal to min queue
		PriorityQueue<Integer> min = new PriorityQueue();
		PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());

		// Adds a number into the data structure.
		public void addNum(int num) {
			max.offer(num);
			min.offer(max.poll());
			if (max.size() < min.size()) {
				max.offer(min.poll());
			}
		}

		// Returns the median of current data stream
		public double findMedian() {
			if (max.size() == min.size())
				return (max.peek() + min.peek()) / 2.0;
			else
				return max.peek();
		}
	};
}
