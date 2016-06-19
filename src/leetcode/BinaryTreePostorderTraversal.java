package leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.TreeNode;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stacks = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null || !stacks.isEmpty()) {
			if (p != null) {
				stacks.push(p);
				p = p.left;
			} else {
				p = stacks.peek();
				if (p.right != null) {
					p = p.right;
					stacks.peek().right=null;
				} else {
					result.add(p.val);
					p= stacks.pop();
					p =null;
				}
			}
		}
		return result;
	}
}
