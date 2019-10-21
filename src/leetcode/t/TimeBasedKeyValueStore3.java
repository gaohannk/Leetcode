package leetcode.t;

import java.util.*;

/**
 * Create a timebased key-value store class TimeMap, that supports two operations.
 * <p>
 * 1. set(string key, string value, int timestamp)
 * <p>
 * Stores the key and value, along with the given timestamp.
 * 2. get(string key, int timestamp)
 * <p>
 * Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
 * If there are multiple such values, it returns the one with the largest timestamp_prev.
 * If there are no values, it returns the empty string ("").
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * Output: [null,null,"bar","bar",null,"bar2","bar2"]
 * Explanation:
 * TimeMap kv;
 * kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
 * kv.get("foo", 1);  // output "bar"
 * kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
 * kv.set("foo", "bar2", 4);
 * kv.get("foo", 4); // output "bar2"
 * kv.get("foo", 5); //output "bar2"
 * <p>
 * Example 2:
 * <p>
 * Input: inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * Output: [null,null,null,"","high","high","low","low"]
 * <p>
 * <p>
 * Note:
 * <p>
 * All key/value strings are lowercase.
 * All key/value strings have length in the range [1, 100]
 * The timestamps for all TimeMap.set operations are strictly increasing.
 * 1 <= timestamp <= 10^7
 * TimeMap.set and TimeMap.get functions will be called a total of 120000 times (combined) per test case.
 */
public class TimeBasedKeyValueStore3 {
    class TimeMap {
        private class Pair {
            List<String> vals;
            List<Integer> timestamps;

            public Pair(int timestamp, String value) {
                vals = new ArrayList<>();
                timestamps = new ArrayList<>();
                vals.add(value);
                timestamps.add(timestamp);
            }
        }

        private HashMap<String, Pair> map;

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            Pair p = map.get(key);
            if (p == null) {
                p = new Pair(timestamp, value);
                map.put(key, p);
            }
            p.timestamps.add(timestamp);
            p.vals.add(value);
        }

        public String get(String key, int timestamp) {
            Pair p = map.get(key);
            if (p == null)
                return "";
            int pos = search(p.timestamps, timestamp);
            if (pos == -1)
                return "";
            return p.vals.get(pos);
        }

        private int search(List<Integer> ts, int t) {
            int lo = 0;
            int hi = ts.size();
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (ts.get(mid) <= t) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            if (lo == 0)
                return -1;
            else
                return lo - 1;
        }
    }
}
