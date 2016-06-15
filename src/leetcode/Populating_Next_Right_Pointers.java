package leetcode;

public class Populating_Next_Right_Pointers {

	/**
	 * Definition for binary tree with next pointer.
	 * public class TreeLinkNode {
	 *     int val;
	 *     TreeLinkNode left, right, next;
	 *     TreeLinkNode(int x) { val = x; }
	 * }
	 */
	public void connect(TreeLinkNode root) {
		if (root!=null) {
			if (root.left!=null) {
				if (root.right!=null) {
	        		root.left.next=root.right;
	        	}
	        	connect(root.left);       	
	        }
	        if (root.right!=null) {
	        	if (root.next!=null) {
	        		root.right.next=root.next.left;
	        	}
	        	connect(root.right);	
	        }
		}            
	}
}
