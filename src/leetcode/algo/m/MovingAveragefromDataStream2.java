package leetcode.algo.m;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/* Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAveragefromDataStream2 {
    class MovingAverage {
        int size, windowSum = 0, count = 0;
        Deque queue = new ArrayDeque<Integer>();

        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            count++;
            // calculate the new sum by shifting the window
            queue.add(val);
            int head = count > size ? (int) queue.poll() : 0;

            windowSum = windowSum - head + val;

            return windowSum * 1.0 / Math.min(size, count);
        }
    }
}
