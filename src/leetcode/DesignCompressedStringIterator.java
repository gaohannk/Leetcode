package leetcode;

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
public class DesignCompressedStringIterator {

    class StringIterator {
        StringBuilder res = new StringBuilder();
        int ptr = 0;

        public StringIterator(String s) {
            int i = 0;
            while (i < s.length()) {
                char ch = s.charAt(i++);
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                for (int j = 0; j < num; j++) {
                    res.append(ch);
                }
            }
        }

        public char next() {
            if (hasNext())
                return res.charAt(ptr++);
            return ' ';
        }

        public boolean hasNext() {
            return ptr != res.length();
        }
    }
}
