package linkedin;

import utils.TreeNode;

import java.util.*;

/*
 * Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].
https://leetcode.com/problems/find-leaves-of-binary-tree/
 */
public class FindLeavesofBinaryTree {
	  class Nodelvl {
	        TreeNode node;
	        int level;
	        public Nodelvl(TreeNode node, int level) {
	            this.node = node;
	            this.level = level;
	        }
	    }
	    public List<List<Integer>> findLeaves(TreeNode root) {
	        ArrayList<Nodelvl> lvls = new ArrayList();
	        travel(lvls, root);
	        Collections.sort(lvls, new Comparator<Nodelvl>(){
	            public int compare(Nodelvl o1, Nodelvl o2) {
	                return o1.level - o2.level;
	            }
	        });
	        
	        ArrayList<List<Integer>> res = new ArrayList();
	        if (root==null) return res;
	        ArrayList<Integer> sub = new ArrayList();
	        for (int i = 0; i+1 < lvls.size();i++) {
	            if (lvls.get(i+1).level !=  lvls.get(i).level) {
	                sub.add(lvls.get(i).node.val);
	                res.add(sub);
	                sub  = new ArrayList();
	            } else {
	                 sub.add(lvls.get(i).node.val);
	            }
	        } 
	        sub.add(root.val);
	        res.add(sub);
	        return res;
	    }
	    
	    public int travel(ArrayList<Nodelvl> lvls, TreeNode root) {
	        if (root==null) return 0;
	        int left = travel(lvls,root.left);
	        int right = travel(lvls,root.right);
	        Nodelvl node = new Nodelvl(root, Math.max(left,right)+1);
	        lvls.add(node);
	        return node.level;
	    }
	}