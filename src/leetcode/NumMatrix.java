package leetcode;
public class NumMatrix {
    int m, n;
    int[][] bit, a;
    public NumMatrix(int[][] matrix) {
        n= matrix.length;
        if (n==0) return;
        m = matrix[0].length;
        if (m==0) return;
        bit = new int[n+1][m+1];
        a = new int[n][m];
        for (int i = 0 ; i<n; i++) {
            for (int j=0; j<m; j++) {
                update(i,j,matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - a[row][col];
        a[row][col] = val;
        for (int i = row+1; i<=n; i+=i&-i) {
            for (int j= col+1; j<=m; j+=j & -j) {
                bit[i][j] +=diff; 
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2,col2)+sum(row1-1,col1-1)- sum(row2,col1-1) - sum(row1-1,col2);
    }
    
    private int sum(int row, int col) {
        int res = 0;
        for (int i = row+1; i>0;i-=i& -i) {
            for (int j = col+1; j>0; j-=j& -j) {
                res+=bit[i][j];
            }
        }
        return res;
    }
}