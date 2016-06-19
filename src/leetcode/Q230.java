package leetcode;

import utils.TreeNode;

public class Q230 {
	int element;
	int count=0;
    public int kthSmallest(TreeNode root, int k) {
    	element=Integer.MAX_VALUE;
    	inorder(root,k);
		return element;
    }
	private void inorder(TreeNode root, int k) {
		// TODO Auto-generated method stub
		if (element!= Integer.MAX_VALUE) return;
		if (root==null) return;
		inorder(root.left, k);
		if (++count==k) {
			element = root.val;
		}
		inorder(root.right, k);
	}
}