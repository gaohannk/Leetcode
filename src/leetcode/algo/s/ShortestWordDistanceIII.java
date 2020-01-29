package leetcode.algo.s;

import java.util.LinkedList;
import java.util.List;

public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        List<Integer> l1 = new LinkedList<Integer>();
        List<Integer> l2 = new LinkedList<Integer>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (s.equals(word1))
                l1.add(i);
            if (s.equals(word2))
                l2.add(i);
        }

        int min = Integer.MAX_VALUE;
        for (int a : l1) {
            for (int b : l2) {
                if (b != a) {
                    min = Math.min(Math.abs(b - a), min);
                }
            }
        }
        return min;
    }
}
