package leetcode;
public class Q117 {
	private boolean hasChildren(TreeLinkNode root) {
		if (root.left != null || root.right != null)
			return true;
		return false;
	}

	private TreeLinkNode getChildren(TreeLinkNode root) {
		if (root == null)
			return null;
		if (root.left != null)
			return root.left;
		if (root.right != null)
			return root.right;
		return null;
	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		if (root.right != null) {
			TreeLinkNode temproot = root.next;
			while (temproot != null && !hasChildren(temproot))
				temproot = temproot.next;
			root.right.next = getChildren(temproot);
			connect(root.right);
		}
		if (root.left != null) {
			if (root.right != null) {
				root.left.next = root.right;
			} else {
				TreeLinkNode temproot = root.next;
				while (temproot != null && !hasChildren(temproot))
					temproot = temproot.next;
				root.left.next = getChildren(temproot);
			}
			connect(root.left);
		}
	}
}
