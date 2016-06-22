package uber;

import sun.reflect.generics.tree.Tree;
import utils.BSTree;
import utils.BTreePrinter;
import utils.TreeNode;
/*
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=191754&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * BST longest diameter
 */
public class DiameteofBT {
	int max = 0;
	public int findLongest(TreeNode root) {
		max= 0;
		leaf2Node(root);
		return max;
	}
	
	private int leaf2Node(TreeNode root) {
		if (root==null) return 0;
		int leftpath = leaf2Node(root.left);
		int rightpath = leaf2Node(root.right);
		max = Math.max(max,leftpath + rightpath +1);
		return Math.max(leftpath,rightpath)+1;
	}
	
	
	public static void main(String[] args) {
		BSTree forests  =  new BSTree();
		DiameteofBT q = new DiameteofBT();
		while (forests.hasNext()) {
			TreeNode root = forests.next();
			BTreePrinter.printNode(root);
			System.out.println(q.findLongest(root));
			System.out.println("----------");
		}
	}
}
