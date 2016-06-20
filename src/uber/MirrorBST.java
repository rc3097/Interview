package uber;

import utils.BSTree;
import utils.TreeNode;
import utils.BTreePrinter;

/*
 * 
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=188883&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * mirror BST
 */
public class MirrorBST {
	
	public void mirrorTree(TreeNode root) {
		if (root==null) return;
		mirrorTree(root.left);
		mirrorTree(root.right);
		TreeNode tempNode = root.left;
		root.left =  root.right;
		root.right = tempNode; 
	}
	
	public static void main(String[] args) {
		BSTree bTree = new BSTree();
		MirrorBST q = new MirrorBST();
		while (bTree.hasNext()) {
			TreeNode treeNode = bTree.next();
			BTreePrinter.printNode(treeNode);
			q.mirrorTree(treeNode);
			System.out.println("After");
			BTreePrinter.printNode(treeNode);
		}
	}
}
