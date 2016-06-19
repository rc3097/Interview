package leetcode;
import java.util.ArrayList;

import javax.print.attribute.Size2DSyntax;

import utils.TreeNode;

public class Q236 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return (left != null && right != null) ? root : (left != null ? left
				: right);
	}

}