package leetcode;
import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
		treeQueue.add(root);
		String result="";
		while (!treeQueue.isEmpty()) {
			TreeNode currentNode = treeQueue.poll();
			if (currentNode==null) {
				result+=",#";
				continue;
			}
			result+=","+String.valueOf(currentNode.val);
			treeQueue.add(currentNode.left);
			treeQueue.add(currentNode.right);
		}
		int i;
		for (i=result.length()-1;i>=0;i-=2) {
			if (result.charAt(i)=='#' && result.charAt(i-1)==',') continue;
				else break;
		}
		return result.substring(1,i+1);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
	    if (data.length()==0) return null;
		String[] dataStrings = data.split(",");
		TreeNode  rootNode = new TreeNode(Integer.valueOf(dataStrings[0]));
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(rootNode);
		for (int i = 1; i < dataStrings.length; i+=2) {
			TreeNode currentNode = queue.poll();
			if (!dataStrings[i].equals("#")) {
				currentNode.left = new TreeNode(Integer.valueOf(dataStrings[i]));
				queue.add(currentNode.left);
			} 
			if (i+1<dataStrings.length && !dataStrings[i+1].equals("#")) {
				currentNode.right = new TreeNode(Integer.valueOf(dataStrings[i+1]));
				queue.add(currentNode.right);
			} 
		}
		return rootNode;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));