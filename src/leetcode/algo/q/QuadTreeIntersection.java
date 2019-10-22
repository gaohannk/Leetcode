package leetcode.algo.q;

/**
 * A quadtree is a tree data in which each internal node has exactly four children: topLeft, topRight, bottomLeft and bottomRight. Quad trees are often used to partition a two-dimensional space by recursively subdividing it into four quadrants or regions.
 * <p>
 * We want to store True/False information in our quad tree. The quad tree is used to represent a N * N boolean grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same. Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.
 * <p>
 * For example, below are two quad trees A and B:
 * <p>
 * A:
 * +-------+-------+   T: true
 * |       |       |   F: false
 * |   T   |   T   |
 * |       |       |
 * +-------+-------+
 * |       |       |
 * |   F   |   F   |
 * |       |       |
 * +-------+-------+
 * topLeft: T
 * topRight: T
 * bottomLeft: F
 * bottomRight: F
 * <p>
 * B:
 * +-------+---+---+
 * |       | F | F |
 * |   T   +---+---+
 * |       | T | T |
 * +-------+---+---+
 * |       |       |
 * |   T   |   F   |
 * |       |       |
 * +-------+-------+
 * topLeft: T
 * topRight:
 * topLeft: F
 * topRight: F
 * bottomLeft: T
 * bottomRight: T
 * bottomLeft: T
 * bottomRight: F
 * <p>
 * <p>
 * Your task is to implement a function that will take two quadtrees and return a quadtree that represents the logical OR (or union) of the two trees.
 * <p>
 * A:                 B:                 C (A or B):
 * +-------+-------+  +-------+---+---+  +-------+-------+
 * |       |       |  |       | F | F |  |       |       |
 * |   T   |   T   |  |   T   +---+---+  |   T   |   T   |
 * |       |       |  |       | T | T |  |       |       |
 * +-------+-------+  +-------+---+---+  +-------+-------+
 * |       |       |  |       |       |  |       |       |
 * |   F   |   F   |  |   T   |   F   |  |   T   |   F   |
 * |       |       |  |       |       |  |       |       |
 * +-------+-------+  +-------+-------+  +-------+-------+
 * Note:
 * <p>
 * Both A and B represent grids of size N * N.
 * N is guaranteed to be a power of 2.
 * If you want to know more about the quad tree, you can refer to its wiki.
 * The logic OR operation is defined as this: "A or B" is true if A is true, or if B is true, or if both A and B are true.
 */
// TODO verify answer
public class QuadTreeIntersection {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node intersect(Node quadTree1, Node quadTree2) {
        Node root = new Node();
        helper(quadTree1, quadTree2, root);
        return root;
    }

    private void helper(Node quadTree1, Node quadTree2, Node root) {
        if (quadTree1 == null || quadTree2 == null)
            return;
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            root.val = quadTree1.val || quadTree2.val;
            root.isLeaf = true;
        } else if (quadTree1.isLeaf && !quadTree2.isLeaf) {
            root.topLeft = new Node();
            root.topRight = new Node();
            root.bottomLeft = new Node();
            root.bottomRight = new Node();
            helper(quadTree1, quadTree2.topLeft, root.topLeft);
            helper(quadTree1, quadTree2.topRight, root.topRight);
            helper(quadTree1, quadTree2.bottomLeft, root.bottomLeft);
            helper(quadTree1, quadTree2.bottomRight, root.bottomRight);
            if (root.topLeft.val && root.topRight.val && root.bottomLeft.val && root.bottomRight.val) {
                root.isLeaf = true;
                root.val = true;
            } else if (!root.topLeft.val && !root.topRight.val && !root.bottomLeft.val && !root.bottomRight.val) {
                root.isLeaf = true;
                root.val = false;
            }
        } else if (!quadTree1.isLeaf && quadTree2.isLeaf) {
            root.topLeft = new Node();
            root.topRight = new Node();
            root.bottomLeft = new Node();
            root.bottomRight = new Node();
            helper(quadTree1.topLeft, quadTree2, root.topLeft);
            helper(quadTree1.topRight, quadTree2, root.topRight);
            helper(quadTree1.bottomLeft, quadTree2, root.bottomLeft);
            helper(quadTree1.bottomRight, quadTree2, root.bottomRight);
            if (root.topLeft.val && root.topRight.val && root.bottomLeft.val && root.bottomRight.val) {
                root.isLeaf = true;
                root.val = true;
            } else if (!root.topLeft.val && !root.topRight.val && !root.bottomLeft.val && !root.bottomRight.val) {
                root.isLeaf = true;
                root.val = false;
            }
        } else {
            root.topLeft = new Node();
            root.topRight = new Node();
            root.bottomLeft = new Node();
            root.bottomRight = new Node();
            helper(quadTree1.topLeft, quadTree2.topLeft, root.topLeft);
            helper(quadTree1.topRight, quadTree2.topRight, root.topRight);
            helper(quadTree1.bottomLeft, quadTree2.bottomLeft, root.bottomLeft);
            helper(quadTree1.bottomRight, quadTree2.bottomRight, root.bottomRight);
        }
    }
}
