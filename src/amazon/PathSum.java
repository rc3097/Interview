package amazon;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.type.NullType;
import javax.swing.ListModel;

import leetcode.ListNode;
import leetcode.TreeNode;


/*
 * 第一个是给定一个root，找从root到leaves的权值最小的路径。
 */
public class PathSum {
	public List<List<Integer>> pathSum(TreeNode root) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		minSum(res, root);
		return res;
	}

	private int minSum(List<List<Integer>> res, TreeNode root) {
		if (root == null) {
			List<Integer> curr = new ArrayList<Integer>();
			res.add(curr);
			return 0;
		}
		ArrayList<List<Integer>> rightpaths = new ArrayList<List<Integer>>();
		int right = minSum(rightpaths, root.left);

		ArrayList<List<Integer>> leftpaths = new ArrayList<List<Integer>>();
		int left = minSum(leftpaths, root.right);
		res.clear();
		if (right > left) {
			for (List<Integer> path : leftpaths) {
				path.add(root.val);
			}
			res.addAll(leftpaths);
			return left + root.val;
		} else if (right < left) {
			for (List<Integer> path : rightpaths) {
				path.add(root.val);
			}
			res.addAll(rightpaths);
			return right + root.val;
		} else {
			if (root.left == null && root.right == null) {
				for (List<Integer> path : rightpaths) {
					path.add(root.val);
				}
				res.addAll(rightpaths);
				return right + root.val;
			} else {
				for (List<Integer> path : rightpaths) {
					path.add(root.val);
				}
				res.addAll(rightpaths);

				for (List<Integer> path : leftpaths) {
					path.add(root.val);
				}
				res.addAll(leftpaths);
				return left + root.val;
			}
		}
	}
}
