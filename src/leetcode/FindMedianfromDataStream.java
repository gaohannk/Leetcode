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
public class FindMedianfromDataStream {
	static class MedianFinder {
		Queue<Integer> min = null;
		Queue<Integer> max = null;
		int minsize = 0;
		int maxsize = 0;

		public MedianFinder() {
			min = new PriorityQueue<Integer>();
			max = new PriorityQueue<Integer>(Collections.reverseOrder());
		}

		// Adds a number into the data structure.
		public void addNum(int num) {
			if (minsize < maxsize) {
				min.offer(num);
				minsize++;
			} else {
				max.offer(num);
				maxsize++;
			}
			// when minsize=0 min is empty
			if (maxsize>1&&max.peek() > min.peek()) {
				min.offer(max.poll());
				max.offer(min.poll());
			}
		}

		// Returns the median of current data stream
		public double findMedian() {
			if (minsize == maxsize)
				// Don't forget double
				return (double)(min.peek() + max.peek()) / 2;
			return max.peek();
		}
	}
	public static void main(String[] args){
		MedianFinder mf = new MedianFinder();
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(4);
		System.out.println(mf.findMedian());
	}
}
