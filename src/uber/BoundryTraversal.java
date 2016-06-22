package uber;

import java.util.ArrayList;
import utils.BSTree;
import utils.BTreePrinter;
import utils.TreeNode;

/*
 * 
 * Given a balanced binary tree, counter clock-wise plot the tree node on the boundary.
 * For example

 5
 4             8
 1     3        2   6
 3   1  9  2   7

 5, 4, 1, 3, 1, 9, 2, 7, 6, 8
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=190253&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 */
public class BoundryTraversal {
	public ArrayList<Integer> counterclock(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		leftboundry(root, res);
		bottom(root, res);
		rightboundry(root, res);
		
		return res;
	}

	private void leftboundry(TreeNode root, ArrayList<Integer> res) {
		if (root == null)
			return;		
		if (root.left != null) {
			res.add(root.val);
			leftboundry(root.left, res);
		} else if (root.right != null) {
			res.add(root.val);
			leftboundry(root.right, res);
		}
	}

	private void rightboundry(TreeNode root, ArrayList<Integer> res) {
		if (root == null)
			return;
		if (root.right != null) {
			rightboundry(root.right, res);
			res.add(root.val);
		} else if (root.left != null) {
			rightboundry(root.left, res);
			res.add(root.val);
		}

		
	}

	private void bottom(TreeNode root, ArrayList<Integer> res) {
		if (root == null)
			return;

		bottom(root.left, res);
		if (root.left == null && root.right == null) {
			res.add(root.val);	
		return;
	}
		bottom(root.right, res);
	}

	public static void main(String[] args) {
		BSTree forest = new BSTree();
		BoundryTraversal q = new BoundryTraversal();
		while (forest.hasNext()) {
			TreeNode root = forest.next();
			BTreePrinter.printNode(root);
			System.out.println(q.counterclock(root));
			System.out.println("---------------");
		}
	}
}
