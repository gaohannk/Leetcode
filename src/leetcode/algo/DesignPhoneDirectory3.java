package leetcode.algo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * when a number k is issued, move pointer pos = next[k] to the next available position. set next[k]=-1 and
 * when a number is recycled, sipmly move pointer from pos to the recycled number, and change the recycled number's "next" point to pos.
 */
public class DesignPhoneDirectory3 {
    class PhoneDirectory {
        private int max;
        private Set<Integer> used;
        private LinkedList<Integer> released;

        /**
         * Initialize your data structure here
         *
         * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
         */
        public PhoneDirectory(int maxNumbers) {
            max = maxNumbers;
            used = new HashSet<>();
            released = new LinkedList<>();
        }

        /**
         * Provide a number which is not assigned to anyone.
         *
         * @return - Return an available number. Return -1 if none is available.
         */
        public int get() {
            if (used.size() == max) {
                return -1;
            }
            Integer ret = released.isEmpty() ? used.size() : released.remove();
            used.add(ret);
            return ret;
        }

        /**
         * Check if a number is available or not.
         */
        public boolean check(int number) {
            return !used.contains(number);
        }

        /**
         * Recycle or release a number.
         */
        public void release(int number) {
            if (used.remove(number))
                released.add(number);
        }
    }
}
