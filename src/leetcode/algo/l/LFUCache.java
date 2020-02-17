package leetcode.algo.l;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
 *
 *
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 *
 *
 * Example:
 *
 * LFUCache cache = new LFUCache( 2 / capacity / );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // returns 1
        *cache.put(3,3);    // evicts key 2
        *cache.get(2);       // returns -1 (not found)
        *cache.get(3);       // returns 3.
        *cache.put(4,4);    // evicts key 1.
        *cache.get(1);       // returns -1 (not found)
        *cache.get(3);       // returns 3
        *cache.get(4);       // returns 4
 */
public class LFUCache {

    private Map<Integer, Integer> keyToFreq = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> freqToKeySet = new HashMap<>();

    private Map<Integer, Integer> keyToVal = new HashMap<>();

    private int min = 0;
    private int cap;

    public LFUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        //1. get actual value and calculate freq
        int val = keyToVal.get(key);
        int oldFreq = keyToFreq.get(key);
        int newFreq = oldFreq + 1;

        //2. remove old freq
        HashSet<Integer> oldSet = freqToKeySet.get(oldFreq);
        oldSet.remove(key);

        //3. update min
        // only one key with min freq
        if (min == oldFreq && oldSet.size() == 0) {
            min++;
        }

        //4. add new freq and update freq map
        keyToFreq.put(key, newFreq);
        freqToKeySet.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqToKeySet.get(newFreq).add(key);

        return val;

    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        //if they key already exists
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key);
            return;
        }
        //remove min freq if size alreay equal to capacity
        if (keyToVal.size() >= cap) {
            int keyToRemove = freqToKeySet.get(min).iterator().next();
            freqToKeySet.get(min).remove(keyToRemove);
            keyToFreq.remove(keyToRemove);
            keyToVal.remove(keyToRemove);
        }

        //add the key and assign the min freq to 1
        keyToFreq.put(key, 1);
        keyToVal.put(key, value);
        if (!freqToKeySet.containsKey(1)) {
            freqToKeySet.put(1, new LinkedHashSet<>());
        }
        freqToKeySet.get(1).add(key);
        min = 1;
    }
}
