package leetcode;
public class Q91 {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		s = "0" + s;
		int[] dp = new int[s.length()];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			int pairnum = Integer.valueOf(s.substring(i - 1, i + 1));
			if (s.charAt(i) != '0') {
				dp[i] = dp[i - 1];
			}
			if (pairnum > 9 && pairnum < 27) {
				dp[i] += dp[i - 2];
			}
			if (pairnum==0) {
				return 0;
			}
		}
		if (s.charAt(1)=='0') return 0;
		return dp[s.length() - 1];
	}
}