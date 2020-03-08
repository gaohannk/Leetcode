package leetcode.algo.p;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
    public static List<String> printVertically(String s) {
        List<String> ans = new ArrayList();
        String words[] = s.split(" ");
        int max = 0;
        for(String word : words)
            max = Math.max(max, word.length());

        for(int i = 0 ; i < max ; i++) {
            StringBuilder sb = new StringBuilder();
            for(String word : words) {
                if(i < word.length())
                    sb.append(word.charAt(i));
                else
                    sb.append(" ");
            }
            while(sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(printVertically("TO BE OR NOT TO BE"));
    }
}
