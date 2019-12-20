package leetcode.algo;

// Same with Solution 3 without construct graph
public class DeleteTreeNodes4 {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        return getSum(parent, value, 0, value[0])[1];
    }

    private int[] getSum(int[] parent, int[] value, int cur, int sum) {
        int cntRemainNodes = 1;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == cur) { // child node
                int[] temp = getSum(parent, value, i, value[i]);
                sum += temp[0];
                cntRemainNodes += temp[1];
            }
        }
        if (sum == 0)
            cntRemainNodes = 0; // Don't count nodes of this subtree
        return new int[]{sum, cntRemainNodes};
    }
}
