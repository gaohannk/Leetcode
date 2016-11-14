package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {

    class Entry {
        char c;
        int count;

        public Entry() {
            this.count = 0;
        }
    }

    public String frequencySort(String s) {
        Entry[] elems = new Entry[256];
        for (int i = 0; i < 256; i++) {
            elems[i] = new Entry();
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            elems[c].c = c;
            elems[c].count++;
        }
        Arrays.sort(elems, (e1, e2) -> e2.count - e1.count);

        StringBuilder res = new StringBuilder();
        for (Entry e : elems) {
            while (e.count-- > 0)
                res.append(e.c);
        }
        return res.toString();
    }
}

