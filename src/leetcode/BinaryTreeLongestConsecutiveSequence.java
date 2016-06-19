package leetcode;

import utils.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
		if (root == null)
			return 0;
		return findLongest(root, root.val-1, 0);
	}

	private int findLongest(TreeNode root, int preval, int length) {
		if (root == null) {
			return 1;
		}
		int currlen = (preval == root.val + 1) ? length + 1 : 1;
		return Math.max(currlen, Math.max(
				findLongest(root.left, root.val, currlen),
				findLongest(root.right, root.val, currlen)));
	}
}
