package leetcode.algo.d;

import java.util.Arrays;

/**
 * Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.
 * <p>
 * The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
 * <p>
 * next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
 * hasNext() - Judge whether there is any letter needs to be uncompressed.
 * <p>
 * Note:
 * Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.
 * <p>
 * Example:
 * <p>
 * StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
 * <p>
 * iterator.next(); // return 'L'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 't'
 * iterator.next(); // return 'C'
 * iterator.next(); // return 'o'
 * iterator.next(); // return 'd'
 * iterator.hasNext(); // return true
 * iterator.next(); // return 'e'
 * iterator.hasNext(); // return false
 * iterator.next(); // return ' '
 */
// Memory Limit Exceeded
public class DesignCompressedStringIterator4 {
    public class StringIterator {
        int ptr = 0;
        String[] chars;
        int[] nums;

        public StringIterator(String compressedString) {
            nums = Arrays.stream(compressedString.substring(1).split("[a-zA-Z]+")).mapToInt(Integer::parseInt).toArray();
            chars = compressedString.split("[0-9]+");
        }

        public char next() {
            if (!hasNext())
                return ' ';
            nums[ptr]--;
            char res = chars[ptr].charAt(0);
            if (nums[ptr] == 0)
                ptr++;
            return res;
        }

        public boolean hasNext() {
            return ptr != chars.length;
        }
    }
}
