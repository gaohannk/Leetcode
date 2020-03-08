package leetcode.algo.s;

import leetcode.common.UnionFind;

import java.util.*;

/**
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 *
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 *
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 * Example 2:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 * Example 3:
 *
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s only contains lower case English letters.
 */
public class SmallestStringWithSwaps3 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        // key is root of component, value is list of node if belong to this component
        Map<Integer, List<Integer>> group = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int root = uf.find(i);
            if (group.get(root) == null) {
                group.put(root, new ArrayList<>());
            }
            group.get(root).add(i);
        }

        char[] chars = new char[s.length()];
        for (Integer root : group.keySet()) {
            List<Character> charList = new LinkedList<>();
            for (Integer i : group.get(root)) {
                charList.add(s.charAt(i));
            }
            Collections.sort(charList);
            for (int i = 0; i < group.get(root).size(); i++) {
                chars[group.get(root).get(i)] = charList.get(i);
            }
        }
        return new String(chars);
    }
}
