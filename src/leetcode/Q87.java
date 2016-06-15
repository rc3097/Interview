package leetcode;
import java.util.HashMap;

public class Q87 {
	public static boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;
		int n = s1.length();
		boolean[][][] dp = new boolean[n + 1][n][n];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; i < n; i++) {
				for (int k = 0; i < n; i++) {
					dp[i][j][k] = false;
				}
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 0; i <= n - k; i++) {
				for (int j = 0; j <= n - k; j++) {
					if (s1.substring(i, i + k).equals(s2.substring(j, j + k))) {
						dp[k][i][j] = true;
					} else {
						for (int l = 1; l < k; l++) {
							dp[k][i][j] = dp[k][i][j]
									|| ((dp[l][i][j] && dp[k - l][i + l][j + l]) || (dp[l][i
											+ k - l][j] && dp[k - l][i][j + l]));
						}
					}
				}
			}
		}
		return dp[n][0][0];
	}

	static HashMap<Pair<String, String>, Boolean> scramblewords = new HashMap<Pair<String, String>, Boolean>();;

	public static boolean isScramble2(String s1, String s2) {
		Pair<String, String> Pairword = new Pair<String, String>(s1, s2);
		if (scramblewords.containsKey(Pairword))
			return scramblewords.get(Pairword);
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2)) {
			scramblewords.put(Pairword, true);
			return true;
		}
		int[] c1 = new int[26];
		int flags = 0, len = s1.length();
		for (int i = 0; i < len; i++) {
			int ch1 = (int) (s1.charAt(i)) - 'a';
			int ch2 = (int) (s2.charAt(i)) - 'a';
			if (ch1 != ch2) {
				if (c1[ch1] == 0) {
					flags |= (1 << ch1);
				} else if (c1[ch1] == -1) {
					flags &= ~(1 << ch1);
				}
				c1[ch1] += 1;
				if (c1[ch2] == 0) {
					flags |= (1 << ch2);
				} else if (c1[ch2] == 1) {
					flags &= ~(1 << ch2);
				}
				c1[ch2] -= 1;
			}
		}
		
		if (flags != 0) return false;   
        if (len <= 3) return true;  

		boolean result = false;
		for (int i = 0; i < s1.length() - 1 && !result; i++) {
			String as1 = s1.substring(0, i + 1);
			String bs1 = s1.substring(i + 1, s1.length());
			String as2 = s2.substring(0, i + 1);
			String bs2 = s2.substring(i + 1, s2.length());
			result |= (isScramble2(as1, as2) && isScramble2(bs1, bs2));
			as2 = s2.substring(s2.length() - i - 1, s2.length());
			bs2 = s2.substring(0, s2.length() - i - 1);
			result |= (isScramble2(as1, as2) && isScramble2(bs1, bs2));
		}
		if (scramblewords.containsKey(Pairword)) {
			result |= scramblewords.get(Pairword);
			scramblewords.put(Pairword, result);
		} else {
			scramblewords.put(Pairword, result);
		}
		return result;
	}

	static class Pair<F, S> {
		F first;
		S second;

		public Pair(F first, S second) {
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {
		System.out.println(isScramble2("abcdefghijklmn", "efghijklmncadb"));
	}
}