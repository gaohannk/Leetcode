package company.failed;

import leetcode.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {
    public static Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node lastNode = root;
        while (!queue.isEmpty()) {
            Queue<Node> nextLayer = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    nextLayer.offer(cur.left);
                }
                if (cur.right != null) {
                    nextLayer.offer(cur.right);
                }
            }
            Queue<Node> copy = new LinkedList(nextLayer);
            lastNode.next = copy.peek();
            while (!copy.isEmpty()) {
                Node cur = copy.poll();
                if (copy.peek() != null) {
                    lastNode = copy.peek();
                    cur.next = copy.peek();
                }
            }
            queue = nextLayer;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        Node update = connect(root);
        while (update != null) {
            System.out.print(update.val + ", ");
            update = update.next;
        }

    }
}
