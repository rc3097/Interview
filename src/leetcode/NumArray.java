package leetcode;
public class NumArray {
    SegmentTree root;
    public NumArray(int[] nums) {
        root = buildSegmentTree(nums,0,nums.length-1);
    }

    void update(int i, int val) {
        update(i,val,root);
    }

    public int sumRange(int i, int j) {
        int result = sumRange(i,j,root);
        return result;
    }
    
    private SegmentTree buildSegmentTree(int[] nums, int start, int end) {
        if (start>end) return null;
        if (start==end) {
            return new SegmentTree(start, end, nums[start]);
        }
        SegmentTree root = new SegmentTree(start, end, 0);
        int mid = (start+end)/2;
        root.left = buildSegmentTree(nums,start,mid);
        root.right = buildSegmentTree(nums, mid+1,end);
        root.val = root.left.val + root.right.val;
        return root;
    }
    
    private void update(int k, int val, SegmentTree root) {
        if (root.low == root.high && root.low == k) {
            root.val = val;
            return ;
        }
        if (k>=root.left.low && k<= root.left.high) {
            update(k,val,root.left);
        } else {
            update(k,val,root.right);
        }
        root.val = root.left.val + root.right.val;
    }
    
    private int sumRange(int l, int r, SegmentTree root) {
        if (root.low == l && root.high == r) {
            return root.val;
        } 
        int mid = (root.low+root.high)/2;
        if (l<=mid && r<=mid) {
            return sumRange(l,r,root.left);
        } else if (mid<l && mid< r) {
            return sumRange(l,r, root.right);
        } else {
            return sumRange(l,mid,root.left)+sumRange(mid+1,r,root.right);
        }
    }
    
    private class SegmentTree {
        int low = 0;
        int high =0;
        int val = 0;
        SegmentTree left=null;
        SegmentTree right=null;
        public SegmentTree(int low, int high, int val) {
            this.low = low;
            this.high = high;
            this.val = val;
        }
    }
    
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);