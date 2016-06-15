package leetcode;
public class Q97 {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length())
			return false;
		int n = s1.length();
		int m = s2.length();
		boolean[][] dp = new boolean[n+1][m+1];
		dp[0][0] = true;
		for (int i = 1; i < n+1; i++) {
			dp[i][0] = dp[i-1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
		}
		for (int j = 1; j < m+1; j++) { 
			dp[0][j] = dp[0][j-1] && s2.charAt(j - 1) == s3.charAt(j - 1);
		}

		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < m+1; j++) {
				dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j])
						|| (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
			}
		}
		
		return dp[n][m];
	}
}