package leetcode;

import java.util.Stack;

/*One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
*/
public class VerifyPreorderSerializationofaBinaryTree {
	public static boolean isValidSerialization(String preorder) {
		Stack<String> stack = new Stack<>();
		Stack<String> stack2 = new Stack<>();
		String items[] = preorder.split(",");
		for (int i = 0; i < items.length; i++) {
			stack.push(items[i]);
		}
		if (stack.size() == 1)
			return stack.pop().equals("#") ? true : false;
		if (stack.size() == 2)
			return false;
		while (!stack.isEmpty()) {
			if (stack.peek().equals("#")) {
				stack.pop();
				stack2.push("#");
			} else {
				if (stack2.isEmpty())
					return false;
				stack2.pop();
				if (stack2.isEmpty())
					return false;
				stack2.pop();
				stack.pop();
				stack2.push("#");
			}
		}
		return stack2.isEmpty() ? false : true;
	}

	public static void main(String[] args) {
		String preorder = "9,#,92,#,#";
		System.out.println(isValidSerialization(preorder));
	}
}
