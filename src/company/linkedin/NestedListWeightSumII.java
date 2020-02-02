package company.linkedin;

import leetcode.common.NestedInteger;

import java.util.List;

public class NestedListWeightSumII {
    int max = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int[] sum = new int[1];

        getDepth(nestedList, 1);
        helper(nestedList, max, sum);
        return sum[0];
    }

    private void getDepth(List<NestedInteger> nestedList, int depth) {
        if (depth > max) {
            max = depth;
        }
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger cur = nestedList.get(i);
            if (!cur.isInteger()) {
                getDepth(cur.getList(), depth + 1);
            }
        }
    }

    private void helper(List<NestedInteger> nestedList, int depth, int[] sum) {
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger cur = nestedList.get(i);
            if (cur.isInteger()) {
                sum[0] += depth * cur.getInteger();
                continue;
            } else {
                helper(cur.getList(), depth - 1, sum);
            }
        }
    }
}
