package leetcode;
import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class Q113 {
	int sum;
	List<List<Integer>> results = new ArrayList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return results;
		this.sum = sum;
		pathNodeSum(new ArrayList<Integer>(), root, 0);
		return results;
	}

	@SuppressWarnings("unchecked")
	private void pathNodeSum(List<Integer> currentlist, TreeNode current,
			int currentsum) {
		int currentvalue = currentsum + current.val;
		List<Integer> templist = currentlist;
		templist.add(current.val);
		if (currentvalue == sum && current.left == null && current.right == null)
			results.add((List<Integer>) ((ArrayList<Integer>) templist).clone());
		if (current.left != null) {
			pathNodeSum(templist, current.left, currentvalue);
			templist.remove(templist.size() - 1);
		}
		if (current.right != null) {
			pathNodeSum(templist, current.right, currentvalue);
			templist.remove(templist.size() - 1);
		}
	}
}