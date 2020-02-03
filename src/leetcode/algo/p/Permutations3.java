package leetcode.algo.p;
/* Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

import java.util.ArrayList;
import java.util.List;


public class Permutations3 {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0)
            return res;

        List<Integer> list = new ArrayList<Integer>();
        helper(res, list, num);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] num) {
        if (list.size() == num.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (list.contains(num[i])) {
                continue;
            }
            list.add(num[i]);
            helper(res, list, num);
            list.remove(list.size() - 1);
        }
    }
}
