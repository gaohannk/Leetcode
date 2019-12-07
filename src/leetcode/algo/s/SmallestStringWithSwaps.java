package leetcode.algo.s;

import leetcode.common.UnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();

        // Form the UF sets.
        UnionFind uf = new UnionFind(n);
        for (List<Integer> x : pairs)
            uf.union(x.get(0), x.get(1));

        // Build map with root -> all characters for the set, using PriorityQueue to use natural ordering.
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        //Iterate over all indexes to add its char map.
        for (int i = 0; i < n; i++) {
            int root = uf.find(i); // Use root instead of i, so all indexes in connected map add char to same priorityQueue.
            PriorityQueue<Character> pq = map.getOrDefault(root, new PriorityQueue<>());
            pq.add(s.charAt(i));
            map.put(root, pq);
        }

        StringBuffer b = new StringBuffer();
        // Iterate over each index to grab the already sorted top element from the pq in the connected map.
        for (int i = 0; i < n; i++) {
            PriorityQueue<Character> pq = map.get(uf.find(i));
            b.append("" + pq.poll());
        }
        return b.toString();
    }
}
