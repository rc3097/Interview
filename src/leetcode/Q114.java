package leetcode;
public class Q114 {
	public void flatten(TreeNode root) {
		root = reorder(root);
	}

	public TreeNode reorder(TreeNode root) {
		if (root == null)
			return null;
		TreeNode leftchild = reorder(root.left);
		TreeNode tmpNode = reorder(root.right);
		if (leftchild!=null) root.right = leftchild;
		root.left = null;
		if (leftchild != null) {
			while (leftchild.right != null) {
				leftchild = leftchild.right;
			}
			leftchild.right = tmpNode;
		}
		return root;
	}
}