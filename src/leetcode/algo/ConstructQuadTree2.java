package leetcode.algo;

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

public class ConstructQuadTree2 {
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
        return helper(grid, 0, grid.length-1, 0, grid.length-1);
    }

    public Node helper(int[][] grid, int x1, int x2, int y1, int y2) {
        if (x1==x2 && y1==y2) {
            return new Node(grid[x1][y1] == 1 ? true: false, true, null, null, null, null);
        }
        if (isUnivalue(x1, x2, y1, y2, grid)) {
            return new Node(grid[x1][y1] == 1 ? true: false, true, null, null, null, null);
        }
        int x3 = (x1+x2)/2;
        int y3 = (y1+y2)/2;
        Node topLeft = helper(grid, x1, x3, y1, y3);
        Node topRight = helper(grid, x1, x3, y3+1, y2);
        Node bottomLeft = helper(grid, x3+1, x2, y1, y3);
        Node bottomRight = helper(grid, x3+1, x2, y3+1, y2);
        return new Node(grid[x1][y1] == 1 ? true: false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public boolean isUnivalue(int x1, int x2, int y1, int y2, int[][] grid) {
        int value = grid[x1][y1];
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (grid[i][j]!=value) {
                    return false;
                }
            }
        }
        return true;
    }
}
