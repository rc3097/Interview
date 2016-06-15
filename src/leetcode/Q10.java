package leetcode;
public class Q10 {
	public static boolean isequal(char s, char p) {
		if (s == p || p == '.')
			return true;
		return false;
	}

	public static boolean isMatch(String s, String p) {
		s = "&" + s + "&";
		p = "&" + p + "&";
		boolean[][] dp = new boolean[s.length()][p.length()];

		dp[0][0] = true;

		for (int j = 1; j < p.length(); j++) {
			for (int i = 1; i < s.length(); i++) {
				if (isequal(s.charAt(i), p.charAt(j)))
					dp[i][j] = dp[i - 1][j - 1];
				else if (p.charAt(j) == '*') {
					int k = i;
					while (k < s.length()
							&& isequal(s.charAt(k), p.charAt(j - 1))) {
						dp[k][j] |= dp[i][j - 1];
						k++;
					}

					for (int l = i; l < k; l++) {
						if (isequal(s.charAt(l), p.charAt(j + 1)))
							dp[l][j + 1] |= dp[i][j - 1];
						else
							break;
					}

					dp[i-1][j] |= dp[i-1][j - 2];
				} else {
					dp[i][j] |= false;
				}
			}

		}
		return dp[s.length() - 1][p.length() - 1];
	}

	public static void main(String[] args) {
		 System.out.println(isMatch("", ".*"));
		 System.out.println(isMatch("aa", "aa"));
		 System.out.println(isMatch("aaa", "aa"));
		 System.out.println(isMatch("aa", "a*"));
		 System.out.println(isMatch("aa", ".*"));
		 System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));
	}
}