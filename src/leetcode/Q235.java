package leetcode;

import utils.TreeNode;

public class Q235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val < root.val && q.val > root.val) {
			return root;
		}
		if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		if (p.val == root.val || q.val == root.val) {
			return root;
		}
		return root;
	}
}