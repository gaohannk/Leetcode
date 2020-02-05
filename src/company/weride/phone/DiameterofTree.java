package company.weride.phone;


import java.util.*;

public class DiameterofTree {
    static class TreeNode {
        TreeNode child[];
        int val;
    }


    // O(n^2)
    public static int findDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Map<TreeNode, List<TreeNode>> map = new HashMap<>();

        dfs(map, root, null);

        int maxDisameter = 0;
        for (TreeNode cur : map.keySet()) {
            // O(n) n is total node
            int length = bfs(map, cur);
            maxDisameter = Math.max(maxDisameter, length);
        }

        return maxDisameter;
    }

    public static int bfs(Map<TreeNode, List<TreeNode>> map, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        Set<TreeNode> seen = new HashSet<>();

        while (!queue.isEmpty()) {
            Queue<TreeNode> nextLayer = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                seen.add(cur);
                for (int i = 0; i < map.get(cur).size(); i++) {
                    if (!seen.contains(map.get(cur).get(i))) {
                        nextLayer.add(map.get(cur).get(i));
                    }
                }
            }
            if (nextLayer.isEmpty()) {
                break;
            }
            queue = nextLayer;
            depth++;
        }
        return depth;
    }

    public static void dfs(Map<TreeNode, List<TreeNode>> map, TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (parent != null) {
            if (map.get(parent) == null) {
                map.put(parent, new LinkedList<>());
            }
            map.get(parent).add(root);
        }

        if (map.get(root) == null) {
            map.put(root, new LinkedList<>());
        }
        map.get(root).add(parent);

        for (int i = 0; i < root.child.length; i++) {
            dfs(map, root.child[i], root);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.child = new TreeNode[4];
        for (int i = 0; i < root.child.length; i++) {
            root.child[i] = new TreeNode();
        }
        root.child[0].child = new TreeNode[2];
        root.child[3].child = new TreeNode[2];
        root.child[0].child[0] = new TreeNode();
        root.child[0].child[0].child = new TreeNode[2];
        root.child[0].child[0].child[0] = new TreeNode();
        root.child[0].child[0].child[1] = new TreeNode();
        System.out.println(findDiameter(root));
    }
}
