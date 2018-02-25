package leetcode;

import utils.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int res = countDepth(root);
        if (res == -1) return false;
        return true;
    }

    private int countDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = countDepth(root.left);
        int rightDepth = countDepth(root.right);
        if (leftDepth == -1 || rightDepth == -1) return -1;
        if (Math.abs(leftDepth - rightDepth) > 1) return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
