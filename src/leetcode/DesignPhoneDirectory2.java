package leetcode;

import java.util.Iterator;
import java.util.LinkedHashSet;

import java.util.Set;

/*Design a Phone Directory which supports the following operations:


get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);
*/
public class DesignPhoneDirectory2 {
	class PhoneDirectory {
		Set<Integer> set;

		/**
		 * Initialize your data structure here
		 * 
		 * @param maxNumbers
		 *            - The maximum numbers that can be stored in the phone
		 *            directory.
		 */
		public PhoneDirectory(int maxNumbers) {
			set = new LinkedHashSet<>();

			for (int i = 0; i < maxNumbers; i++) {
				set.add(i);
			}
		}

		/**
		 * Provide a number which is not assigned to anyone.
		 * 
		 * @return - Return an available number. Return -1 if none is available.
		 */
		public int get() {
			Iterator<Integer> iter = set.iterator();

			if (!set.isEmpty()) {
				int val = (int) iter.next();
				set.remove(val);
				return val;
			}
			return -1;
		}

		/** Check if a number is available or not. */
		public boolean check(int number) {
			return set.contains(number);
		}

		/** Recycle or release a number. */
		public void release(int number) {
			set.add(number);
		}
	}
}
