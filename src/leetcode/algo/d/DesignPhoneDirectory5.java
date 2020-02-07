package leetcode.algo.d;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * when a number k is issued, move pointer pos = next[k] to the next available position. set next[k]=-1 and
 * when a number is recycled, simply move pointer from pos to the recycled number, and change the recycled number's "next" point to pos.
 */
public class DesignPhoneDirectory5 {
    class PhoneDirectory {
        Set<Integer> used = new HashSet<Integer>();
        Queue<Integer> available = new LinkedList<Integer>();
        int max;

        public PhoneDirectory(int maxNumbers) {
            max = maxNumbers;
            for (int i = 0; i < maxNumbers; i++) {
                available.offer(i);
            }
        }

        public int get() {
            Integer ret = available.poll();
            if (ret == null) {
                return -1;
            }
            used.add(ret);
            return ret;
        }

        public boolean check(int number) {
            if (number >= max || number < 0) {
                return false;
            }
            return !used.contains(number);
        }

        public void release(int number) {
            if (used.remove(number)) {
                available.offer(number);
            }
        }
    }
}
