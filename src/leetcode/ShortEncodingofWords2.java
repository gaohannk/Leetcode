package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by gaohan on 4/22/18.
 */
public class ShortEncodingofWords2 {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            int idx = sb.lastIndexOf(s);
            if (idx == -1 || sb.charAt(idx + s.length()) != '#') {
                sb.append(s + "#");
            }

        }
        return sb.length();
    }
}
