package snapchat;

import utils.BSTree;
import utils.BTreePrinter;
import utils.TreeNode;

import java.util.*;
public class TwoSumBST {
	public int[] findPair(TreeNode root, int target) {
		int[] res = new int[2];
		Stack<TreeNode> leftstack = new Stack<TreeNode>();
		Stack<TreeNode> rightstack = new Stack();
		buildLeft(leftstack, root);
		buildRight(rightstack, root);
		TreeNode leftNode = getBigger(leftstack);
		TreeNode rightNode = getSmaller(rightstack);
		while (leftNode!=null && rightNode!=null) {
			if (leftNode == rightNode) return res;
			int currsum = leftNode.val+ rightNode.val;
			if (currsum==target) {
				res[0] = leftNode.val;
				res[1] = rightNode.val;
				return res;
			} else if (currsum<target) {
				leftNode = getBigger(leftstack);
			} else {
				rightNode = getSmaller(rightstack);
			}
		}
		return res;
	}

	private void buildRight(Stack<TreeNode> rightstack, TreeNode root) {
		while (root!=null) {
			rightstack.add(root);
			root= root.right;
		}
	}

	private void buildLeft(Stack<TreeNode> leftstack, TreeNode root) {
		while (root!=null) {
			leftstack.add(root);
			root = root.left;
		}
	}

	private TreeNode getSmaller(Stack<TreeNode> rightstack) {
		if (rightstack.isEmpty()) return null;
		TreeNode node = rightstack.pop();
		TreeNode insertNode = node.left;
		while (insertNode!=null) {
			rightstack.add(insertNode);
			insertNode = insertNode.right;
		}
		return node;
	}

	private TreeNode getBigger(Stack<TreeNode> leftstack) {
		if (leftstack.isEmpty()) return null;
		TreeNode node = leftstack.pop();
		TreeNode insertNode = node.right;
		while (insertNode!=null) {
			leftstack.add(insertNode);
			insertNode = insertNode.left;
		}
		return node;
	}

	public static void main(String[] args) {
		BSTree forest=  new BSTree();
		TwoSumBST q = new TwoSumBST();
		while (forest.hasNext()) {
			TreeNode root = forest.next();
			BTreePrinter.printNode(root);
			System.out.println(Arrays.toString(q.findPair(root, 17)));
		}
	}
}
