package company.linkedin;

import leetcode.common.NestedInteger;

import java.util.List;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int[] sum = new int[1];
        helper(nestedList, 1, sum);
        return sum[0];
    }

    private void helper(List<NestedInteger> nestedList, int depth, int[] sum) {
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger cur = nestedList.get(i);
            if (cur.isInteger()) {
                sum[0] += depth * cur.getInteger();
                continue;
            } else {
                helper(cur.getList(), depth + 1, sum);
            }
        }
    }
}
