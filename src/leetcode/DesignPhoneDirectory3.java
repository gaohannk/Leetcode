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
public class DesignPhoneDirectory3 {
	public class PhoneDirectory {

		private static final int SHIFT = 5, MOD = (1 << SHIFT) - 1;
		/**
		 * An array of integer. Every bit in each integer indicates if
		 * corresponding number has been taken.
		 */
		private int[] assigned;
		/**
		 * Capacity.
		 */
		private int capacity;

		/**
		 * Constructor.
		 *
		 * @param maxNumbers
		 *            max number of numbers
		 */
		public PhoneDirectory(int maxNumbers) {
			int arrlen = (maxNumbers >> SHIFT) + (0 == (maxNumbers & MOD) ? 0 : 1);
			assigned = new int[arrlen];
			capacity = maxNumbers;
		}

		/**
		 * Provide a number which is not assigned to anyone.
		 *
		 * @return an available number. Return -1 if none is available.
		 */
		public int get() {
			for (int idx = 0; idx < assigned.length; idx++) {
				if ((idx << SHIFT) >= capacity) {
					break;
				}
				if (assigned[idx] == (~0)) {
					continue;
				}
				int low0 = ~assigned[idx];
				low0 &= -low0;
				assigned[idx] |= low0;
				int ret = ((idx << SHIFT) | Integer.numberOfTrailingZeros(low0));
				if (ret < capacity) {
					return ret;
				}
			}
			return -1;
		}

		/**
		 * Check if a number is available or not.
		 *
		 * @param number
		 *            input number
		 * @return true if input number is available.
		 */
		public boolean check(int number) {
			if (number >= capacity || number < 0) {
				return false;
			}
			int[] loc = locate(number);
			return (assigned[loc[0]] & (1 << loc[1])) == 0;
		}

		/**
		 * Recycle or release a number.
		 *
		 * @param number
		 *            input number
		 */
		public void release(int number) {
			int[] loc = locate(number);
			assigned[loc[0]] &= ~(1 << loc[1]);
		}

		/**
		 * Locate the bit position of given number.
		 *
		 * @param number
		 *            input number
		 * @return an int array. The first element is the index of integer in
		 *         "assigned" array, the second element is the bit position of
		 *         input number in the integer.
		 */
		private int[] locate(int number) {
			return new int[] { number >> SHIFT, number & MOD };
		}
	}
}
