package leetcode;
import java.util.Stack;

public class BSTIterator {
	private Stack<TreeNode> stacks;

	public BSTIterator(TreeNode root) {
		stacks = new Stack<TreeNode>();
		while (root != null) {
			stacks.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (stacks.empty()) {
			return false;
		} else {
			return true;
		}
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode topNode = stacks.pop();
		if (topNode.right != null) {
			TreeNode tempNode = topNode.right;
			while (tempNode != null) {
				stacks.push(tempNode);
				tempNode = tempNode.left;
			}
		}
		return topNode.val;
	}
}
