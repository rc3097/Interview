package leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.TreeNode;

public class Q94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> results = new ArrayList<Integer>();
		if (root == null)
			return results;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		boolean istraceback =  false;
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode current = stack.peek();
			if (!istraceback && current.left != null) {
				stack.push(current.left);
				istraceback = false;
			} else {
				current = stack.pop();
				results.add(current.val);
				if (current.right != null) {
					stack.push(current.right);
					istraceback = false;
				} else {
					istraceback = true;
				}
			}
		}
		return results;
	}
}