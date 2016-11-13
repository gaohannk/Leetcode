package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * A gene string can be represented by an 8-character long string, with choices from "A","C","G","T".
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 * <p>
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 * <p>
 * NOTE: 1. Starting point is assumed to be valid, so it might not be included in the bank. 2. If multiple mutations are needed, all mutations during in the sequence must be valid. For example,
 * bank: "AACCGGTA"
 * start: "AACCGGTT"
 * end: "AACCGGTA"
 * return: 1
 * <p>
 * bank: "AACCGGTA", "AACCGCTA", "AAACGGTA"
 * start: "AACCGGTT"
 * end: "AAACGGTA"
 * return: 2
 * bank: "AAAACCCC", "AAACCCCC", "AACCCCCC"
 * start: "AAAAACCC"
 * end: "AACCCCCC"
 * return: 3
 */
public class MinimumGeneticMutation2 {

    public static int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length())
            return -1;
        Set<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }
        if (!bankSet.contains(end))
            return -1;
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        q.offer("#");
        char[] che = end.toCharArray();
        int level = 0;
        int min = Integer.MAX_VALUE;
        char[] genes = new char[]{'A', 'C', 'G', 'T'};
        while (!q.isEmpty()) {
            String tmp = q.poll();
            if (tmp.equals("#")) {
                level++;
                if (!q.isEmpty())
                    q.offer("#");
            } else if (tmp.equals(end)) {
                min = Math.min(min, level);
            } else {
                char[] chs = tmp.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    if (chs[i] != che[i]) {
                        char c = chs[i];
                        for (char x : genes) {
                            if (x != c) {
                                chs[i] = x;
                                String ns = String.valueOf(chs);
                                if (bankSet.contains(ns))
                                    q.offer(ns);
                            }
                        }
                        chs[i] = c;
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
