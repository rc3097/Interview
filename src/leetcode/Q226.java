package leetcode;
public class Q226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;
		TreeNode tempnode = root.left;
		root.left = root.right;
		root.right = tempnode;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}