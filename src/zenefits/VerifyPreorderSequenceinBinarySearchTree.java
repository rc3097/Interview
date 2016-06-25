package zenefits;
/*
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.
 */
public class VerifyPreorderSequenceinBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        return verifyPreorder(preorder, 0, preorder.length-1);
    }
    
    private boolean verifyPreorder(int[] preorder, int l, int r) {
        if (l>=r) return true;
        int mid = preorder[l];
        int idx=r;
        for (int i = l+1; i<=r;i++) {
            if (preorder[i]>mid) {
                idx = i-1;
                break;
            }
        }

        for (int i = idx+1; i<=r;i++) 
            if (preorder[i]<mid) return false;
        
        return verifyPreorder(preorder, l+1, idx) && verifyPreorder(preorder, idx+1, r);
    }
}