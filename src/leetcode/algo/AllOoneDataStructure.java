package leetcode.algo;

import java.util.HashMap;
import java.util.Map;
// TODO unfinished
public class AllOoneDataStructure {
    public class DoubleLinkedListNode {
        public int val;
        public String key;
        public DoubleLinkedListNode pre;
        public DoubleLinkedListNode next;

        public DoubleLinkedListNode(String key, int value) {
            val = value;
            this.key = key;
            this.next = null;
            this.pre = null;
        }

        public DoubleLinkedListNode(int val) {
            this.val = val;
        }
    }

    class AllOne {
        DoubleLinkedListNode head;
        DoubleLinkedListNode tail;
        Map<String, DoubleLinkedListNode> map;

        /**
         * Initialize your data structure here.
         */
        public AllOne() {
            head = new DoubleLinkedListNode(-1);
            tail = new DoubleLinkedListNode(-1);
            map = new HashMap<>();
        }

        // add node to the head
        public void addNode(DoubleLinkedListNode node) {
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        public void removeNode(DoubleLinkedListNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void moveToHead(DoubleLinkedListNode node) {
            removeNode(node);
            addNode(node);
        }

        private DoubleLinkedListNode removeTail() {
            DoubleLinkedListNode node = tail.pre;
            removeNode(tail.pre);
            return node;
        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            if (map.containsKey(key)) {
                DoubleLinkedListNode node = map.get(key);
                node.val++;
                while (node.next != null && node.next.val == node.val) {
                    DoubleLinkedListNode next = moveDown(node);
                    map.put(next.key, next);
                    map.put(node.key, node);
                    node = next;
                }
            } else {
                map.put(key, new DoubleLinkedListNode(key, 1));
            }
        }

        private DoubleLinkedListNode moveDown(DoubleLinkedListNode node) {
            DoubleLinkedListNode next = node.next;
            String tempKey = next.key;
            int tempVal = next.val;

            next.key = node.key;
            next.val = node.val;

            node.key = tempKey;
            node.val = tempVal;
            return next;
        }

        private DoubleLinkedListNode moveUp(DoubleLinkedListNode node) {
            DoubleLinkedListNode pre = node.pre;
            String tempKey = pre.key;
            int tempVal = pre.val;

            pre.key = node.key;
            pre.val = node.val;

            node.key = tempKey;
            node.val = tempVal;
            return pre;
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {

            DoubleLinkedListNode node = map.get(key);
            node.val--;
            if (node.val == 0) {
                map.remove(key);
                return;
            }
            while (node.pre != null && node.pre.val == node.val) {
                DoubleLinkedListNode prev = moveUp(node);
                map.put(prev.key, prev);
                map.put(node.key, node);
                node = prev;
            }
        }


        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            if (map.size() == 0) {
                return "";
            }
            return tail.pre.key;
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            if (map.size() == 0) {
                return "";
            }
            return head.next.key;
        }
    }
}
