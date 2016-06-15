package leetcode;
public class Q221 {
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		if (m==0) return 0;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int result = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					int a = 0, b = 0, c = 0;
					if (i - 1 >= 0) {
						a = dp[i - 1][j];
					}
					if (j - 1 >= 0) {
						b = dp[i][j - 1];
					}
					if (i - 1 >= 0 && j - 1 >= 0) {
						c = dp[i-1][j-1];
					}
					dp[i][j] = Math.min(Math.min(a, b), c) + 1;
					if (dp[i][j] > result)
						result = dp[i][j];
				}
			}
		}
		return result*result;
	}
}
