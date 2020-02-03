package leetcode.algo.c;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// O(k*log(n))
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> succ = new Stack<>();
        Stack<TreeNode> pred = new Stack<>();
        initializePredecessorStack(root, target, pred);
        initializeSuccessorStack(root, target, succ);
        if (!succ.isEmpty() && !pred.isEmpty() && succ.peek().val == pred.peek().val) {
            getNextPredecessor(pred);
        }
        while (k-- > 0) {
            if (succ.isEmpty()) {
                ret.add(getNextPredecessor(pred));
            } else if (pred.isEmpty()) {
                ret.add(getNextSuccessor(succ));
            } else {
                double succ_diff = Math.abs((double) succ.peek().val - target);
                double pred_diff = Math.abs((double) pred.peek().val - target);
                if (succ_diff < pred_diff) {
                    ret.add(getNextSuccessor(succ));
                } else {
                    ret.add(getNextPredecessor(pred));
                }
            }
        }
        return ret;
    }

    private void initializeSuccessorStack(TreeNode root, double target, Stack<TreeNode> succ) {
        while (root != null) {
            if (root.val == target) {
                succ.push(root);
                break;
            } else if (root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private void initializePredecessorStack(TreeNode root, double target, Stack<TreeNode> pred) {
        while (root != null) {
            if (root.val == target) {
                pred.push(root);
                break;
            } else if (root.val < target) {
                pred.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    private int getNextSuccessor(Stack<TreeNode> succ) {
        TreeNode curr = succ.pop();
        int ret = curr.val;
        curr = curr.right;
        while (curr != null) {
            succ.push(curr);
            curr = curr.left;
        }
        return ret;
    }

    private int getNextPredecessor(Stack<TreeNode> pred) {
        TreeNode curr = pred.pop();
        int ret = curr.val;
        curr = curr.left;
        while (curr != null) {
            pred.push(curr);
            curr = curr.right;
        }
        return ret;
    }
}
