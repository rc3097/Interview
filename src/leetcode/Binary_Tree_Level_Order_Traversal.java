package leetcode;
import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;
public class Binary_Tree_Level_Order_Traversal {
	int head = 0;
	int tail = 0;
	ArrayList<TreeNode> queueArrayList;
	List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
		result=new ArrayList<List<Integer>>();
		if (root == null)
			return result; 
		BFSTree(root);
		return result;
	}

	public void BFSTree(TreeNode root) {
		boolean lefttoright=false;
		ArrayList<Integer> levels= new ArrayList<Integer>();
		queueArrayList=new ArrayList<TreeNode>();
		queueArrayList.add(root);
		levels.add(0);
		int currentlevel=-1;
		while (tail <= head) {
			TreeNode tempNode = queueArrayList.get(tail);
			int templevels = levels.get(tail);
			if (tempNode.left != null) {
				head++;
				queueArrayList.add(head, tempNode.left);
				levels.add(templevels + 1);
			}
			if (tempNode.right!=null) {
				head++;
				queueArrayList.add(head, tempNode.right);
				levels.add(templevels + 1);
			}
			if (templevels<=currentlevel) {
				result.get(templevels).add(tempNode.val);
			} else {
				List<Integer> tempArrayList=new ArrayList<Integer>();
				tempArrayList.add(tempNode.val);
				currentlevel++;
				result.add(currentlevel, tempArrayList);			
			}
			tail++;
		}
	}	
}
