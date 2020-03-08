package leetcode.algo.p;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintWordsVertically3 {
    public static List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLen = 0;
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words.length; j++) {
                if (i < words[j].length()) {
                    sb.append(words[j].charAt(i));
                } else {
                    sb.append(" ");
                }
            }
            list.add(trimTrailingSpace(sb.toString()));
        }
        return list;
    }

    public static String trimTrailingSpace(String s) {
        int idx = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                idx = i;
                break;
            }
        }
        return s.substring(0, idx + 1);
    }

    public static void main(String[] args) {
        System.out.println(printVertically("TO BE OR NOT TO BE"));
    }
}
