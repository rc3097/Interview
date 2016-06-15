package leetcode;
public class Q304 {
	public class NumMatrix {
		int dp[][];

		public NumMatrix(int[][] matrix) {
			int n = matrix.length + 1;
			if (n==1) return;
			int m = matrix[0].length + 1;
			if (m==1) return;
			dp = new int[n][m];
			dp[0][0] = 0;
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < m; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i-1][j-1]
							+ matrix[i-1][j-1];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			return (dp[row2+1][col2+1]-dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1]);
		}
	}
}

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
