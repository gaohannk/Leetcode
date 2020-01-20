package company.oracle.high;

import java.util.LinkedList;
import java.util.List;

public class DesignHitCounter {
    class HitCounter {
        public List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public HitCounter() {
            list = new LinkedList<>();
        }

        /**
         * Record a hit.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public void hit(int timestamp) {
            list.add(timestamp);
        }

        /**
         * Return the number of hits in the past 5 minutes.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public int getHits(int timestamp) {
            if (list.size() == 0) {
                return 0;
            }
            while (list.size()>0 && list.get(0) < timestamp - 299) {
                list.remove(0);
            }
            return list.size();
        }
    }
}
