package leetcode.algo.d;

import java.util.LinkedList;
import java.util.Queue;

public class DesignBoundedBlockingQueue {
    class BoundedBlockingQueue {
        Queue<Integer> queue;
        int capacity;

        public BoundedBlockingQueue(int capacity) {
            queue = new LinkedList<Integer>();
            this.capacity = capacity;
        }

        public void enqueue(int element) throws InterruptedException {

            synchronized (queue) {
                //  A thread can also wake up without being notified, interrupted,
                //  or timing out, a so-called spurious wakeup. While this will rarely occur in
                //  practice, applications must guard against it by testing for the condition that
                // should have caused the thread to be awakened, and continuing to wait if the
                // condition is not satisfied. In other words, waits should always occur in loops,
                // like this one:

                //      synchronized (obj) {
                //          while (<condition does not hold>)
                //              obj.wait(timeout);
                //          ... // Perform action appropriate to condition
                //      }
                while (queue.size() == capacity) {
                    queue.wait();
                }
                queue.add(element);
                queue.notifyAll();
            }

        }

        public int dequeue() throws InterruptedException {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    queue.wait();
                }
                Integer polled = queue.poll();
                queue.notifyAll();
                return polled;
            }
        }

        public int size() {
            synchronized (queue) {
                return queue.size();
            }
        }
    }
}
