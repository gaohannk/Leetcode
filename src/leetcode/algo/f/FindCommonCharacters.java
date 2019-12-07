package leetcode.algo.f;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 * <p>
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        if (A.length <= 0)
            return new LinkedList<String>();
        HashSet<Character> set = new HashSet<>();
        HashMap<Integer, int[]> exist = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (char c : A[i].toCharArray()) {
                set.add(c);
                if (exist.get(i) == null) {
                    int[] count = new int[26];
                    count[c - 'a']++;
                    exist.put(i, count);
                } else {
                    exist.get(i)[c - 'a']++;
                }
                System.out.println(exist.get(i)[c - 'a']);
            }

        }

        LinkedList<String> res = new LinkedList<>();
        next:
        for (Character c : set) {
            for (int i : exist.keySet()) {
                if (exist.get(i) == null || exist.get(i)[c - 'a'] == 0) {
                    continue next;
                }
            }
            int count = Integer.MAX_VALUE;
            for (int i : exist.keySet()) {
                count = exist.get(i)[c - 'a'] < count ? exist.get(i)[c - 'a'] : count;
            }
            while (count-- > 0) {
                res.add(c.toString());
            }
        }
        return res;
    }
}
