package leetcode;
import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class Q112 {

	int sum;

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		this.sum = sum;
		return pathNodeSum(root, 0);
	}

	private boolean pathNodeSum(TreeNode current, int currentsum) {
		int currentvalue = currentsum + current.val;
		if (currentvalue == sum && current.left == null
				&& current.right == null)
			return true;
		if (current.left != null) {
			if (pathNodeSum(current.left, currentvalue))
				return true;
		}
		if (current.right != null) {
			if (pathNodeSum(current.right, currentvalue))
				return true;
		}
		return false;
	}
}
