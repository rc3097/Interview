package leetcode;
public class Q72 {
	public int minDistance(String word1, String word2) {
		if (word1.equals("") || word2.equals("")) {
			return Math.max(word1.length(), word2.length());
		}
		int n = word1.length() + 1;
		int m = word2.length() + 1;
		int[][] dp = new int[n][m];

		for (int i = 0; i < m; i++) {
			dp[0][i] = i;
		}

		for (int i = 0; i < n; i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1]
						: Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
								dp[i - 1][j - 1]) + 1;
			}
		}

		return dp[n-1][m-1];
	}
}