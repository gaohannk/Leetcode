package leetcode.algo.p;

import java.util.LinkedList;
import java.util.List;

public class PrintWordsVertically2 {
    public static List<String> printVertically(String s) {
        String[] splits = s.split(" ");
        List<String> res = new LinkedList<>();
        int maxLen = 0;
        for (String word : splits) {
            maxLen = Math.max(maxLen, word.length());
        }
        StringBuilder[] sb = new StringBuilder[maxLen];

        for (String word : splits) {
            for (int i = 0; i < maxLen; i++) {
                if(sb[i] == null){
                    sb[i] = new StringBuilder();
                }
                if (i < word.length()) {
                    sb[i].append(word.charAt(i));
                } else {
                    sb[i].append(" ");
                }
            }
        }
        for (int i = 0; i < sb.length; i++) {
            res.add(sb[i].toString().stripTrailing());
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(printVertically("TO BE OR NOT TO BE"));
    }
}
