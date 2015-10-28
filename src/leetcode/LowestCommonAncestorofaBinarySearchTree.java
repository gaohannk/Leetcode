package leetcode;
/* Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
  For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
  Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
*/
public class LowestCommonAncestorofaBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (p == null)
			return q;
		if (q == null)
			return p;
		if (existin(root.left, p) && existin(root.left, q))
			return lowestCommonAncestor(root.left, p, q);
		else if (existin(root.right, p) && existin(root.right, q))
			return lowestCommonAncestor(root.right, p, q);
		else
			return root;
	}

	public boolean existin(TreeNode root, TreeNode p) {
		if (root == null)
			return false;
		if (root == p)
			return true;
		return existin(root.left, p) || existin(root.right, p);
	}
}
