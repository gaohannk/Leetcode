package company.offerup.phone;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        helper(root, sum, 0, list, res);
        return res;
    }

    private void helper(TreeNode node, int sum, int cur, List<Integer> list, List<List<Integer>> res) {
        if (cur == sum -node.val && node.left == null && node.right == null) {
            list.add(node.val);
            res.add(new LinkedList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        if(node.left!=null) {
            list.add(node.val);
            helper(node.left, sum, cur + node.val, list, res);
            list.remove(list.size() - 1);
        }
        if(node.right!=null) {
            list.add(node.val);
            helper(node.right, sum, cur + node.val, list, res);
            list.remove(list.size() - 1);
        }
    }
}
