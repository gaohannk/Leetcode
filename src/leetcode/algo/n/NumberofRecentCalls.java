package leetcode.algo.n;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofRecentCalls {
    static class RecentCounter {
        private Queue<Integer> queue;

        public RecentCounter() {
            this.queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            while (!queue.isEmpty()) {
                if (queue.peek() < t - 3000) {
                    queue.poll();
                } else {
                    break;
                }
            }
            return queue.size();
        }
    }

    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));

    }
}
