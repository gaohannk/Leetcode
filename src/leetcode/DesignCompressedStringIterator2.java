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
// My own version
public class DesignCompressedStringIterator2 {
    class StringIterator {
        boolean hasNext;
        String string;
        int p;
        int preChar;
        int num;

        public StringIterator(String compressedString) {
            this.string = compressedString;
            p = 0;
            preChar = p;
            p++;
            StringBuilder sb = new StringBuilder();
            while (p < string.length() && !Character.isAlphabetic(string.charAt(p))) {
                sb.append(string.charAt(p));
                p++;
            }
            num = Integer.parseInt(sb.toString());
            hasNext = true;
        }

        public char next() {
            if (hasNext) {
                if (num == 0) {
                    preChar = p;
                    p++;
                    StringBuilder sb = new StringBuilder();
                    while (p < string.length() && !Character.isAlphabetic(string.charAt(p))) {
                        sb.append(string.charAt(p));
                        p++;
                    }
                    if (sb.length() == 0) {
                        hasNext = false;
                        return ' ';
                    }
                    num = Integer.parseInt(sb.toString());
                    num--;
                    return string.charAt(preChar);
                } else {
                    num--;
                    return string.charAt(preChar);
                }
            } else {
                return ' ';
            }
        }

        public boolean hasNext() {
            if (num > 0 || p < string.length()) {
                hasNext = true;
                return hasNext;
            }
            hasNext = false;
            return hasNext;
        }
    }
}
