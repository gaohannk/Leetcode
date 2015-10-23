package leetcode;

import java.util.Stack;
/* Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree2 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null && q != null || p != null && q == null)
			return false;
		Stack<TreeNode> stack1= new Stack<TreeNode>();
		Stack<TreeNode> stack2= new Stack<TreeNode>();
		stack1.add(p);
		stack2.add(q);
		while(stack1.isEmpty()==false&&stack2.isEmpty()==false){
			if(stack1.peek().val!=stack2.peek().val)
				return false;
			TreeNode temp1=stack1.pop();
			TreeNode temp2=stack2.pop();
			if(temp1.left!=null&&temp2.left!=null){
				stack1.push(temp1.left);
				stack2.push(temp2.left);
			}
			if(temp1.left!=null&&temp2.left==null||temp1.left==null&&temp2.left!=null)
				return false;
			if(temp1.right!=null&&temp2.right!=null){
				stack1.push(temp1.right);
				stack2.push(temp2.right);
			}
			if(temp1.right!=null&&temp2.right==null||temp1.right==null&&temp2.right!=null)
				return false;
		}
		return true;
	}
}
