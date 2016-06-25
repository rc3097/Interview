package linkedin;

import utils.TreeNode;

/*
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
   https://leetcode.com/problems/binary-tree-upside-down/
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root==null) return null;
        return transform(root, new TreeNode(root.val));
    }
    
    private TreeNode transform(TreeNode root, TreeNode curr) {
        if (root.left==null) return curr;
        TreeNode node = new TreeNode(root.left.val);
        node.left = root.right;
        node.right = curr;
        return transform(root.left, node);
    }
}