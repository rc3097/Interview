package utils;

import java.util.ArrayList;
import java.util.Iterator;

public class BSTree implements Iterator<TreeNode>{

	ArrayList<TreeNode> forests= new ArrayList<TreeNode>();
	private int pos;
	public BSTree() {
		//null
		forests.add(null);
		TreeNode root1 = new TreeNode(10);
		TreeNode lNode = new TreeNode(9);
		TreeNode llNode = new TreeNode(8);
		TreeNode lllNode = new TreeNode(7);
		llNode.left = lllNode;
		lNode.left = llNode;
		root1.left = lNode;
		forests.add(root1);
		
		TreeNode root2 = new TreeNode(10);
		forests.add(root2);
		
		TreeNode root3 = new TreeNode(10);
		TreeNode rNode = new TreeNode(11);
		TreeNode rrNode = new TreeNode(12);
		TreeNode rrrNode = new TreeNode(13);
		rrNode.right = rrrNode;
		rNode.right = rrNode;
		root3.right = rNode;
		forests.add(root3);
		
		TreeNode root4 = new TreeNode(11);
		lNode = new TreeNode(8);
		llNode = new TreeNode(7);
		TreeNode lrNode = new TreeNode(10);
		TreeNode lrlNode = new TreeNode(9);
		root4.left = lNode;
		lNode.left = llNode;
		lNode.right = lrNode;
		lrNode.left = lrlNode;
		forests.add(root4);
		
		TreeNode root5 = new TreeNode(11);
		lNode = new TreeNode(5);
		llNode = new TreeNode(4);
		lrNode = new TreeNode(6);
		rNode = new TreeNode(14);
		rrNode = new TreeNode(15);
		TreeNode rlNode = new TreeNode(13);
		root5.left = lNode;
		lNode.left = llNode;
		lNode.right = lrNode;
		rNode.left = rlNode;
		rNode.right = rrNode;
		root5.right = rNode;
		forests.add(root5);
		
		pos = 0;
	}
	@Override
	public boolean hasNext() {
		if (pos<forests.size()) return true;
		return false;
	}

	@Override
	public TreeNode next() {
		return forests.get(pos++);
	}

	@Override
	public void remove() {

	}


}
