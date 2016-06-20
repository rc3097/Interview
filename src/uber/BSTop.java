package uber;

import utils.BSTree;
import utils.BTreePrinter;
import utils.TreeNode;

/*
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=193460&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * BST insert, delete
 */
public class BSTop {

	public TreeNode insert(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		if (root.val == val)
			return root;
		if (root.val > val) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		return root;
	}

	private TreeNode getNextBig(TreeNode root) {
		if (root.right == null) return root;
		TreeNode node = root.right;
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public TreeNode delete(TreeNode root, int val) {
		if (root==null) return null;
		if (root.val == val) {
			TreeNode nextnode = getNextBig(root);
			if (nextnode.val == root.val) {
				return root.left;
			} else {
				root.val = nextnode.val;
				root.right = delete(root.right, nextnode.val);
			}
		} else if (root.val > val) {
			root.left = delete(root.left, val);
		} else if (root.val<val){
			root.right = delete(root.right, val);
		}
		return root;
	}

	public static void main(String[] args) {
		BSTree foresTree = new BSTree();
		BSTop qBsTop = new BSTop();
		while (foresTree.hasNext()) {
			TreeNode root = foresTree.next();
			System.out.println("before");
			BTreePrinter.printNode(root);
			System.out.println("after insert");
			BTreePrinter.printNode(root=qBsTop.insert(root, 9));
			System.out.println("after delete");
			BTreePrinter.printNode(root=qBsTop.delete(root, 11));
		}
	}
}
