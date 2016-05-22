package leetcode;

import java.util.LinkedList;

/* Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
*/
public class MovingAveragefromDataStream {
	public class MovingAverage {

		LinkedList<Integer> queue;
		int size;
		int sum;

		/** Initialize your data structure here. */
		public MovingAverage(int size) {
			this.queue = new LinkedList<Integer>();
			this.size = size;
			this.sum = 0;
		}

		public double next(int val) {
			queue.offer(val);
			if (queue.size() > this.size) {
				sum -= queue.poll();
			}
			sum += val;
			return (double) sum / queue.size();
		}
	}
}
