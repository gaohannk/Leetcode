package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
 * <p>
 * Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:
 * <p>
 * CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
 * CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
 * CBTInserter.get_root() will return the head node of the tree.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * Output: [null,1,[1,2]]
 * Example 2:
 * <p>
 * Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * Output: [null,3,4,[1,2,3,4,5,6,7,8]]
 * <p>
 * <p>
 * Note:
 * <p>
 * The initial given tree is complete and contains between 1 and 1000 nodes.
 * CBTInserter.insert is called at most 10000 times per test case.
 * Every value of a given or inserted node is between 0 and 5000.
 */
public class CompleteBinaryTreeInserter {
    class CBTInserter {
        TreeNode root;
        Deque<TreeNode> deque;

        public CBTInserter(TreeNode root) {
            this.root = root;
            deque = new LinkedList();

            Queue<TreeNode> queue = new LinkedList();
            queue.offer(root);
            // BFS to populate deque
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left == null || node.right == null)
                    deque.offerLast(node);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        public int insert(int v) {
            TreeNode node = deque.peekFirst();
            deque.offerLast(new TreeNode(v));
            if (node.left == null)
                node.left = deque.peekLast();
            else {
                node.right = deque.peekLast();
                deque.pollFirst();
            }

            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
