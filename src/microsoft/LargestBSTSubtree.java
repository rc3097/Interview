package microsoft;

import utils.TreeNode;

public class LargestBSTSubtree {
	class Nodeval {
		int max;
		int min;
		int count;
		public Nodeval(int min, int max, int count) {
			this.max = max;
			this.min = min;
			this.count = count;
		}
	}
    public int largestBSTSubtree(TreeNode root) {
        isValidBST(root);
        return max;
    }
    private int max = 0;
    private Nodeval isValidBST(TreeNode root) {
        if (root==null) return new Nodeval(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        Nodeval left = isValidBST(root.left);
        Nodeval right = isValidBST(root.right);

        if (left == null || right == null) return null;

        if (root.val>left.max && root.val<right.min) {
        	max = Math.max(max, left.count+right.count+1);
        	return new Nodeval(Math.min(left.min,root.val), Math.max(right.max,root.val),  left.count+ right.count+1 );
        } 
        return null;
    }
}