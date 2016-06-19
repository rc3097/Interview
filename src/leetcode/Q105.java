package leetcode;
import java.lang.reflect.Array;
import java.util.Arrays;

import utils.TreeNode;

public class Q105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode rootNode = null;
		if (preorder.length == 1) {
			rootNode = new TreeNode(preorder[0]);
			return rootNode;
		}
		if (preorder.length == 0) {
			return null;
		}
		int midnode_val = preorder[0];
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == midnode_val) {
				rootNode = new TreeNode(inorder[i]);
				int[] ltree_inorder = Arrays.copyOfRange(inorder, 0, i);
				int[] rtree_inorder = Arrays.copyOfRange(inorder, i + 1,
						inorder.length);
				int[] ltree_preorder = Arrays.copyOfRange(preorder, 1, i + 1);
				int[] rtree_preorder = Arrays.copyOfRange(preorder, i + 1,
						inorder.length);
				rootNode.left = buildTree(ltree_preorder, ltree_inorder);
				rootNode.right = buildTree(rtree_preorder, rtree_inorder);
				break;
			}
		}
		return rootNode;
	}
}