package leetcode.algo.p;

/* Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> current = new ArrayList<>();
            for (List<Integer> l : result) {
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);
                    current.add(new ArrayList<Integer>(l));
                    // - remove num[i] add
                    l.remove(j);
                }
            }
            result = new ArrayList<>(current);
        }
        return result;
    }
}
