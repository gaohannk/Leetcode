package leetcode.algo.s;

import java.util.LinkedList;
import java.util.List;

public class ShortestWordDistanceIII2 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(word1.equals(words[i])) {
                idx1 = i;
                if(idx2 != -1) {
                    min = Math.min(min, Math.abs(idx2 - idx1));
                }
            }
            if(word2.equals(words[i])) {
                idx2 = i;
                if(idx1 != -1 && idx1 != idx2) {
                    min = Math.min(min, Math.abs(idx2 - idx1));
                }
            }
        }
        return min;
    }
}
