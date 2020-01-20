package leetcode.algo.b;

import leetcode.common.TreeNode;

import java.util.*;

/* Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9

The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
*/
/* 这里垂直访问的意思是，每一列给它一个列号，左孩子比父节点的列号减1，右孩子比父节点的加1.列号相同的打印在同一行。
 *
 */
public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> distQueue = new LinkedList<>();
        distQueue.add(0);

        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode current = queue.poll();

                int dist = distQueue.poll();

                // Keep track of the maximum distance away from root
                max = Math.max(max, Math.abs(dist));


                List<Integer> currentList = map.getOrDefault(dist, new LinkedList<Integer>());
                currentList.add(current.val);
                map.put(dist, currentList);

                if (current.left != null) {
                    queue.add(current.left);
                    distQueue.add(dist - 1);
                }

                if (current.right != null) {
                    queue.add(current.right);
                    distQueue.add(dist + 1);
                }
                size--;
            }
        }

        // left to right, from maximum -ve distance from root to maximum +ve distance from root
        for (int i = -max; i <= max; i++) {
            if (map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }
}
