package company.failed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        List<Integer> list = new LinkedList<>();
        helper(candidates, list, res, 0, target, 0);
        return res;
    }

    private void helper(int[] candidates, List<Integer> list, List<List<Integer>> res, int cur, int target, int start) {
        if (cur == target) {
            res.add(new LinkedList<>(list));
            return;
        }
        if (cur > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            list.add(candidates[i]);
            helper(candidates, list, res, cur + candidates[i], target, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
