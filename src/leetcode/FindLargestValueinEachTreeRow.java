package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You need to find the largest value in each row of a binary tree.

 Example:
 Input:

 1
 / \
 3   2
 / \   \
 5   3   9

 Output: [1, 3, 9]
 */
public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root==null)
            return res;
        Queue<LinkedList<TreeNode>> queue = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        queue.add(list);
        while(!queue.peek().isEmpty()){
            int max = Integer.MIN_VALUE;
            LinkedList<TreeNode> curLayer = queue.poll();
            LinkedList<TreeNode> nextLayer = new LinkedList<>();
            while(!curLayer.isEmpty()){
                TreeNode cur = curLayer.poll();
                max = max > cur.val? max:cur.val;
                if(cur.left!=null)
                    nextLayer.add(cur.left);
                if(cur.right!=null)
                    nextLayer.add(cur.right);
            }
            queue.add(nextLayer);
            res.add(max);
        }
        return res;
    }
}
