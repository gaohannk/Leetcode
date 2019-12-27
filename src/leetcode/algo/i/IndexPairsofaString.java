package leetcode.algo.i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class IndexPairsofaString {
    public int[][] indexPairs(String text, String[] words) {
        List<List<Integer>> results = new ArrayList<>();
        for(int i=0; i<text.length(); i++) {
            for(int j=0; j<words.length; j++) {
                if(text.startsWith(words[j], i)) {
                    List<Integer> index = new LinkedList<>();
                    index.add(i);
                    index.add(i + words[j].length() - 1);
                    results.add(index);
                }
            }
        }

        Collections.sort(results, (a, b) -> (a.get(0)==b.get(0) ? a.get(1)-b.get(1) : a.get(0)-b.get(0)));
        int[][] res = new int[results.size()][2];
        for(int i=0;i< results.size();i++){
            res[i][0] = results.get(i).get(0);
            res[i][1] = results.get(i).get(1);
        }
        return res;
    }
}
