package leetcode;
public class Q115 {
	public int numDistinct(String s, String t) {
		s = s + "&";
		t = t + "&";
		int dp[][] = new int[t.length() + 1][s.length() + 1];
		for (int i = 0; i < s.length() + 1; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < t.length() + 1; i++) {
			for (int j = 1; j < s.length() + 1; j++) {
				dp[i][j] = dp[i][j - 1]
						+ (s.charAt(j - 1) == t.charAt(i - 1) ? dp[i - 1][j - 1]
								: 0);
			}
		}
		
		return dp[t.length()][s.length()];
	}
}
