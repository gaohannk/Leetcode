package leetcode.algo.l;

import java.util.HashMap;
import java.util.HashSet;
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
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4,4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LFUCache2 {
    class Node {
        int key, val;
        int cnt;
        Node prev, next;

        public Node(int k, int v) {
            key = k;
            val = v;
            cnt = 1;
        }
    }

    class DLList {
        Node head, tail;
        int len;

        public DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            len = 0;
        }

        public void addHead(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            map.put(node.key, node);
            len++;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            len--;
            map.remove(node.key);
        }

        public void removeTail() {
            Node prevTail = tail.prev;
            remove(prevTail);
        }
    }

    Map<Integer, Node> map;
    Map<Integer, DLList> freq;
    int size, capacity;
    int maxFreq;

    public LFUCache2(int capacity) {
        map = new HashMap<>();
        freq = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        maxFreq = 0;
    }

    public int get(int key) {
        if (map.get(key) == null) return -1;

        Node node = map.get(key);
        int prevFreq = node.cnt;
        DLList prevList = freq.get(prevFreq);
        prevList.remove(node);

        int curFreq = prevFreq + 1;
        maxFreq = Math.max(maxFreq, curFreq);
        DLList curList = freq.getOrDefault(curFreq, new DLList());
        node.cnt++;
        curList.addHead(node);

        freq.put(prevFreq, prevList);
        freq.put(curFreq, curList);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (map.get(key) != null) {
            map.get(key).val = value;
            get(key);
            return;
        }

        Node node = new Node(key, value);
        DLList curList = freq.getOrDefault(1, new DLList());
        curList.addHead(node);
        size++;

        if (size > capacity) {
            if (curList.len > 1) {
                curList.removeTail();
            } else {
                for (int i = 2; i <= maxFreq; i++) {
                    if (freq.get(i) != null && freq.get(i).len > 0) {
                        freq.get(i).removeTail();
                        break;
                    }
                }
            }

            size--;
        }

        freq.put(1, curList);
    }
}
