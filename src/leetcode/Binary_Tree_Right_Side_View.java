package leetcode;
import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class Binary_Tree_Right_Side_View {
	private int currentdepth;
	private List<Integer> SideView;

	public List<Integer> rightSideView(TreeNode root) {
		currentdepth = -1;
		SideView=new ArrayList<Integer>();
		DFStree(root, 0);
		return SideView;
	}

	private void DFStree(TreeNode root, int depth) {
		if (root != null) {
			if (depth > currentdepth) {
				SideView.add(root.val);
				currentdepth = depth;
			}
			DFStree(root.right, depth + 1);
			DFStree(root.left, depth + 1);
		}
	}
}
