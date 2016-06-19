package leetcode;

import utils.TreeNode;

public class Sum_Root_to_Leaf_Numbers {
	int total;
	public int sumNumbers(TreeNode root) {
		if (root==null) {
			return 0;
		}
		total=0;
		DFStree(root,0);
		return total;
	}

	public int DFStree(TreeNode root, int current) {
		if (root.left==null & root.right==null) {
			total+=current*10+root.val;
			return root.val;
		}
		
		int left = 0;
		
		if (root.left != null) {
			left = DFStree(root.left,current*10+root.val);
		} else {
			left = 0;
		}
		int right = 0;
		if (root.right != null) {
			right =  DFStree(root.right,current*10+root.val);
		} else {
			right = 0;
		}
		return left + right;
	}
}