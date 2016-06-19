package leetcode;
import java.util.LinkedList;
import java.util.List;

import utils.TreeNode;

public class ClosestBinarySearchTreeValueII {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		LinkedList<Integer> results = new LinkedList<Integer>();
		inOrderWalk(root, results, k, target);
		return results;
	}

	private void inOrderWalk(TreeNode root, LinkedList<Integer> results, int k,
			double target) {
		if (root == null) {
			return;
		}

		inOrderWalk(root.left, results, k, target);
		if (!results.isEmpty() && k >= results.size()) {
			if (Math.abs(results.getFirst() - target) > Math.abs(root.val
					- target)) {
				results.pollFirst();
				results.add(root.val);
			}
		}
		inOrderWalk(root.right, results, k, target);
	}
}
