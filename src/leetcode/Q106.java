package leetcode;
import java.util.Arrays;
import java.util.function.IntPredicate;

public class Q106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		TreeNode rootNode = null;
		if (inorder.length == 1 && postorder.length == 1) {
			rootNode = new TreeNode(inorder[0]);
			return rootNode;
		} else if (inorder.length == 0 && postorder.length == 0) {
			return rootNode;
		}
		int midnode_val = postorder[postorder.length - 1];
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == midnode_val) {
				rootNode = new TreeNode(inorder[i]);
				int[] ltree_inorder = Arrays.copyOfRange(inorder, 0, i);
				int[] rtree_inorder = Arrays.copyOfRange(inorder, i + 1,
						inorder.length);
				int[] ltree_postorder = Arrays.copyOfRange(postorder, 0, i);
				int[] rtree_postorder = Arrays.copyOfRange(postorder, i,
						postorder.length - 1);
				rootNode.left = buildTree(ltree_inorder, ltree_postorder);
				rootNode.right = buildTree(rtree_inorder, rtree_postorder);
				break;
			}
		}
		return rootNode;
	}
}