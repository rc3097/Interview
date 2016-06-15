package leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q145 {
	public List<Integer> postorderTraversal(TreeNode root) {	
		Stack<TreeNode> tStack = new Stack<TreeNode>();
		TreeNode croot = root;
		List<Integer> results = new ArrayList<Integer>();
		if (root==null) return results;
		tStack.push(root);
		boolean forward = true;
		while (!tStack.isEmpty()) {
			TreeNode parentNode = tStack.peek();
			if (forward && parentNode.left != null) {
				tStack.push(parentNode.left);
				forward = true;
			} else if (forward && parentNode.right != null) {
				tStack.push(parentNode.right);
				forward = true;
			} else {
				forward = false;
				TreeNode sonNode = tStack.pop();
				results.add(sonNode.val);
				if (!tStack.isEmpty() && tStack.peek().right != null && tStack.peek().right!=sonNode) {
					tStack.push(tStack.peek().right);
					forward = true;
				}
			}
		}
		return results;
	}
}