package leetcode;

public class RangeSumQuery2DMutable {
    public class SegmentTree {
        int x1, y1, x2, y2;
        SegmentTree p1, p2, p3, p4;
        int sum = 0;

        public SegmentTree(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    SegmentTree tree;

    public RangeSumQuery2DMutable(int[][] matrix) {
    }

    public void update(int row, int col, int val) {

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return 0;
    }

    public int updateTree(SegmentTree tree, int row, int col, int val) {
        if (tree.x1 == tree.x2 && tree.y1 == tree.y2) {
            if (row == tree.x1 && col == tree.y1) {
                tree.sum = val;
                return tree.sum;
            }
        }
        int midx = (tree.x1 + tree.x2) / 2;
        int midy = (tree.y1 + tree.y2) / 2;
        if (row < midx && col < midy) {
            //p1

        } else if (row < midx && col >= midy) {
            //p2
        } else if (row >= midx && col < midy) {
            //p3
        } else {
            //p4
        }
        return 0;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);

