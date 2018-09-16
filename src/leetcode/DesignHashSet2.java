package leetcode;

public class DesignHashSet2 {
    class MyHashSet {
        int[] arr;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            arr = new int[1000000];
        }

        public void add(int key) {
            arr[key] = key + 1;  // handle the case key=0
        }

        public void remove(int key) {
            arr[key] = 0;
        }

        /**
         * Returns true if this set did not already contain the specified element
         */
        public boolean contains(int key) {
            return (arr[key] != 0);
        }
    }
}
