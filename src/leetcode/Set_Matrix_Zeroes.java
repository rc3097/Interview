package leetcode;

public class Set_Matrix_Zeroes {
	public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean zerobycol = false;
        boolean zerobyrow = false;
        for (int i = 0; i < m; i++) {
			if (matrix[i][0]==0) {
				zerobycol=true;
				break;
			}
		}
        for (int i=0; i<n ; i++) {
        	if (matrix[0][i]==0) {
				zerobyrow=true;
				break;
			}
        }
        for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j]==0) {
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
        
        for (int i = 1; i < m; i++) {
			if (matrix[i][0]==0) {
				cleanbyrow(matrix, n, m, n, i);
			}
		}
        
        for (int i = 1; i < n; i++) {
			if (matrix[0][i]==0) {
				cleanbycol(matrix, n, m, i, m);
			}
		}
        
        if (zerobycol) {
        	cleanbycol(matrix, n, m, 0, 0);
        }
        if (zerobyrow) {
        	cleanbyrow(matrix, n, m, 0, 0);
        }
    }
	
	public void cleanbycol(int[][] matrix, int n, int m, int col, int row) {
		for (int i = 0; i < m; i++) {
			matrix[i][col]=0;
		}
	}
	public void cleanbyrow(int[][] matrix, int n, int m , int col, int row) {
		for (int i =0; i<n; i++) {
			matrix[row][i]=0;
		}
	}
}
