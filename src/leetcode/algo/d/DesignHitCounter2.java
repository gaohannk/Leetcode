package leetcode.algo.d;

import java.util.ArrayList;
import java.util.List;

/* Design a hit counter which counts the number of hits received in the past 5 minutes.
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 * It is possible that several hits arrive roughly at the same time.

Example:
HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301); 
Follow up:
What if the number of hits per second could be very large? Does your design scale?
*/
// Not Scale version
public class DesignHitCounter2 {
    class HitCounter {
        private List<Integer> hits;
        private int lastTime;

        public HitCounter() {
            hits = new ArrayList<>();
            lastTime = -1;
        }

        public void hit(int timestamp) {
            // insert to head
            hits.add(0, timestamp);
            lastTime += 1;
        }

        public int getHits(int timestamp) {
            if (hits.size() == 0)
                return 0;
            while (lastTime > 0 && hits.get(lastTime) < timestamp - 299) {
                // drop early hits
                hits.remove(lastTime);
                lastTime -= 1;
            }
            return (hits.get(lastTime) < timestamp - 299) ? 0 : lastTime + 1;
        }
    }
}
