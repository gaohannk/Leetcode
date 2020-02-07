package leetcode.algo;

import leetcode.common.Node;

/**
 * We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.
 *
 * Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.
 *
 * Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:
 *
 * Given the 8 x 8 grid below, we want to construct the corresponding quad tree:
 *
 *
 *
 * It can be divided according to the definition above:
 *
 *
 *
 *
 *
 * The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.
 *
 * For the non-leaf nodes, val can be arbitrary, so it is represented as *.
 *
 *
 *
 * Note:
 *
 * N is less than 1000 and guaranteened to be a power of 2.
 * If you want to know more about the quad tree, you can refer to its wiki.
 */

public class ConstructQuadTree {
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

    public Node construct(int[][] grid) {
        return helper(grid, 0, grid.length - 1, 0, grid[0].length);
    }

    public Node helper(int[][] grid, int xs, int xe, int ys, int ye) {
        Node root = new Node();
        int row = xe - xs;
        int col = ye - ys;

        int topleftVal = isAllOneOrZero(grid, 0, 0, xs, xe, ys, ye);
        if (topleftVal != -1) {
            Node topleft = new Node();
            topleft.val = topleftVal == 1 ? true : false;
            topleft.isLeaf = true;
            root.topLeft = topleft;
        }

        int topRightVal = isAllOneOrZero(grid, 0, col / 2, xs, xe, ys, ye);
        if (topleftVal != -1) {
            Node topright = new Node();
            topright.val = topRightVal == 1 ? true : false;
            topright.isLeaf = true;
            root.topRight = topright;

        }

        int bottomLeftVal = isAllOneOrZero(grid, row / 2, 0, xs, xe, ys, ye);
        if (bottomLeftVal != -1) {
            Node bootomLeft = new Node();
            bootomLeft.val = bottomLeftVal == 1 ? true : false;
            bootomLeft.isLeaf = true;
            root.bottomLeft = bootomLeft;
        }

        int bottomRightVal = isAllOneOrZero(grid, row / 2, col / 2, xs, xe, ys, ye);
        if (bottomRightVal != -1) {
            Node bottomRight = new Node();
            bottomRight.val = bottomRightVal == 1 ? true : false;
            bottomRight.isLeaf = true;
            root.bottomRight = bottomRight;
        }
        if (root.topLeft == null) {
            root.topLeft = helper(grid, xs, xs + row / 2, ys, ys + col / 2);
        }
        if (root.topRight == null) {
            root.topRight = helper(grid, xs + row / 2, xe, ys + col / 2, ye);
        }
        if (root.bottomLeft == null) {
            root.bottomLeft = helper(grid, xs, xs + row / 2, ys + col / 2, ye);
        }
        if (root.bottomRight == null) {
            root.bottomRight = helper(grid, xs + row / 2, xe, ys + col / 2, ye);
        }
        return root;
    }

    public int isAllOneOrZero(int[][] grid, int xoffset, int yoffset, int xs, int xe, int ys, int ye) {
        int row = xe - xs;
        int col = ye - ys;
        boolean allOne = false;
        boolean allZero = false;
        for (int i = xs + xoffset; i < row / 2 + xoffset; i++) {
            for (int j = ys + yoffset; j < col / 2 + yoffset; j++) {
                if (allOne && grid[i][j] == 0) {
                    return -1;
                }
                if (allZero && grid[i][j] == 1) {
                    return -1;
                }
                if (grid[i][j] == 1) {
                    allOne = true;
                    allZero = false;
                }
                if (grid[i][j] == 0) {
                    allZero = true;
                    allOne = false;
                }
            }
        }
        return allOne == true ? 1 : allZero ? 0 : -1;
    }
}
