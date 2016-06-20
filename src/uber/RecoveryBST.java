package uber;

import utils.TreeNode;

public class RecoveryBST {
	private TreeNode node1, node2, preNode;

	public void recoverTree(TreeNode root) {
		inOrder(root);
		int temp = node1.val;
		node1.val = node2.val;
		node2.val = temp;
	}

	private void inOrder(TreeNode root) {
	    if (root==null) return;
		inOrder(root.left);
		if (preNode == null || root.val > preNode.val) {
			preNode = root;
		} else {
			if (node1 == null) {
				node1 = preNode;
				if (node2==null) node2 = root;
			} else {
				node2 = root;
			}
		}
		inOrder(root.right);
	}
}
