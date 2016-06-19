package leetcode;

import utils.TreeNode;

public class ClosestBinarySearchTreeValue {
	public int closetValue(TreeNode root, double target) {
		if (root==null) {
			return Integer.MAX_VALUE;
		}
		int closet = Integer.MAX_VALUE;
		if (target>root.val) {
			closet = closetValue(root.right, target);
		} else {
			closet = closetValue(root.left, target);
		}
		return (int) Math.min(Math.abs(target-root.val),Math.abs(target-closet));
	}
}
