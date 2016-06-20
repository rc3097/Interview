package uber;

import utils.TreeNode;

/*
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=193516&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * 2. Lowest common ancestor in a tree.
 */
public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return (left != null && right != null) ? root : (left != null ? left
				: right);
	}

}
