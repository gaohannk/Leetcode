package leetcode.d;

import java.util.BitSet;

public class DesignHashSet {
    class MyHashSet {
        BitSet b;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            b = new BitSet(1000001);
        }

        public void add(int key) {
            b.set(key);
        }

        public void remove(int key) {
            b.clear(key);
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return b.get(key);
        }
    }

}
