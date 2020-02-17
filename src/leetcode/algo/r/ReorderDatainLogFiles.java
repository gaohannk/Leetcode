package leetcode.algo.r;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 */

public class ReorderDatainLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ");
                String[] s2 = o2.split(" ");
                boolean isDigit1 = isNumber(s1[1]);
                boolean isDigit2 = isNumber(s2[1]);

                if (!isDigit1 && !isDigit2) {
                    for (int i = 1; i < s1.length; i++) {
                        if (s1[i].compareTo(s2[i]) == 0)
                            continue;
                        else
                            return s1[i].compareTo(s2[i]);
                    }
                    return s1[0].compareTo(s2[0]);
                } else {
                    return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
                }
            }

        });
        return logs;
    }

    private boolean isNumber(String s) {
       return Character.isDigit(s.charAt(0));
    }
}
