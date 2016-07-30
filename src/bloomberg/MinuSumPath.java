package bloomberg;

import java.util.*;

import utils.TreeNode;

public class MinuSumPath{
	public int findMin(TreeNode root) {
		if (root==null) return 0;
		int left = findMin(root.left);
		int right  = findMin(root.right);
		return Math.min(left,right)+root.val;
	}
}