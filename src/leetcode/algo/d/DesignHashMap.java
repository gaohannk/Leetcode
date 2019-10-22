package leetcode.algo.d;

public class DesignHashMap {
    class MyHashMap {
        private static final int SIZE = 10000;
        private Entry[] table;

        class Entry {
            int key;
            int val;
            Entry next;

            public Entry(int key, int val) {
                this.key = key;
                this.val = val;
                next = null;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            table = new Entry[SIZE];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            Entry e = new Entry(key, value);
            int code = hash(key) % SIZE;
            if (table[code] == null)
                table[code] = e;
            else
                addOrUpdateNode(table[code], e);
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int code = hash(key) % SIZE;
            Entry head = table[code];
            while (head != null) {
                if (head.key == key) return head.val;
                head = head.next;
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int code = hash(key) % SIZE;
            Entry head = table[code];
            Entry dummy = new Entry(0, 0), pre = dummy;
            dummy.next = head;
            while (head != null) {
                if (head.key == key) {
                    pre.next = head.next;
                    break;
                }
                pre = head;
                head = head.next;
            }
            table[code] = dummy.next;
        }

        private void addOrUpdateNode(Entry head, Entry node) {
            Entry pre = head;
            while (head != null) {
                if (head.key == node.key) {
                    head.val = node.val;
                    return;
                }
                pre = head;
                head = head.next;
            }
            pre.next = node;
        }

        private int hash(int i) {
            return Integer.hashCode(i);
        }
    }
}
