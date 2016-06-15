package leetcode;
public class Q174 {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = Math.max(1, -dungeon[m - 1][n - 1]+1);

		for (int i = n - 2; i >= 0; i--) {
			dp[m-1][i] = Math.max(1, dp[m-1][i+1]-dungeon[m-1][i]);
		}
		
		for (int i = m-2; i >=0; i--) {
			dp[i][n-1] = Math.max(1, dp[i+1][n-1]-dungeon[i][n-1]);
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				int down = Integer.MAX_VALUE;
				int right = Integer.MAX_VALUE;
				if (i + 1 < m) {
					down = dp[i + 1][j];
				}
				if (j + 1 < n) {
					right = dp[i][j + 1];
				}
				dp[i][j] = Math.max(Math.min(down, right) - dungeon[i][j], 1);
			}
		}

		return dp[0][0];
	}
}
