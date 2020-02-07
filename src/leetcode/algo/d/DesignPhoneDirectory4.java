package leetcode.algo.d;

/**
 * when a number k is issued, move pointer pos = next[k] to the next available position. set next[k]=-1 and
 * when a number is recycled, sipmly move pointer from pos to the recycled number, and change the recycled number's "next" point to pos.
 */
public class DesignPhoneDirectory4 {
    class PhoneDirectory {
        int[] next; // next available position init 1,2,3,4,5...
        int pos;

        /**
         * Initialize your data structure here
         *
         * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
         */
        public PhoneDirectory(int maxNumbers) {
            next = new int[maxNumbers];
            pos = 0;
            for (int i = 0; i < maxNumbers - 1; i++) {
                next[i] = i + 1;
            }
            next[maxNumbers-1] = 0;
        }

        /**
         * Provide a number which is not assigned to anyone.
         *
         * @return - Return an available number. Return -1 if none is available.
         */
        public int get() {
            if (next[pos] == -1) {
                return -1;
            }
            int ret = pos;
            pos = next[pos];
            next[ret] = -1;
            return ret;
        }

        /**
         * Check if a number is available or not.
         */
        public boolean check(int number) {
            return next[number] != -1;
        }

        /**
         * Recycle or release a number.
         */
        public void release(int number) {
            if (next[number] != -1) {
                // no need to release
                return;
            }
            next[number] = pos;
            pos = number;
        }
    }
}
